package cs.parser;

import cs.lexer.*;

public class SCOBOLGrammaticalException extends Exception {
	public SCOBOLGrammaticalException() { 
		super(); 
	}
	public SCOBOLGrammaticalException(String message) { 
		super(message); 
	}
	public SCOBOLGrammaticalException(String message, Throwable cause) { 
		super(message, cause); 
	}
	public SCOBOLGrammaticalException(Throwable cause) { 
		super(cause); 
	}
	public SCOBOLGrammaticalException(LexicalUnit expected, LexicalUnit received, String value, Integer line, Integer column ){
		super("Error:\nline: " + line.toString() + "\ncolumn: " + column.toString() + "\nexpected " + expected + " received " + received + " (" + value + ")");	
	}

}