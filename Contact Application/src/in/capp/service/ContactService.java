package in.capp.service;

import java.util.List;

import in.capp.domain.Contact;

public interface ContactService {
/*
 * 
 * this interface specifies all the services for contact Entity...
 */
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public void delete(Integer contactIds[]);
	public Contact findById(Integer contactId);
	
	/*
	 * 
	 * this method returns all contacts of user who loged in recently
	 */
	
	public List<Contact> findUserContact(Integer userId);
	/*
	 * 
	 * 
	 * this method search  contact for user(userId)  based on given free-text-criteria (text)
	 * @param userId (this is user who is loged in
	 *@text this is criteria used to search free text search
	 */
	public List<Contact> findUserContact(Integer userId,String text);


}
