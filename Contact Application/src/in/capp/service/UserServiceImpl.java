package in.capp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import in.capp.dao.Db;
import in.capp.dao.UserDao;
import in.capp.dao.UserDaoImpl;
import in.capp.domain.User;
import in.capp.exception.UserBlockedException;
@Service
public class UserServiceImpl extends Db implements UserService{
	 UserDaoImpl userDao = new  UserDaoImpl();
		
	@Override
	public void register(User u) {
		 UserDaoImpl userDao = new  UserDaoImpl();
	   userDao.save(u);
		
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
	   //select userId,name , phone ,email ,address,role, loginStatus ,loginName
		String sql="select *from user where loginName=? and password=?";
		Connection con=getConnection();
		try
		{
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginName);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			User u=new User();
		    boolean ans=rs.next();
		System.out.println(ans);
			if(ans==true)
			{
			
				
				//System.out.println("111");
				u.setUserId(rs.getInt("userId"));
				u.setName(rs.getString("name"));
				//System.out.println(u.getUserId()+" "+u.getName());
		        
				u.setPhone(rs.getString("phone"));
				//System.out.println(u.getPhone());
				u.setEmail(rs.getString("email"));
				u.setAddress(rs.getString("address"));
				//System.out.println(u.getAddress());
				u.setRole(rs.getInt("role"));
            				
				u.setLoginStatus(rs.getInt("loginStatus"));
				
				u.setLoginName(rs.getString("loginName"));
				
				//System.out.println(u.getLoginName()+"///");
			   
				if((u.getLoginStatus()).equals(UserService.LOGIN_STATUS_BLOCKED))
			   {  
				   System.out.println("block check");
				   throw new  UserBlockedException("your contact has been blocked : contact to admin");
		        
			   
			   }
			   else
			   {
				 //  System.out.println(u+" ---");
				   return u;
			}
			}
			
			
		}
		catch (Exception e) {
			//System.out.println("Catch");
			return null;

		}
		//System.out.println("last catch");
		return null;
		}

	@Override
	public List<User> getUserList() {
	
		return 	userDao.findByProperty("role", UserService.ROLE_USER);
		
		
		
	}

	@Override
	public void changeStatus(Integer userId, Integer loginStatus) {
	
		String sql="update user set loginStatus=? where userId=?";
		
		Connection con=getConnection();
			        try{ 
	        PreparedStatement ps=con.prepareStatement(sql);  
	     //   ps.setInt(1,c.getUserId().intValue() );
			
	         ps.setInt(1,loginStatus);
	         ps.setInt(2,userId);
	        ps.executeUpdate();
		    
	     }
	    catch(Exception e){
	    	System.out.println(e);
	    	}  
	
	
			
		}
	
	@Override
	public boolean isUsernameExist(String username) 
	{
	String s="select count(loginName) from user where loginName=?";
	
	         Connection con=getConnection();
		    try{ 
		PreparedStatement ps=con.prepareStatement(s);  
		//   ps.setInt(1,c.getUserId().intValue() );
		
		ps.setString(1,username);
		ResultSet rs=ps.executeQuery();
	int count=rs.getInt("total");
       if(count>0)
    	   return true;
       else
    	   return false;
		}
		catch(Exception e){
		System.out.println(e);
		}  

     return false;

	}
	
	}

	

