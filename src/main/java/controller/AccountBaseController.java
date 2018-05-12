package controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountBase;
import model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

import service.IAccountBaseService;
import service.IUsersService;
import util.CodeUtil;
import util.Coder;
import util.PBECoder;

/**
 * 账户类主要控制器
 * @author Dice
 *
 */
@Controller
@RequestMapping("/AccountBase")
@SessionAttributes("darkPassword")
public class AccountBaseController {
	@Autowired
	private IAccountBaseService accountService;
	@Autowired
	private IUsersService usersService;
	Log log=LogFactory.getLog(getClass());
	@RequestMapping("/showAll")
	public String showAll(Model model) throws Exception {
		log.info("showAll:start");
		AccountBase accountBase = new AccountBase();
		accountBase.setUsername(getUserName());
		log.info("accountBase:"+accountBase);
		List<AccountBase> listAccountBase = accountService.loadAccountBases(accountBase);
		log.info("listAccountBase:"+listAccountBase);
		model.addAttribute("listAccountBase", deCode(listAccountBase,getDarkPassword(model)));// 为JSP页面添加内容
		return "Account/showAccountBase";// JSP页面名称
	}

	@RequestMapping("/index")
	public String index(Model model) {
		log.info("index:start");
		return "Account/indexAccountBase";// JSP页面名称
	}
	
	@RequestMapping("/updateDark")
	public String updateDark(HttpServletRequest request,Model model) {
		log.info("updateDark:start");
		String inputDarkPassword=request.getParameter("darkPassword");
		String stringInputDarkPassword="";
		String MD5DarkPassword="";
		Users users = new Users();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail=null;
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			userDetail = (UserDetails) auth.getPrincipal();
		}
		users=usersService.getUsers(userDetail.getUsername());
		MD5DarkPassword=users.getDarkPassword();
		
		
		try {
			stringInputDarkPassword=new BigInteger(Coder.encryptMD5(inputDarkPassword.getBytes())).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (MD5DarkPassword.equals(stringInputDarkPassword)) {
			model.addAttribute("darkPassword",request.getParameter("darkPassword"));
		}else {
			model.addAttribute("error","暗码校检失败!");
		}
		
		return "Account/indexAccountBase";// JSP页面名称
	}

	@RequestMapping("/findByName")
	public String findByName(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		log.info("findByName:start");
		String name = request.getParameter("name");
		log.info("findByName:name:"+name);
		AccountBase accountBase = new AccountBase();
		accountBase.setName("%"+name+"%");
		accountBase.setUsername(getUserName());
		List<AccountBase> listAccountBase = accountService.loadAccountBasesByName(accountBase);
		model.addAttribute("listAccountBase", deCode(listAccountBase,getDarkPassword(model)));// 为JSP页面添加内容
		return "Account/showAccountBase";// JSP页面名称
	}

	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		log.info("insert:start");
		byte[] salt = PBECoder.initSalt();
		AccountBase accountBase = new AccountBase(); 
		accountBase.setName(request.getParameter("name"));
		accountBase.setKind(request.getParameter("kind"));
		accountBase.setAccount(request.getParameter("account"));
		accountBase.setPassword(CodeUtil.enCode(request.getParameter("password"),getDarkPassword(model),salt));
		accountBase.setAnnotation(request.getParameter("annotation"));
		accountBase.setSalt(salt);
		accountBase.setUsername(getUserName());
		accountService.insert(accountBase);
		
		// 重新查询
		List<AccountBase> listAccountBase = accountService.loadAccountBases(accountBase);
		model.addAttribute("listAccountBase", deCode(listAccountBase,getDarkPassword(model)));// 为JSP页面添加内容
		return "Account/showAccountBase";// JSP页面名称
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("toInsert:start");
		return "./Account/insertAccountBase";// JSP页面名称
	}

	@RequestMapping("/deleteByID")
	public String deleteByID(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		log.info("deleteByID:start");
		String id = request.getParameter("ID");
		AccountBase accountBase = new AccountBase();
		accountBase.setId(Integer.parseInt(id));
		accountBase.setUsername(getUserName());
		accountService.deleteByID(accountBase);

		// 重新查询
		List<AccountBase> listAccountBase = accountService.loadAccountBases(accountBase);
		model.addAttribute("listAccountBase", deCode(listAccountBase,getDarkPassword(model)));// 为JSP页面添加内容
		return "Account/showAccountBase";// JSP页面名称
	}

	@RequestMapping("/toModifyByID")
	public String toModifyByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("toModifyByID:start");
		AccountBase accountBase = new AccountBase();
		accountBase.setId(Integer.parseInt(request.getParameter("ID")));
		accountBase.setName(request.getParameter("name"));
		accountBase.setKind(request.getParameter("kind"));
		accountBase.setAccount(request.getParameter("account"));
		accountBase.setPassword(request.getParameter("password"));
		accountBase.setAnnotation(request.getParameter("annotation"));
		accountBase.setUsername(getUserName());
		model.addAttribute("AccountBase", accountBase);// 为JSP页面添加内容

		return "./Account/modifyAccountBase";// JSP页面名称
	}

	@RequestMapping("/modifyByID")
	public String modifyByID(HttpServletRequest request, HttpServletResponse response, Model model,@ModelAttribute String darkPassword) throws Exception {
		log.info("modifyByID:start");
		log.info("darkPassword:"+darkPassword);
		byte[] salt = PBECoder.initSalt();
		AccountBase accountBase = new AccountBase();
		accountBase.setId(Integer.parseInt(request.getParameter("ID")));
		accountBase.setName(request.getParameter("name"));
		accountBase.setKind(request.getParameter("kind"));
		accountBase.setAccount(request.getParameter("account"));
		accountBase.setPassword(CodeUtil.enCode(request.getParameter("password"),getDarkPassword(model),salt));
		accountBase.setAnnotation(request.getParameter("annotation"));
		accountBase.setUsername(getUserName());
		accountBase.setSalt(salt);
		accountService.modifyByID(accountBase);

		// 重新查询
		List<AccountBase> listAccountBase = accountService.loadAccountBases(accountBase);
		model.addAttribute("listAccountBase", deCode(listAccountBase,getDarkPassword(model)));// 为JSP页面添加内容
		return "Account/showAccountBase";// JSP页面名称
	}
	
	public List<AccountBase> deCode(List<AccountBase> listAccountBase,String darkPassword) throws Exception {
		List<AccountBase> listAccountBaseDecode=new ArrayList<AccountBase>();
		for (AccountBase accountBase : listAccountBase) {
			AccountBase accountBaseDecode=accountBase;
			if (accountBase.getPassword() == null || accountBase.getPassword().isEmpty()) {
			
			}else {
				byte[] inputdata = PBECoder.decryptBASE64(accountBase.getPassword());
				byte[] output = PBECoder.decrypt(inputdata, darkPassword, accountBase.getSalt());
				String outputStr = new String(output);
				accountBaseDecode.setPassword(outputStr);
				listAccountBaseDecode.add(accountBaseDecode);
			}
		}
		return listAccountBaseDecode;

	}
	
	public String getUserName()
	{
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 UserDetails userDetail = (UserDetails) auth.getPrincipal();
		 return userDetail.getUsername();
	}
	
	public String getDarkPassword(Model model)
	{
		if (model.containsAttribute("darkPassword")) {
			Map<String, Object> modelMap = model.asMap();
			return modelMap.get("darkPassword").toString();
		}
		return null;
	}
	
	
}
