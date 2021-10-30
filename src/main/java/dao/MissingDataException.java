package dao;

public class MissingDataException extends RuntimeException {
	
	private final static long serialVersionUID = 6813697248809460396L ;
	
	public MissingDataException(Exception e) {
		super(e);
	}

}
