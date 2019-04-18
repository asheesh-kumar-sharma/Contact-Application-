package test.com.operation;

import in.capp.dao.UserDaoImpl;
import in.capp.domain.User;

public class TestUpdate {

	
	public static void main(String args[])
	{
		
		User u=new User();
		u.setUserId(1);
		u.setName("asheesh");
		
		u.setPhone("8851246055");
		u.setEmail("aaks050798@gmail.com");
		u.setAddress("kanpur");
		u.setRole(1);
		u.setLoginStatus(2);
		u.setLoginName("asheesh1234");
		u.setPassword("asheesh1234");
	
		//u.set
		
		UserDaoImpl ud=new UserDaoImpl();
		
		ud.update(u);
		
		System.out.println("udated......");
	}
}

