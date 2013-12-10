package cs.parser;

import cs.lexer.*;

public class cobolSyntaxException extends Exception {
	String message;
	public cobolSyntaxException() { 
		super(); 
	}
	public cobolSyntaxException(String message) { 
		super(message); 
	}
	public cobolSyntaxException(String message, Throwable cause) { 
		super(message, cause); 
	}
	public cobolSyntaxException(Throwable cause) { 
		super(cause); 
	}
	

	public cobolSyntaxException(LexicalUnit expected ,LexicalUnit received ,String line, String column ){
		super();
		this.message = "Syntax Error:\nline: "+line+"\ncolumn: "+column+"\nexpected "+expected+" received "+received;
		
	}

	public String toString(){
		return message;
	}

}