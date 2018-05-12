package controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.IUsersService;
import util.CodeUtil;
import util.Coder;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

@Controller
@SessionAttributes("darkPassword")
public class IndexController {
	Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcome() {
		log.info("/index");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome - Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/devLog", method = RequestMethod.GET)
	public ModelAndView admin() {
		log.info("/devLog");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Admin - Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("devLog");

		return model;

	}
	
	/**
	 * This update page is for user login with password only.
	 * If user is login via remember me cookie, send login to ask for password again.
	 * To avoid stolen remember me cookie to update info
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView updatePage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();

		if (isRememberMeAuthenticated()) {
			//send login for update
			setRememberMeTargetUrlToSession(request);//记录之前的页面
			model.addObject("loginUpdate", true);
			model.addObject("msg", "当前页面不支持自动登录,请手动登录");
			
			model.setViewName("/login");
			
		} else {
			model.setViewName("/Admin/indexAdmin");
		}

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request,Model models) throws Exception {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			log.info("登录出现错误:" + getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
			
			//if login error, get the targetUrl from session again.
			String targetUrl = getRememberMeTargetUrlFromSession(request);
			log.info("targetUrl:"+targetUrl);
			if(StringUtils.hasText(targetUrl)){
				model.addObject("targetUrl", targetUrl);
				model.addObject("loginUpdate", true);
			}
		}

		if (logout != null) {
			model.addObject("msg", "登出成功.");
			// model.setViewName("model");
			// return model;
		}
		
		
		
		model.setViewName("Login/login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "用户名或者密码错误!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
			// error = "密码输入错误次数过多,帐号已经锁定!请联系管理员解锁!";
		} else {
			error = "用户名或者密码错误!";
		}

		return error;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:login?logout";// You can redirect wherever you want,
										// but generally it's a good practice to
										// show login screen again.
	}

	// for 403 access denied page
	@RequestMapping(value = "/accesssDenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("Common/accesssDenied");
		return model;
	}

	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public ModelAndView toRegister(@RequestParam(value = "error", required = false) String error) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "注册失败!");
		}

		model.setViewName("Login/register");

		return model;

	}

	@Autowired
	private IUsersService usersService;

	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		log.info("register:start");
		Users users = new Users();
		users.setUsername(request.getParameter("username"));
		String darkPassword = request.getParameter("darkPassword");
		users.setDarkPassword(new BigInteger(Coder.encryptMD5(darkPassword.getBytes())).toString(16));
		users.setPassword(CodeUtil.enCodeWithBCrypt(request.getParameter("password")));
		users.setEnabled(1);
		users.setCredentialsNonExpired(1);
		users.setAccountNonLocked(1);
		users.setAccountNonExpired(1);
		int i = usersService.insert(users);
		log.info("i:" + i);
		if (i != 1) {
			model.addAttribute("error", "注册失败,用户名已经存在!");
			return "Login/register";
		} else {
			i = usersService.defaultRole(users);
			if (i != 1) {
				model.addAttribute("error", "注册失败,权限添加出错!");
				return "Login/register";
			}
		}

		model.addAttribute("msg", "注册成功!请登录.");
		return "Login/login";

	}
	
	
	/**
	 * Check if user is login by remember me cookie, refer
	 * org.springframework.security.authentication.AuthenticationTrustResolverImpl
	 */
	private boolean isRememberMeAuthenticated() {

		Authentication authentication = 
                    SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}

		return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}
	
	/**
	 * save targetURL in session
	 */
	private void setRememberMeTargetUrlToSession(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.setAttribute("targetUrl", "/admin");
		}
	}

	/**
	 * get targetURL from session
	 */
	private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
		String targetUrl = "";
		HttpSession session = request.getSession(false);
		if(session!=null){
			targetUrl = session.getAttribute("targetUrl")==null?""
                             :session.getAttribute("targetUrl").toString();
		}
		return targetUrl;
	}
	
	

}
