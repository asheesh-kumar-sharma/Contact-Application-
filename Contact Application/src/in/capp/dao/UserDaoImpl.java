package in.capp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.capp.domain.User;

public class UserDaoImpl extends Db implements UserDao  {
	
	
	public  void save(User u)
	{
		try
		{
		Connection con=getConnection();
		String sql="insert into user(`name`, `phone`, `email`, `address`, `loginName`, `password`, `role`, `loginStatus`) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getName());
		ps.setString(2, u.getPhone());
		ps.setString(3,u.getEmail());
		ps.setString(4, u.getAddress());
		ps.setString(5,u.getLoginName());
		ps.setString(6,u.getPassword());
		ps.setInt(7,u.getRole().intValue());
        ps.setInt(8, u.getLoginStatus().intValue());
        ps.executeUpdate();
		
		}
		catch (Exception e) {
	
		  System.out.println(e);
		}
	}
	public void update(User u)
	{
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement(  
		"update user set name=?, phone=?, email=?, address=?, loginName=?, password=?, role=?, loginStatus=? where userId=?");  
		        ps.setString(1, u.getName());
				ps.setString(2, u.getPhone());
				   
				ps.setString(3,u.getEmail());
				ps.setString(4, u.getAddress());
					
				ps.setString(5,u.getLoginName());
					
				ps.setString(6,u.getPassword());
					
				ps.setInt(7,u.getRole().intValue());
					
					
				ps.setInt(8, u.getLoginStatus().intValue());
		        ps.setInt(9,u.getUserId().intValue());
		          
		        ps.executeUpdate();
			    
		     }
		    catch(Exception e){
		    	System.out.println(e);
		    	}  
		
		
	}
	public void delete(User u)
	{
	
	 	this.delete(u.getUserId());
		
		
	}
   public void delete(Integer  userId)
  {
       Connection con=getConnection();  
       try
       {
       PreparedStatement ps=con.prepareStatement("delete from user where userId=?"); 
       ps.setInt(1, userId.intValue());
       ps.executeUpdate();
       }
       catch (Exception e) {
	
       System.out.println(e);
       }
	}
	public User findById(Integer userId)
	{		
	
		Connection con=getConnection();
		User u=new User();
	    
	    
		try
		{
			String sql="select *from user  where userId=?";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ps.setInt(1,userId);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
				u.setUserId(rs.getInt("userId"));
		    	u.setName(rs.getString("name"));
		    	u.setPhone(rs.getString("phone"));
		    	u.setEmail(rs.getString("email"));
		    	u.setAddress(rs.getString("address"));
		    	u.setLoginName(rs.getString("loginName"));
		    	u.setPassword(rs.getString("password"));
		    	u.setRole(rs.getInt("role"));
		    	u.setLoginStatus(rs.getInt("loginStatus"));
		    	
		    }
		    
			
		}
		catch (Exception e) {
		System.out.println(e);
		}
		return u;
		
	
	}
	public List<User> findAll()
	{
		Connection con=getConnection();
		User u=null;
	    List<User> list=new ArrayList<>();
	    
		try
		{
			String sql="select *from user";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	u=new  User();
				u.setUserId(rs.getInt("userId"));
		    	u.setName(rs.getString("name"));
		    	u.setPhone(rs.getString("phone"));
		    	u.setEmail(rs.getString("email"));
		    	u.setAddress(rs.getString("address"));
		    	u.setLoginName(rs.getString("loginName"));
		    	u.setPassword(rs.getString("password"));
		    	u.setRole(rs.getInt("role"));
		    	u.setLoginStatus(rs.getInt("loginStatus"));
		    	list.add(u);
		    }
		    
			
		}
		catch (Exception e) {
		System.out.println(e);
		}
		return list;
		
		
		
		
		
	}
    public List<User> findByProperty(String proName,Object propValue)
	{
    	String sql="select *from user where "+proName+"=?";
       Connection con=getConnection();
       List<User> list=new ArrayList<>();
	   User u=null;
       try
       {
    	   PreparedStatement ps=con.prepareStatement(sql);
    	   ps.setString(1, propValue.toString());
    	   ResultSet rs=ps.executeQuery();
    	    while(rs.next())
    	    {
    	    	u=new  User();
				u.setUserId(rs.getInt("userId"));
		    	u.setName(rs.getString("name"));
		    	u.setPhone(rs.getString("phone"));
		    	u.setEmail(rs.getString("email"));
		    	u.setAddress(rs.getString("address"));
		    	u.setLoginName(rs.getString("loginName"));
		    	u.setPassword(rs.getString("password"));
		    	u.setRole(rs.getInt("role"));
		    	u.setLoginStatus(rs.getInt("loginStatus"));
		    	list.add(u);
    	    	
    	    }
       }
       catch (Exception e) {
	
       System.out.println(e);
       }
       return list;
		  
	
    	
	}
	
	
}
