package test.com.operation;

import java.util.List;

import in.capp.dao.UserDaoImpl;
import in.capp.domain.User;

public class TestFindAll {

	
	public static void main(String args[])
	{
		
		//User u=new User();
			
		UserDaoImpl ud=new UserDaoImpl();
		
		List<User> list=ud.findAll();
		System.out.println("details......");
		
		for(User u:list)
		{
		System.out.print(u.getName()+" ");
		System.out.print(u.getEmail()+" ");
		System.out.print(u.getPhone()+" ");
		System.out.print(u.getLoginName()+" ");
		System.out.print(u.getLoginStatus()+" ");
		System.out.println(u.getRole()+" ");
		}
//		System.out.println(u.getUserId());
//		System.out.println(u.getUserId());
//		
	}
}

