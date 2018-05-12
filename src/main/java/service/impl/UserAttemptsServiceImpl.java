package service.impl;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dao.UsersMapper;
import model.UserAttempts;
import service.IUserAttempts;
import util.RequestUtil;

public class UserAttemptsServiceImpl extends JdbcDaoSupport implements IUserAttempts{
	@Autowired
	private UsersMapper usersMapper;
	
	private static final int MAX_ATTEMPTS = 5;
	
	@Override
	public void updateFailAttempts(String username) {
		UserAttempts user = getUserAttempts(username);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
        if (user == null) {
            if (isUserExists(username)) {
            	
            	user=new UserAttempts();
            	user.setUsername(username);
            	user.setAttempts(1);
            	user.setLastModified(new Date());
            	user.setLastIP(RequestUtil.getIpAddr(request));
            	
            	usersMapper.insertAttempts(user);
            	
            }
        } else {

            if (isUserExists(username)) {
            	user.setAttempts(user.getAttempts()+1);
            	user.setLastModified(new Date());
            	user.setLastIP(RequestUtil.getIpAddr(request));
            	usersMapper.updateAttempts(user);
            }

            if (user.getAttempts() + 1 > MAX_ATTEMPTS) {
                // locked user
            	usersMapper.lockedUser(username);
                // throw exception
                throw new LockedException("账号已经被冻结!");
            }

        }
	}

	private boolean isUserExists(String username) {
		boolean result = false;

        int count = usersMapper.countUser(username);
        if (count > 0) {
            result = true;
        }

        return result;
	}

	@Override
	public void resetFailAttempts(String username) {
		usersMapper.resetFailAttempts(username);
	}

	@Override
	public UserAttempts getUserAttempts(String username) {
		UserAttempts userAttempts=new UserAttempts();
		if (usersMapper.getUserAttemptsCount(username)>=0) {
			userAttempts=usersMapper.getUserAttempts(username);
		}else {
			return null;
		}
		return userAttempts;
	}
}
