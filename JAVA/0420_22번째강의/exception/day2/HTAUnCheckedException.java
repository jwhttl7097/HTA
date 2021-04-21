package day2;

public class HTAUnCheckedException extends RuntimeException{
	
	public HTAUnCheckedException(String msg) {
		super(msg);
	}
	
	public HTAUnCheckedException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
