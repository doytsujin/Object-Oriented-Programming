package social;

public class NoSuchCodeException extends Exception {
	private static final long serialVersionUID = 1L;
	NoSuchCodeException(){}
	NoSuchCodeException(String msg){
		super(msg);
	}

}
