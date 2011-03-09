package team1.videoplay.utils;



public class MyException extends Exception{
	private static final long serialVersionUID = -4172914882593395141L;
	public MyException(){
		super();
	}
	public MyException(String message){
		super(message);
	}
	public MyException(String message, Throwable cause){
		super(message,cause);
	}
	public MyException(Throwable cause){
		super(cause);
	}
}
