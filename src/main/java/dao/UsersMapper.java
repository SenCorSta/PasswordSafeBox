package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.UserAttempts;
import model.Users;

public interface UsersMapper {

	@Insert(value = {
			"insert into t_users (username,password,darkPassword,enabled,accountNonExpired,accountNonLocked,credentialsNonExpired) VALUES (#{username},#{password},#{darkPassword},#{enabled},#{accountNonExpired},#{accountNonLocked},#{credentialsNonExpired})" })
	int insert(Users users);

	@Insert(value = { "insert into t_user_roles (username,role) VALUES (#{username},'Acc_AB')" })
	int defaultRole(Users users);

	@Select(value = { "select * from t_users where username=#{username}" })
	Users selectByUsername(String username);


	@Update(value = {
	"update t_user_attempts set attempts=0 where username=#{username}" })
	void resetFailAttempts(String username);

	@Select(value = { "select * from t_user_attempts where username=#{username}" })
	UserAttempts getUserAttempts(String username);
	
	@Select(value = { "select count(*) from t_user_attempts where username=#{username}" })
	int getUserAttemptsCount(String username);

	@Select(value = { "select count(username) from t_users where username=#{username}" })
	int countUser(String username);
	
	@Insert(value = {
	"insert into t_user_attempts (username,attempts,lastModified,lastIP) VALUES (#{username},#{attempts},#{lastModified},#{lastIP})" })
	void insertAttempts(UserAttempts user);
	
	@Update(value = {
	"update t_user_attempts set attempts=#{attempts},lastModified=#{lastModified},lastIP=#{lastIP} where username=#{username}" })
	void updateAttempts(UserAttempts user);
	
	@Update(value = {
	"update t_users set accountNonLocked=0 where username=#{username}" })
	void lockedUser(String username);
}
