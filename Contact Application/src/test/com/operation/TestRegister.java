package test.com.operation;

import in.capp.domain.User;
import in.capp.service.UserService;
import in.capp.service.UserServiceImpl;

public class TestRegister {

	public static void main(String args[])
	{
	
	    User u=new User();
		u.setName("aman");
		
		u.setPhone("9000500045");
		u.setEmail("tks1@gmail.com");
		u.setAddress("bihar");
		u.setLoginName("aman123");
		u.setPassword("aman123");
		u.setRole(UserService.ROLE_ADMIN);
		u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		
	
       UserServiceImpl service=new UserServiceImpl();
		service.register(u);
		 // UserDaoImpl dao=new UserDaoImpl();
		  //dao.save(u);
       System.out.println("register/////////");
	}
}
