package security;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import model.UserAttempts;
import service.IUserAttempts;

@Component("authenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {
	// @Autowired
	// private HttpServletRequest request;

	IUserAttempts userAttemptsDao;

	public IUserAttempts getUserAttemptsDao() {
		return userAttemptsDao;
	}

	public void setUserAttemptsDao(IUserAttempts userAttemptsDao) {
		this.userAttemptsDao = userAttemptsDao;
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		try {

			Authentication auth = super.authenticate(authentication);

			// if reach here, means login success, else exception will be thrown
			// reset the user_attempts
			userAttemptsDao.resetFailAttempts(authentication.getName());

			return auth;

		} catch (BadCredentialsException e) {

			userAttemptsDao.updateFailAttempts(authentication.getName());
			throw e;

		} catch (LockedException e) {

			String error = "";
			UserAttempts userAttempts = userAttemptsDao
					.getUserAttempts(authentication.getName());
			if (userAttempts != null) {
				Date lastAttempts = userAttempts.getLastModified();
				SimpleDateFormat dateFormater = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				error = "此账号已被冻结! <br><br>用户名 : "
						+ authentication.getName() + "<br>冻结时间 : "
						+ dateFormater.format(lastAttempts) + "<br>IP:"
						+ userAttempts.getLastIP();
			} else {
				error = e.getMessage();
			}

			throw new LockedException(error);
		}

	}

}
