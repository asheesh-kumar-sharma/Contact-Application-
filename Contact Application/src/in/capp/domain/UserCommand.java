package in.capp.domain;

public class UserCommand {

	//reuse user class becaus both have same fields
	User user;
	//to do you can add more fields if reuired those are not in database

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
