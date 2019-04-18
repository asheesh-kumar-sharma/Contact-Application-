package in.capp.dao;

import java.util.List;

import in.capp.domain.User;

public interface UserDao {

	public void save(User u);
	public void update(User u);
	public void delete(User u);
	public void delete(Integer  userId);
	public User findById(Integer userId);
	public List<User> findAll();
	public List<User> findByProperty(String proName,Object propValue);
	
	
}
