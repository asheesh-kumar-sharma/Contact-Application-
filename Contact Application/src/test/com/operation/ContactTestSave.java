package test.com.operation;

import in.capp.dao.ContactDaoImpl;
import in.capp.domain.Contact;

public class ContactTestSave {

	public static void main(String args[])
	{
	Contact c=new Contact();
	//c.setContactId(1);
	 c.setUserId(6); 
	 c.setName("anurag");
	c.setPhone("9918571198");
	 c.setEmail("asheesh@gmail.com");
	 c.setAddress("hardoi");
	 c.setRemark("school friend");
    ContactDaoImpl cot=new ContactDaoImpl();
    cot.save(c);
	
	}
	
}
