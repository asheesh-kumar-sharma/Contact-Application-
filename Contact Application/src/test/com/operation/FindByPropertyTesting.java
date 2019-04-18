package test.com.operation;

import java.util.List;

import in.capp.dao.UserDaoImpl;
import in.capp.domain.User;

public class FindByPropertyTesting {

	public static void main(String args[])
	{
         UserDaoImpl ud=new UserDaoImpl();
		
		List<User> list=ud.findByProperty("userId", 6);
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
	}
}
