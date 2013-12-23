package cs.parser.error;


/**
 *
 * Struct for semantical exceptions.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class SCOBOLSemanticalException extends Exception {

	public SCOBOLSemanticalException() { 
		super(); 
	}
	public SCOBOLSemanticalException(String message) { 
		super(message); 
	}
	public SCOBOLSemanticalException(String message, Throwable cause) { 
		super(message, cause); 
	}
	public SCOBOLSemanticalException(Throwable cause) { 
		super(cause); 
	}

}