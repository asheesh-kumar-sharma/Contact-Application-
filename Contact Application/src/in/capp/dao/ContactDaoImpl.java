package in.capp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.capp.domain.Contact;
import in.capp.domain.User;

public class ContactDaoImpl extends Db implements ContactDao {

	@Override
	public void save(Contact c) {
	
		
		Connection con=getConnection();
		try
		{
		
		String sql="insert into contact(userId, name, phone, email, address, remark) values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,c.getUserId().intValue() );
		ps.setString(2, c.getName());
		ps.setString(3,c.getPhone());
		ps.setString(4, c.getEmail());
		ps.setString(5,c.getAddress());
		ps.setString(6,c.getRemark());
		ps.executeUpdate();
		
		}
		catch (Exception e) {
	
		  System.out.println(e);
		}
		
		
	}

	@Override
	public void update(Contact c) {
	

	    
	        Connection con=getConnection();  
	        try{ 
	        PreparedStatement ps=con.prepareStatement("update contact set name=?, phone=?, email=?, address=?, remark=? where contactId=?");  
	     //   ps.setInt(1,c.getUserId().intValue() );
			ps.setString(1, c.getName());
			ps.setString(2,c.getPhone());
			ps.setString(3, c.getEmail());
			ps.setString(4,c.getAddress());
			ps.setString(5,c.getRemark());
			ps.setInt(6, c.getContactId().intValue());
	          
	        ps.executeUpdate();
		    
	     }
	    catch(Exception e){
	    	System.out.println(e);
	    	}  
	
	
		
	}

	@Override
	public void delete(Contact c) {
	
		this.delete(c.getContactId());
	}

	@Override
	public void delete(Integer contactId) {
	
		
		 Connection con=getConnection();  
	       try
	       {
	       PreparedStatement ps=con.prepareStatement("delete from contact where contactId=?"); 
	       ps.setInt(1, contactId.intValue());
	       ps.executeUpdate();
	       }
	       catch (Exception e) {
		
	       System.out.println(e);
	       }
	}

	@Override
	public Contact findById(Integer userId) {
	
		Connection con=getConnection();
		Contact c=null;	    
	    
		try
		{
			String sql="select *from contact  where contactId=?";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ps.setInt(1,userId);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	c=new Contact();
				c.setUserId(rs.getInt("contactId"));
		    	c.setName(rs.getString("userId"));
		    	c.setName(rs.getString("name"));
		    	c.setPhone(rs.getString("phone"));
		    	c.setEmail(rs.getString("email"));
		    	c.setAddress(rs.getString("address"));
		    	c.setRemark(rs.getString("remark"));
		    	
		    	
		    }
		    
			
		}
		catch (Exception e) {
		System.out.println(e);
		}
		return c;
	
	
	}

	@Override
	public List<Contact> findAll() {
	
		Connection con=getConnection();
		Contact c=null;	    
	    List<Contact> list=new ArrayList<>();
		try
		{
			String sql="select *from contact  where contactId=?";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	c=new Contact();
				c.setUserId(rs.getInt("contactId"));
		    	c.setName(rs.getString("userId"));
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
	public List<Contact> findByProperty(String proName, Object propValue) {
		
		String sql="select *from contact where "+proName+"=?";
	       Connection con=getConnection();
	       List<Contact> list=new ArrayList<>();
		   Contact c=null;
	       try
	       {
	    	   PreparedStatement ps=con.prepareStatement(sql);
	    	   ps.setString(1, propValue.toString());
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

	
}
