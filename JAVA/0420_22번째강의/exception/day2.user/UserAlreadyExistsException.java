package day2.user;

public class UserAlreadyExistsException extends RuntimeException{
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
