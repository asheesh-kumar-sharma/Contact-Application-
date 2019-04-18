package in.capp.service;

import java.util.List;

import in.capp.domain.User;
import in.capp.exception.UserBlockedException;

public interface UserService {

	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	public void register(User u);
	/*
	 *this methode will handle login(authentication)  it returns user object when success ,otherwise return null  
	 * 
	 * when user is blocked UserBlockedException thrown by this method
	 */
	public User login(String loginName,String password)throws UserBlockedException;
	
	/*
	 * this will return whole list of users
	 * 
	 * 
	 */
	public List<User> getUserList();
	
	
	
	public void changeStatus(Integer userId,Integer loginStatus);
	
	public boolean isUsernameExist(String username);
	
	
	
}
