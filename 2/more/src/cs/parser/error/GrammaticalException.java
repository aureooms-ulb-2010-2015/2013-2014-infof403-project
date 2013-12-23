package cs.parser.error;

import cs.lexer.*;

import java.util.Arrays;

/**
 *
 * Struct for grammatical exceptions.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */


public class GrammaticalException extends Exception {

	static String format_expected(LexicalUnit[] expected){
		if(expected.length == 0) return "";
		if(expected.length == 1) return expected[0].toString();
		
		String out = "";
		int i = 0;
		for(; i < expected.length - 2; ++i){
			out += expected[i] + ", ";
		}
		out += expected[i] + " or " + expected[i + 1];
		return out;
	}

	public GrammaticalException() { 
		super(); 
	}
	public GrammaticalException(String message) { 
		super(message); 
	}
	public GrammaticalException(String message, Throwable cause) { 
		super(message, cause); 
	}
	public GrammaticalException(Throwable cause) { 
		super(cause); 
	}
	public GrammaticalException(LexicalUnit expected, LexicalUnit received, String value, Integer line, Integer column){
		super(String.format("stdin:%d:%d:expected %s received %s (%s)", line, column, expected, received, value));
	}
	public GrammaticalException(LexicalUnit[] expected, LexicalUnit received, String value, Integer line, Integer column){
		super(String.format("stdin:%d:%d:expected %s received %s (%s)", line, column, format_expected(expected), received, value));
	}

}