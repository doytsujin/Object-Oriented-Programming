package social;

public class PersonExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	PersonExistsException(){}
	PersonExistsException(String msg){
		super(msg);
	}
}
