package in.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.capp.domain.Contact;
import in.capp.service.ContactService;
import in.capp.service.ContactServiceImpl;

@Controller
public class ContactController {
	
	 ContactService contactService=new ContactServiceImpl();
    @RequestMapping(value="/user/contact_form")
	public String contactForm(Model m)
	{
		Contact contact=new Contact();
		m.addAttribute("command",contact);
		return "contact_form";
		
	}
    @RequestMapping(value="/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c,Model m,HttpSession session)
	{
    	Integer contactId=(Integer)session.getAttribute("aContactId");
    	 if(contactId==null)
    	 {
    		 //save task
    		 
    		    try{
    		    	Integer userId=(Integer) session.getAttribute("userId");
    		    	c.setUserId(userId);//fk :logged 
    		    	contactService.save(c);
    				
    		    	return "redirect:clist?act=sv";//redirect user to contact list
    		    	}
    		    	catch (Exception e) {
    			     e.printStackTrace();
    			     //proble solve :todo
    			     //need to solve problem
    			     m.addAttribute("err","faild to save contact");
    		    	
    		    	return "contact_form";//jsp
    		    	}
    	 }
    	 else
    	 {
    		 //update task
    		 
    		    try{
    		    	
    		    	c.setContactId(contactId);//pk
    		    	contactService.update(c);
    				
    		    	return "redirect:clist?act=ed";//redirect user to contact list
    		    	}
    		    	catch (Exception e) {
    			     e.printStackTrace();
    			     //proble solve :todo
    			     //need to solve problem
    			     m.addAttribute("err","faild to edit contact");
    		    	
    		    	return "contact_form";//jsp
    		    	}
    		 
    		 
    		 
    	 }
    	
	}
    @RequestMapping(value="/user/clist")
   	public String contactList(Model m,HttpSession session)
   	{
    	Integer userId=(Integer) session.getAttribute("userId");
    	m.addAttribute("contactList",contactService.findUserContact(userId));
    	
   		return "clist";//jsp
   		
   	}
    @RequestMapping(value="/user/contact_search")
   	public String contactSeacrh(Model m,HttpSession session,@RequestParam("freeText") String freeText)
   	{
    	Integer userId=(Integer) session.getAttribute("userId");
    	m.addAttribute("contactList",contactService.findUserContact(userId,freeText));
    	
   		return "clist";//jsp
   		
   	}
    @RequestMapping(value="/user/del_contact")
   	public String deleteConact(@RequestParam("cid") Integer contactId)
   	{
    	contactService.delete(contactId);
   		return "redirect:clist?act=del";//jsp
   		
   	}
    @RequestMapping(value="/user/bulk_cdelete")
   	public String deleteBulkConact(@RequestParam("cid") Integer contactIds[])
   	{
    	contactService.delete(contactIds);
   		return "redirect:clist?act=del";//jsp
   		
   	}
    @RequestMapping(value="/user/edit_contact")
   	public String prepareEditForm(Model m,HttpSession session,@RequestParam("cid") Integer contactId)
   	{
    
    	session.setAttribute("aContactId", contactId);
    	Contact c=contactService.findById(contactId);
    	System.out.println(contactId);
    	//System.out.println(c.getName()+" "+c.getPhone()+" "+c.getContactId());
    	m.addAttribute("command", c);
    	return "contact_form";
    	
   	}
    
}
