package main.java.exception;

public class OverflowException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public OverflowException()
	{
		message = "Queue is full";
	}
	
	public OverflowException(String message)
	{
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
