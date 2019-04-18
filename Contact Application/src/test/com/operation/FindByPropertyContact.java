package test.com.operation;

import java.util.List;

import in.capp.dao.ContactDaoImpl;
import in.capp.dao.UserDaoImpl;
import in.capp.domain.Contact;
import in.capp.domain.User;

public class FindByPropertyContact {

	public static void main(String[] args) {
	
		 ContactDaoImpl cd=new ContactDaoImpl();
			
			List<Contact> list=cd.findByProperty("contactId", 1);
			System.out.println("details......");
			
			for(Contact u:list)
			{
			System.out.print(u.getContactId()+" ");
	
			System.out.print(u.getUserId()+" ");
			System.out.print(u.getName()+" ");
			System.out.print(u.getAddress()+" ");
			System.out.print(u.getPhone()+" ");
			System.out.println(u.getRemark()+" ");
			}
	}

}
