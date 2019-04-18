package in.capp.exception;

public class UserBlockedException extends Exception {

	/*
	 * create user object with error discription
	 * 
	 */
	public UserBlockedException()
	{
		
	}
	
	/*
	 * create user object without error discription
	 * 
	 */
	
	public UserBlockedException(String errDesc)
	{
		super(errDesc);
	}
	
	
	
}
