package in.capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Data;

@Controller
public class Home 
{
	
    @RequestMapping("/test/hello")
	public String show()
	{
		return "test";
	}

    @RequestMapping("/test/ajax_test")
	public String testPage()
	{
		return "test";
	}
    @RequestMapping("/test/get_time")
    @ResponseBody
   	public String getServerTime()
   	{
    	Data d=new Data();
    	System.out.println(" sever time........");
   		return d.toString();
   	}

}
