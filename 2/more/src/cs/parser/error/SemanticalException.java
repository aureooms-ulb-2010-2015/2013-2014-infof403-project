package cs.parser.error;


/**
 *
 * Struct for semantical exceptions.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class SemanticalException extends Exception {

	public SemanticalException() { 
		super(); 
	}
	public SemanticalException(String message) { 
		super(message); 
	}
	public SemanticalException(String message, Throwable cause) { 
		super(message, cause); 
	}
	public SemanticalException(Throwable cause) { 
		super(cause); 
	}

}