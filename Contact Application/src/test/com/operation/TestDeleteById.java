package test.com.operation;

import in.capp.dao.UserDaoImpl;
import in.capp.domain.User;

public class TestDeleteById {

	
	public static void main(String args[])
	{
		
		//User u=new User();
			
		UserDaoImpl ud=new UserDaoImpl();
		
		ud.delete(4);;
		
		System.out.println("deleted......");
	}
}

