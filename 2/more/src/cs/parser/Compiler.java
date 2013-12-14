package cs.parser;


import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

import java.lang.*;



import cs.lexer.*;
import cs.parser.functAST.*;
import cs.parser.exprAST.*;
import cs.parser.declAST.*;

public class Compiler{

	protected Scanner cobolScanner;
	protected Symbol<String> token;
	protected boolean inBuffer = false;
	
	protected HashMap<String,VariableExprAST> variables = new HashMap<String,VariableExprAST>();
	protected int variableCount = 0;


	public Compiler(Scanner cobolScanner){
		this.cobolScanner = cobolScanner;
	}

	public void read() throws Exception{
		if(this.inBuffer) this.inBuffer = false;
		else this.token = cobolScanner.next_token();
	}

	public void unread() throws Exception{
		this.inBuffer = true;
	}

	public void check_token_unit(LexicalUnit unit) throws Exception{
		if(!this.is_token_unit(unit)) this.handle_bad_token(unit);
	}

	public boolean is_token_unit(LexicalUnit unit){
		return this.token.unit.equals(unit);
	}

	public void handle_bad_token(LexicalUnit[] units) throws Exception{
		throw new SCOBOLGrammaticalException(units, this.token.unit, this.token.getValue(), (Integer) this.token.get(Symbol.LINE), (Integer) this.token.get(Symbol.COLUMN));
	}

	public void handle_bad_token(LexicalUnit unit) throws Exception{
		throw new SCOBOLGrammaticalException(unit, this.token.unit, this.token.getValue(), (Integer) this.token.get(Symbol.LINE), (Integer) this.token.get(Symbol.COLUMN));
	}

	public void compile() throws Exception{
		this.handle_PROGRAM();
		this.read();
		this.check_token_unit(LexicalUnit.EOF);
	}
	protected int parseInteger(){
		return Integer.decode(token.getValue());
	}

	protected double parseReal(){
		return Double.parseDouble(token.getValue());
	}


	/*
	* PIC S9(7) COMP-3.     Byte size = (7 + 1) / 2 = 4

    * PIC S9(5)V99 COMP-3.  Byte size = (5 + 2 + 1) / 2 = 4

    * PIC S9(6) COMP-3.     Byte size = (6 + 1) / 2 = 3.5, rounded to 4
	*
	*	LLVM types = integer and floats of 16 32 64 128 bits
	*/
	protected ExprAST parseImage(){
		ExprAST ret = null;
		int imSize = 0; // # of 9 in () AND after v
		String image = token.getValue();
		boolean signed = image.contains("s");
		boolean floating = image.contains("v");
		String nines ="";

		boolean inside = false;
		
		for(char c : image.toCharArray()) {
  			
			if(c==')'){
				inside=false;
				imSize+=Integer.decode(nines);
				nines="";
			}
			if(inside){
				nines+=c;
			}
			if(c=='('){inside=true;}
		}
		
		int imageBitSize = 0;
		if(imSize > 0 ){

			imageBitSize = (int)Math.ceil( ( Math.log(Math.pow(imSize,10))/Math.log(2) ) /8 );
		}


		if(imageBitSize < 16 ){// in future make different classes 
			if(floating){ ret = new RealExprAST(Integer.toString(16));}
			else{ ret = new IntegerExprAST(Integer.toString(16));}
		}
		else if(imageBitSize < 32 ){
			if(floating){ ret = new RealExprAST(Integer.toString(32));}
			else{ ret = new IntegerExprAST(Integer.toString(32));}
		}
		else if(imageBitSize < 64 ){
			if(floating){ ret = new RealExprAST(Integer.toString(64));}
			else{ ret = new IntegerExprAST(Integer.toString(64));}
		}
		else if(imageBitSize < 128 ){
			if(floating){ ret = new RealExprAST(Integer.toString(128));}
			else {ret = new IntegerExprAST(Integer.toString(128));}
		}
		else{//well shit...
			if(floating){ ret = new RealExprAST(Integer.toString(16));}
			else { ret = new IntegerExprAST(Integer.toString(16));}
		}
				
		return ret;
	}

	

	public void handle_ASSIGNATION() throws Exception{
		this.read();
		switch(this.token.unit){
			case MOVE:
				this.handle_EXPRESSION();
				this.read();
				this.check_token_unit(LexicalUnit.TO);
				this.read();
				this.check_token_unit(LexicalUnit.IDENTIFIER);
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case COMPUTE:
				this.read();
				this.check_token_unit(LexicalUnit.IDENTIFIER);
				this.read();
				this.check_token_unit(LexicalUnit.EQUALS_SIGN);
				this.handle_EXPRESSION();
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case ADD:
				this.handle_EXPRESSION();
				this.read();
				this.check_token_unit(LexicalUnit.TO);
				this.read();
				this.check_token_unit(LexicalUnit.IDENTIFIER);
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case SUBTRACT:
				this.handle_EXPRESSION();
				this.read();
				this.check_token_unit(LexicalUnit.FROM);
				this.read();
				this.check_token_unit(LexicalUnit.IDENTIFIER);
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case MULTIPLY:
				this.handle_ASSIGN_TAIL();
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case DIVIDE:
				this.handle_ASSIGN_TAIL();
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.MOVE, LexicalUnit.COMPUTE, LexicalUnit.ADD, LexicalUnit.SUBTRACT, LexicalUnit.MULTIPLY, LexicalUnit.DIVIDE});
				break;
		}
	}
	
	public void handle_ASSIGN_TAIL() throws Exception{
		this.handle_EXPRESSION();
		this.read();
		this.check_token_unit(LexicalUnit.COMMA);
		this.handle_EXPRESSION();
		this.read();
		this.check_token_unit(LexicalUnit.GIVING);
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);
	}
	
	public void handle_CALL() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.PERFORM);
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);
		this.handle_CALL_TAIL();
	}
	
	public void handle_CALL_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case UNTIL:
				this.handle_EXPRESSION();
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case END_OF_INSTRUCTION:
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.UNTIL, LexicalUnit.END_OF_INSTRUCTION});
				break;
		}
	}
	
	public void handle_DATA() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.DATA);
		this.read();
		this.check_token_unit(LexicalUnit.DIVISION);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.WORKING_STORAGE);
		this.read();
		this.check_token_unit(LexicalUnit.SECTION);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.handle_VAR_LIST();
	}
	
	public void handle_ENV() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.ENVIRONMENT);
		this.read();
		this.check_token_unit(LexicalUnit.DIVISION);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.CONFIGURATION);
		this.read();
		this.check_token_unit(LexicalUnit.SECTION);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.SOURCE_COMPUTER);
		this.read();
		this.check_token_unit(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.OBJECT_COMPUTER);
		this.read();
		this.check_token_unit(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
	}
	
	public void handle_EXPRESSION() throws Exception{
		this.handle_EXPRESSION_SUB();
		this.handle_EXPRESSION_TAIL();
	}
	
	public void handle_EXPRESSION_SUB() throws Exception{
		this.read();
		switch(this.token.unit){
			case LEFT_PARENTHESIS:
				this.handle_EXPRESSION_SUB();
				this.read();
				this.check_token_unit(LexicalUnit.RIGHT_PARENTHESIS);
				break;
			case NOT:
				this.handle_EXPRESSION_SUB();
				break;
			case IDENTIFIER:
				break;
			case INTEGER:
				break;
			case TRUE:
				break;
			case FALSE:
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.LEFT_PARENTHESIS, LexicalUnit.NOT, LexicalUnit.IDENTIFIER, LexicalUnit.INTEGER, LexicalUnit.TRUE, LexicalUnit.FALSE});
				break;
		}
	}
	
	public void handle_EXPRESSION_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case EQUALS_SIGN:
			case LOWER_THAN:
			case GREATER_THAN:
			case LOWER_OR_EQUALS:
			case GREATER_OR_EQUALS:
			case AND:
			case OR:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case ASTERISK:
			case SLASH:
				this.unread();
				this.handle_OP();
				this.handle_EXPRESSION();
				break;
			case THEN:
			case FROM:
			case GIVING:
			case TO:
			case END_OF_INSTRUCTION:
			case COMMA:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.EQUALS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.GREATER_THAN, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.AND, LexicalUnit.OR, LexicalUnit.PLUS_SIGN, LexicalUnit.MINUS_SIGN, LexicalUnit.ASTERISK, LexicalUnit.SLASH, LexicalUnit.THEN, LexicalUnit.FROM, LexicalUnit.GIVING, LexicalUnit.TO, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.COMMA});
				break;
		}
	}
	
	public void handle_IDENT() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFICATION);
		this.read();
		this.check_token_unit(LexicalUnit.DIVISION);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.PROGRAM_ID);
		this.read();
		this.check_token_unit(LexicalUnit.DOT);
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.AUTHOR);
		this.read();
		this.check_token_unit(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.DATE_WRITTEN);
		this.read();
		this.check_token_unit(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
	}
	
	public void handle_IF() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.IF);
		this.handle_EXPRESSION();
		this.read();
		this.check_token_unit(LexicalUnit.THEN);
		this.handle_INSTRUCTION_LIST();
		this.handle_IF_TAIL();
	}
	
	public void handle_IF_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case ELSE:
				this.handle_INSTRUCTION_LIST();
				this.read();
				this.check_token_unit(LexicalUnit.END_IF);
				break;
			case END_IF:
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.ELSE, LexicalUnit.END_IF});
				break;
		}
	}
	
	public void handle_INSTRUCTION() throws Exception{
		this.read();
		switch(this.token.unit){
			case MOVE:
			case COMPUTE:
			case ADD:
			case SUBTRACT:
			case MULTIPLY:
			case DIVIDE:
				this.unread();
				this.handle_ASSIGNATION();
				break;
			case IF:
				this.unread();
				this.handle_IF();
				break;
			case PERFORM:
				this.unread();
				this.handle_CALL();
				break;
			case ACCEPT:
				this.unread();
				this.handle_READ();
				break;
			case DISPLAY:
				this.unread();
				this.handle_WRITE();
				break;
			case STOP:
				this.read();
				this.check_token_unit(LexicalUnit.RUN);
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.MOVE, LexicalUnit.COMPUTE, LexicalUnit.ADD, LexicalUnit.SUBTRACT, LexicalUnit.MULTIPLY, LexicalUnit.DIVIDE, LexicalUnit.IF, LexicalUnit.PERFORM, LexicalUnit.ACCEPT, LexicalUnit.DISPLAY, LexicalUnit.STOP});
				break;
		}
	}
	
	public void handle_INSTRUCTION_LIST() throws Exception{
		this.read();
		switch(this.token.unit){
			case MOVE:
			case COMPUTE:
			case ADD:
			case SUBTRACT:
			case MULTIPLY:
			case DIVIDE:
			case IF:
			case PERFORM:
			case ACCEPT:
			case DISPLAY:
			case STOP:
				this.unread();
				this.handle_INSTRUCTION();
				this.handle_INSTRUCTION_LIST();
				break;
			case IDENTIFIER:
			case END:
			case END_IF:
			case ELSE:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.MOVE, LexicalUnit.COMPUTE, LexicalUnit.ADD, LexicalUnit.SUBTRACT, LexicalUnit.MULTIPLY, LexicalUnit.DIVIDE, LexicalUnit.IF, LexicalUnit.PERFORM, LexicalUnit.ACCEPT, LexicalUnit.DISPLAY, LexicalUnit.STOP, LexicalUnit.IDENTIFIER, LexicalUnit.END, LexicalUnit.END_IF, LexicalUnit.ELSE});
				break;
		}
	}
	
	public void handle_LABELS() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.handle_INSTRUCTION_LIST();
		this.handle_LABELS_TAIL();
	}
	
	public void handle_LABELS_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case IDENTIFIER:
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				this.handle_INSTRUCTION_LIST();
				this.handle_LABELS_TAIL();
				break;
			case END:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.IDENTIFIER, LexicalUnit.END});
				break;
		}
	}
	
	public void handle_OP() throws Exception{
		this.read();
		switch(this.token.unit){
			case EQUALS_SIGN:
				break;
			case LOWER_THAN:
				break;
			case GREATER_THAN:
				break;
			case LOWER_OR_EQUALS:
				break;
			case GREATER_OR_EQUALS:
				break;
			case AND:
				break;
			case OR:
				break;
			case PLUS_SIGN:
				break;
			case MINUS_SIGN:
				break;
			case ASTERISK:
				break;
			case SLASH:
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.EQUALS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.GREATER_THAN, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.AND, LexicalUnit.OR, LexicalUnit.PLUS_SIGN, LexicalUnit.MINUS_SIGN, LexicalUnit.ASTERISK, LexicalUnit.SLASH});
				break;
		}
	}
	
	public void handle_PROC() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.PROCEDURE);
		this.read();
		this.check_token_unit(LexicalUnit.DIVISION);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);
		this.read();
		this.check_token_unit(LexicalUnit.SECTION);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
		this.handle_LABELS();
		this.read();
		this.check_token_unit(LexicalUnit.END);
		this.read();
		this.check_token_unit(LexicalUnit.PROGRAM);
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);
		this.read();
		this.check_token_unit(LexicalUnit.DOT);
	}
	
	public void handle_PROGRAM() throws Exception{
		this.handle_IDENT();
		this.handle_ENV();
		this.handle_DATA();
		this.handle_PROC();
	}
	
	public void handle_READ() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.ACCEPT);
		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);
		this.read();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
	}

	

	
	
	public void handle_VAR_DECL() throws Exception{

		this.read();
		this.check_token_unit(LexicalUnit.INTEGER);

		this.read();
		this.check_token_unit(LexicalUnit.IDENTIFIER);

		String variableName = token.getValue();

		this.read();
		this.check_token_unit(LexicalUnit.PIC);

		this.read();
		this.check_token_unit(LexicalUnit.IMAGE);

		VariableExprAST newVariable = (VariableExprAST) this.parseImage();

		newVariable.setName(variableName);
		newVariable.setLLVMName("%t"+Integer.toString(variableCount));

		this.handle_VAR_DECL_TAIL(newVariable);
		this.variables.put(variableName,newVariable);

	}

	public void handle_VAR_DECL_TAIL(VariableExprAST newVariable) throws Exception{
		this.read();
		switch(this.token.unit){
			case END_OF_INSTRUCTION:
				break;
			case VALUE:
				this.read();
				this.check_token_unit(LexicalUnit.INTEGER);//integer?! not real?!

				newVariable.setValue(this.parseReal());//parse real

				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

				break;

			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.VALUE});
				break;
		}

	}
	
	
	
	public void handle_VAR_LIST() throws Exception{
		this.read();
		switch(this.token.unit){
			case INTEGER:
				this.unread();
				this.handle_VAR_DECL();
				this.handle_VAR_LIST();
				break;
			case PROCEDURE:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.INTEGER, LexicalUnit.PROCEDURE});
				break;
		}
	}
	
	public void handle_WORDS() throws Exception{
		this.read();
		switch(this.token.unit){
			case IDENTIFIER:
				this.handle_WORDS();
				break;
			case END_OF_INSTRUCTION:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.IDENTIFIER, LexicalUnit.END_OF_INSTRUCTION});
				break;
		}
	}
	
	public void handle_WRITE() throws Exception{
		this.read();
		this.check_token_unit(LexicalUnit.DISPLAY);
		this.handle_WRITE_TAIL();
	}
	
	public void handle_WRITE_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case LEFT_PARENTHESIS:
			case NOT:
			case IDENTIFIER:
			case INTEGER:
			case TRUE:
			case FALSE:
				this.unread();
				this.handle_EXPRESSION();
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case STRING:
				this.read();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.LEFT_PARENTHESIS, LexicalUnit.NOT, LexicalUnit.IDENTIFIER, LexicalUnit.INTEGER, LexicalUnit.TRUE, LexicalUnit.FALSE, LexicalUnit.STRING});
				break;
		}
	}
	
}
