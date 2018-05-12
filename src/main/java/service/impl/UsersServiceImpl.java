package service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsersMapper;
import model.Users;
import service.IUsersService;

@Service("Susers")
public class UsersServiceImpl implements IUsersService {
	
	private UsersMapper usersMapper;
	
	
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	@Autowired
	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}


	@Override
	public int insert(Users users) {
		int i=0;
		try {
			i=usersMapper.insert(users);
		} catch (Exception e) {
			return 0;
		}
		
		return i;
	}

	@Override
	public int defaultRole(Users users) {
		int i=0;
		try {
			i=usersMapper.defaultRole(users);
		} catch (Exception e) {
			return 0;
		}
		
		return i;
	}

	@Override
	public Users getUsers(String username) {
		return usersMapper.selectByUsername(username);
	}
    
    


    
}