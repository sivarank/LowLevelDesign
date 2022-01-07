package testadb.testadb.exceptions;

public class StorageFull extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StorageFull(){
		super("Cache storage is full");
	}
}
