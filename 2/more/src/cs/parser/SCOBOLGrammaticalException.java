package cs.parser;

import cs.lexer.*;

import java.util.Arrays;

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
		super(String.format("Error:\nline: %d\ncolumn: %d\nexpected %s received %s (%s)", line, column, expected, received, value));
	}
	public SCOBOLGrammaticalException(LexicalUnit[] expected, LexicalUnit received, String value, Integer line, Integer column ){
		super(String.format("Error:\nline: %d\ncolumn: %d\nexpected %s received %s (%s)", line, column, Arrays.toString(expected), received, value));
	}

}