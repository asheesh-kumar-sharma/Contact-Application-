package in.capp.dao;

import java.util.List;

import in.capp.domain.Contact;

public interface ContactDao {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer  userId);
	public Contact findById(Integer userId);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String proName,Object propValue);
	

	
	
}
