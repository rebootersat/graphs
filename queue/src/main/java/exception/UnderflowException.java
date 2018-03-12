package main.java.exception;

public class UnderflowException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UnderflowException()
	{
		message = "Queue is empty";
	}
	
	public UnderflowException(String message)
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
