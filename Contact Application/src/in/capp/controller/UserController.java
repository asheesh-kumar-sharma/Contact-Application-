package in.capp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.capp.command.LoginCommand;
import in.capp.dao.Db;
import in.capp.domain.User;
import in.capp.domain.UserCommand;
import in.capp.exception.UserBlockedException;
import in.capp.service.UserService;
import in.capp.service.UserServiceImpl;

@Controller
public class UserController {

	 // this is first mapping  for this method we can map multiple mapping
   UserService us=new UserServiceImpl();
	
	@RequestMapping(value={"/","/index"}) 
	public String index(Model m)
	{
		m.addAttribute("command",new LoginCommand());
		return "index";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST) 
	public String HandleLogin(@ModelAttribute("command") LoginCommand cmd,Model m,HttpSession session)
	{
		try
		{
		
	User LoggedInUser=us.login(cmd.getLoginName(),cmd.getPassword());
		if(LoggedInUser==null)
	    {
		//faild part
		//add error message and go back login form
		m.addAttribute("err","Login Faild Enter valid credentials");
    	return  "index";	
				
	}
	else
	{
		//System.out.println("success");
		//success part
		//this is your success part
		//check the role and redirect to appropriate dashboard
		if(LoggedInUser.getRole().equals(UserService.ROLE_ADMIN))
		{	
			//System.out.println(cmd.getLoginName()+" "+cmd.getPassword());
			//assign a seesion to admin
			addUserInSession(LoggedInUser, session);
			return "redirect:admin/dashboard";
		 
		}
		else if(LoggedInUser.getRole().equals(UserService.ROLE_USER))
		
			{
			//assign a seesion to admin
			addUserInSession(LoggedInUser, session);
			
			
			return "redirect:user/dashboard";
	    
			}
		  else
	      {
			 m.addAttribute("err","INVALID USER ROLE");
			   return "index";//jsp login form
				
	    	
	    }
			
	}
	
		}
		catch (UserBlockedException exp) {
			//add error message and go back to login-form
			System.out.println("blocked exception");
	   m.addAttribute("err",exp.getMessage());
	   return "index";//jsp login form
		
		}
	}
	@RequestMapping(value="/user/dashboard")
	public String userDashboard()
	{
		return "dashboard_user";
	}
	
	@RequestMapping(value="/admin/dashboard")
	public String adminDashboard()
	{
		return "dashboard_admin";//jsp
	}

	@RequestMapping(value="/admin/users")
	public String getUserList(Model m)
	{
		m.addAttribute("userList",us.getUserList());
		return "users";//jsp
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		//?act is a flag to print appropriate a  message on index page
		return "redirect:index?act=lo";
	}
	@RequestMapping(value="/reg_form")
	public String registrationForm(Model m)
	{
		UserCommand cmd=new UserCommand();
		//bind user command with model
		//todo: command 
		m.addAttribute("command",cmd);
		return "reg_form";
	}
	@RequestMapping(value="/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd,Model m)
	{
		try
		{
		User u=cmd.getUser();
		u.setRole(us.ROLE_USER);
		u.setLoginStatus(us.LOGIN_STATUS_ACTIVE);
		Connection con=Db.getConnection();
		String sql = "SELECT COUNT(*) FROM user WHERE loginName=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,u.getLoginName());
	   ResultSet rs=ps.executeQuery();
	   int count=0;
	   while(rs.next())
	   {
		   count=rs.getInt(1);
		  
	   }
		
	  	if(count==0)
	  	{
		
	        us.register(u);
			return "redirect:index?act=reg";
	   }
	  	else
	    {
		m.addAttribute("err","username is already registerd... please select another username");
		return "reg_form";
	   }
	  	
		}
		
		
		catch (Exception e) {
	
		System.out.println(e);
		return "reg_form";
		}
	}
	@RequestMapping(value="/admin/change_status")
	@ResponseBody
	public String changeLoginStatus(@RequestParam Integer userId,@RequestParam Integer loginStatus)
	{
		try
		{
		us.changeStatus(userId, loginStatus);
		return "SUCCESS:status changed";
		}
		catch (Exception e) {
		
		 e.printStackTrace();
		 return "ERROR:unable to change status";
		}
	
	}
	@RequestMapping(value="/check_avail")
	@ResponseBody
	public String changeLoginStatus(@RequestParam String username)
	{
		if(us.isUsernameExist(username))
		{
			return "this username is already taken. choose another username";
		}
		else
		{
			return "yes! you can take this";
		}
		
	}
	
	public void addUserInSession(User u,HttpSession session)
	{
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role",u.getRole());
	}
	
	
}
