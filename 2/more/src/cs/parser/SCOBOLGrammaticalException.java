package cs.parser;

import cs.lexer.*;

import java.util.Arrays;

public class SCOBOLGrammaticalException extends Exception {

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
	public SCOBOLGrammaticalException(LexicalUnit expected, LexicalUnit received, String value, Integer line, Integer column){
		super(String.format("stdin:%d:%d:expected %s received %s (%s)", line, column, expected, received, value));
	}
	public SCOBOLGrammaticalException(LexicalUnit[] expected, LexicalUnit received, String value, Integer line, Integer column){
		super(String.format("stdin:%d:%d:expected %s received %s (%s)", line, column, format_expected(expected), received, value));
	}

}