package service;



import model.Users;

public interface IUsersService {


	int insert(Users users);
	

	int defaultRole(Users users);


	Users getUsers(String username);

	
}
