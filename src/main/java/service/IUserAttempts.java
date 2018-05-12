package service;


import model.UserAttempts;

public interface IUserAttempts {
	void updateFailAttempts(String username);
	
    void resetFailAttempts(String username);
	
    UserAttempts getUserAttempts(String username);
}
