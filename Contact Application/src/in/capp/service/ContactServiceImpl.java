package in.capp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.capp.dao.ContactDaoImpl;
import in.capp.dao.Db;
import in.capp.domain.Contact;
import in.capp.util.StringUtill;
@Service
public class ContactServiceImpl extends Db implements ContactService {

	 ContactDaoImpl contactDao=new ContactDaoImpl();
	@Override
	public void save(Contact c) {
	
		contactDao.save(c);
	}

	@Override
	public void update(Contact c) {
		
		contactDao.update(c);
		
	}

	@Override
	public void delete(Integer contactId) {
	
		contactDao.delete(contactId);
	}

	@Override
	public void delete(Integer[] contactIds) {
	
		String ids=StringUtill.toCommaSeperatedString(contactIds);
		String sql="delete from contact where contactId IN("+ids+")";
	Connection con=getConnection();
	try
	{
	PreparedStatement ps=con.prepareStatement(sql);
	   ps.executeUpdate();
	
	}catch (Exception e) {
    System.out.println(e);
	}
	
	
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		
		return  contactDao.findByProperty("userId", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String text) {
	
		
		String sql="select contactId,userId,name,phone,email,address,remark from contact where userId=? AND (name like '%"+text+"%' or address like '%"+text+"%' or phone like '%"+text+"%' or email like '%"+text+"%' or remark like '%"+text+"%' ) ";
	    List<Contact> list=new ArrayList<>();
		try
	    {
			Contact c=null;
	    	Connection con=getConnection();
	    	PreparedStatement ps=con.prepareStatement(sql);
	    	ps.setInt(1,userId);
	    	ResultSet rs=ps.executeQuery();
	    	while(rs.next())
    	    {
    	    	c=new  Contact();
				c.setContactId(rs.getInt("contactId"));
		    	c.setUserId(rs.getInt("userId"));
		    	c.setName(rs.getString("name"));
		        c.setPhone(rs.getString("phone"));
		        c.setEmail(rs.getString("email"));
		        c.setAddress(rs.getString("address"));
		    	c.setRemark(rs.getString("remark"));
		    	list.add(c);
    	    	
    	    }
	    
	    	
	    }
		catch (Exception e) {
       System.out.println(e);
		}
		return list;
	
	}

	@Override
	public Contact findById(Integer contactId) {
	
      return contactDao.findById(contactId);
	
	}
	

	
	
}
