package cs.parser;


import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;



import cs.lexer.*;
import cs.parser.functAST.*;
import cs.parser.exprAST.*;

import cs.parser.io.*;
import cs.parser.variable.*;
import cs.parser.string.*;
import cs.parser.conditional.*;
import cs.parser.call.*;
import cs.parser.binary.*;
import cs.parser.functional.*;

import cs.parser.declaration.*;
import cs.parser.assign.*;

public class Parser{

	protected Scanner cobolScanner;
	protected Symbol<String> token;
	protected boolean inBuffer = false;
	protected VariableAllocator variableAllocator = new VariableAllocator();
	
	protected HashMap<String,VariableDecl> variables = new HashMap<String,VariableDecl>();

	protected StringPool stringPool = new StringPool();

	protected String program_id;


	public Parser(Scanner cobolScanner){
		this.cobolScanner = cobolScanner;
	}

	public void read() throws Exception{
		if(this.inBuffer) this.inBuffer = false;
		else this.token = cobolScanner.next_token();
	}

	public void unread() throws Exception{
		this.inBuffer = true;
	}

	public void match(LexicalUnit unit) throws Exception{
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
		this.handle_S();
		stringPool.genCode();
	}

	protected int parseInteger(){
		return Integer.decode(token.getValue());
	}

	protected double parseReal(){
		return Double.parseDouble(token.getValue());
	}


	protected VariableDecl parseImage(){
		int imSize = 0;
		String image = token.getValue();
		boolean signed = false;
		boolean floating = false;
		String nines = "";

		boolean inside = false;

		int i = 0;

		if(image.charAt(i) == 's'){
			++i;
			signed = true;
		}

		++i;
		if(i < image.length() && image.charAt(i) == '('){
			for(++i; i < image.length(); ++i){	
				if(image.charAt(i) == ')'){
					imSize += Integer.decode(nines);
					nines = "";
					break;
				}
				else nines += image.charAt(i);
			}
		}
		else{
			++imSize;
		}
		++i;
		if(i < image.length()){
			floating = true;
			++i;
			if(i < image.length() && image.charAt(i) == '('){
				for(++i; i < image.length(); ++i){	
					if(image.charAt(i) == ')'){
						imSize += Integer.decode(nines);
						nines = "";
						break;
					}
					else nines += image.charAt(i);
				}
			}
			else{
				++imSize;
			}
		}
		
		int imageBitSize = (int) Math.ceil( ( Math.log(Math.pow(imSize,10))/Math.log(2) ) / 8);

		if(floating) return new RealDecl(Integer.toString(8 * imageBitSize), signed);
		else return new IntegerDecl(Integer.toString(8 * imageBitSize), signed);
	}

	protected void createAssign(String var, IntegerVariable expr){
		new Assign(variables.get(var),expr).genCode();
	}

	

	public void handle_ASSIGNATION() throws Exception{
		this.read();
		Assign assign = null;
		String varName;
		IntegerVariable newVal;
		ATail tail;
		switch(this.token.unit){
			case MOVE:
				newVal = this.handle_EXPRESSION(); 

				this.read();
				this.match(LexicalUnit.TO);
				this.read();
				this.match(LexicalUnit.IDENTIFIER);

				varName = token.getValue();

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				this.createAssign(varName,newVal);
				break;
			case COMPUTE:
				this.read();

				this.match(LexicalUnit.IDENTIFIER);

				varName = token.getValue();
				
				this.read();
				this.match(LexicalUnit.EQUALS_SIGN);

				newVal = this.handle_EXPRESSION();

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				this.createAssign(varName,newVal);

				break;
			case ADD:
				
				newVal = this.handle_EXPRESSION();

				this.read();
				this.match(LexicalUnit.TO);
				this.read();
				this.match(LexicalUnit.IDENTIFIER);

				varName = token.getValue();

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				new AssignSA(this.variables.get(varName),newVal,this.variableAllocator.getNext(),this.variableAllocator.getNext(),"add").genCode();

				break;
			case SUBTRACT:
				
				newVal = this.handle_EXPRESSION();

				this.read();
				this.match(LexicalUnit.FROM);
				this.read();
				this.match(LexicalUnit.IDENTIFIER);

				varName = token.getValue();

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				new AssignSA(this.variables.get(varName),newVal,this.variableAllocator.getNext(),this.variableAllocator.getNext(), "sub").genCode();

				break;
			case MULTIPLY:

				//(VariableDecl l, Variable r, String temp, VariableDecl to, String op)
				tail = this.handle_ASSIGN_TAIL();
					
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				new AssignOp (tail.getL(), tail.getR(), this.variableAllocator.getNext(), tail.getTo(), "mul").genCode();
				
				break;
			case DIVIDE:
				
				tail = this.handle_ASSIGN_TAIL();
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				new AssignOp (tail.getL(), tail.getR(), this.variableAllocator.getNext(), tail.getTo(), "div").genCode();
				
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.MOVE, LexicalUnit.COMPUTE, LexicalUnit.ADD, LexicalUnit.SUBTRACT, LexicalUnit.MULTIPLY, LexicalUnit.DIVIDE});
				break;
		}
	}
	
	public ATail handle_ASSIGN_TAIL() throws Exception{

		IntegerVariable l = (IntegerVariable)this.handle_EXPRESSION();
		this.read();
		this.match(LexicalUnit.COMMA);
		IntegerVariable r = (IntegerVariable)this.handle_EXPRESSION();
		this.read();
		this.match(LexicalUnit.GIVING);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);

		return new ATail(l,r,this.variables.get(token.getValue()));
	}
	
	public void handle_CALL() throws Exception{
		this.read();
		this.match(LexicalUnit.PERFORM);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		String function = this.token.getValue();
		String[] labels = this.handle_CALL_TAIL();
		if(labels != null) new Label(labels[1]);
		new Perform(function);
		if(labels != null) new Jump(labels[0]);
		if(labels != null) new Label(labels[2]);
	}
	
	public String[] handle_CALL_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case UNTIL:
				String label_0 = variableAllocator.getNext();
				String label_1 = variableAllocator.getNext();
				String label_2 = variableAllocator.getNext();
				new Jump(label_0);
				new Label(label_0);
				Variable condition = this.handle_EXPRESSION();
				String tmp = variableAllocator.getNext();
				new Not(tmp, condition.getName());
				new If(tmp, label_1, label_2);
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
				return new String[]{label_0, label_1, label_2};
			case END_OF_INSTRUCTION:
				return null;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.UNTIL, LexicalUnit.END_OF_INSTRUCTION});
				return null;
		}
	}
	
	public void handle_COMP() throws Exception{
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
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.EQUALS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.GREATER_THAN, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.GREATER_OR_EQUALS});
				break;
		}
	}
	
	public void handle_DATA() throws Exception{
		this.read();
		this.match(LexicalUnit.DATA);
		this.read();
		this.match(LexicalUnit.DIVISION);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.WORKING_STORAGE);
		this.read();
		this.match(LexicalUnit.SECTION);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.handle_VAR_LIST();
	}
	
	public void handle_ENV() throws Exception{
		this.read();
		this.match(LexicalUnit.ENVIRONMENT);
		this.read();
		this.match(LexicalUnit.DIVISION);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.CONFIGURATION);
		this.read();
		this.match(LexicalUnit.SECTION);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.SOURCE_COMPUTER);
		this.read();
		this.match(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.OBJECT_COMPUTER);
		this.read();
		this.match(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
	}
	


	public IntegerVariable handle_EXPRESSION() throws Exception{
		this.handle_EXPRESSION_1();
		this.handle_EXPRESSION_TAIL();
		return new IntegerVariable(true,32,"%test");

	}
	
	public ExprAST handle_EXPRESSION_1() throws Exception{
		ExprAST ret = null;
		this.handle_EXPRESSION_2();
		this.handle_EXPRESSION_1_TAIL();
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_1_TAIL() throws Exception{
		ExprAST ret = null;
		this.read();
		switch(this.token.unit){
			case AND:
				this.handle_EXPRESSION_2();
				this.handle_EXPRESSION_1_TAIL();
				break;
			case RIGHT_PARENTHESIS:
			case LOWER_OR_EQUALS:
			case THEN:
			case ASTERISK:
			case GIVING:
			case OR:
			case EQUALS_SIGN:
			case MINUS_SIGN:
			case LOWER_THAN:
			case END_OF_INSTRUCTION:
			case SLASH:
			case TO:
			case GREATER_THAN:
			case PLUS_SIGN:
			case COMMA:
			case GREATER_OR_EQUALS:
			case FROM:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.AND, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.THEN, LexicalUnit.ASTERISK, LexicalUnit.GIVING, LexicalUnit.OR, LexicalUnit.EQUALS_SIGN, LexicalUnit.MINUS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.SLASH, LexicalUnit.TO, LexicalUnit.GREATER_THAN, LexicalUnit.PLUS_SIGN, LexicalUnit.COMMA, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.FROM});
				break;

		}
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_2() throws Exception{
		ExprAST ret = null;
		this.handle_EXPRESSION_3();
		this.handle_EXPRESSION_2_TAIL();
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_2_TAIL() throws Exception{
		ExprAST ret = null;
		this.read();
		switch(this.token.unit){
			case EQUALS_SIGN:
			case LOWER_THAN:
			case GREATER_THAN:
			case LOWER_OR_EQUALS:
			case GREATER_OR_EQUALS:
				this.unread();
				this.handle_COMP();
				this.handle_EXPRESSION_3();
				this.handle_EXPRESSION_2_TAIL();
				break;
			case RIGHT_PARENTHESIS:
			case THEN:
			case ASTERISK:
			case GIVING:
			case OR:
			case MINUS_SIGN:
			case END_OF_INSTRUCTION:
			case SLASH:
			case TO:
			case PLUS_SIGN:
			case COMMA:
			case FROM:
			case AND:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.EQUALS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.GREATER_THAN, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.THEN, LexicalUnit.ASTERISK, LexicalUnit.GIVING, LexicalUnit.OR, LexicalUnit.MINUS_SIGN, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.SLASH, LexicalUnit.TO, LexicalUnit.PLUS_SIGN, LexicalUnit.COMMA, LexicalUnit.FROM, LexicalUnit.AND});
				break;

		}
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_3() throws Exception{
		ExprAST ret = null;
		this.handle_EXPRESSION_4();
		this.handle_EXPRESSION_3_TAIL();
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_3_TAIL() throws Exception{
		ExprAST ret = null;
		this.read();
		switch(this.token.unit){
			case PLUS_SIGN:
				this.handle_EXPRESSION_4();
				this.handle_EXPRESSION_3_TAIL();
				break;
			case MINUS_SIGN:
				this.handle_EXPRESSION_4();
				this.handle_EXPRESSION_3_TAIL();
				break;
			case RIGHT_PARENTHESIS:
			case LOWER_OR_EQUALS:
			case THEN:
			case ASTERISK:
			case GIVING:
			case OR:
			case LOWER_THAN:
			case END_OF_INSTRUCTION:
			case SLASH:
			case TO:
			case FROM:
			case GREATER_THAN:
			case COMMA:
			case GREATER_OR_EQUALS:
			case EQUALS_SIGN:
			case AND:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.PLUS_SIGN, LexicalUnit.MINUS_SIGN, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.THEN, LexicalUnit.ASTERISK, LexicalUnit.GIVING, LexicalUnit.OR, LexicalUnit.LOWER_THAN, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.SLASH, LexicalUnit.TO, LexicalUnit.FROM, LexicalUnit.GREATER_THAN, LexicalUnit.COMMA, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.EQUALS_SIGN, LexicalUnit.AND});
				break;

		}
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_4() throws Exception{
		ExprAST ret = null;
		this.handle_EXPRESSION_BASE();
		this.handle_EXPRESSION_4_TAIL();
		return ret;

	}

	
	public ExprAST handle_EXPRESSION_4_TAIL() throws Exception{
		ExprAST ret = null;
		this.read();
		switch(this.token.unit){
			case ASTERISK:
				this.handle_EXPRESSION_BASE();
				this.handle_EXPRESSION_4_TAIL();
				break;
			case SLASH:
				this.handle_EXPRESSION_BASE();
				this.handle_EXPRESSION_4_TAIL();
				break;
			case RIGHT_PARENTHESIS:
			case LOWER_OR_EQUALS:
			case THEN:
			case GIVING:
			case OR:
			case END_OF_INSTRUCTION:
			case EQUALS_SIGN:
			case MINUS_SIGN:
			case LOWER_THAN:
			case TO:
			case GREATER_THAN:
			case PLUS_SIGN:
			case COMMA:
			case GREATER_OR_EQUALS:
			case FROM:
			case AND:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.ASTERISK, LexicalUnit.SLASH, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.THEN, LexicalUnit.GIVING, LexicalUnit.OR, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.EQUALS_SIGN, LexicalUnit.MINUS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.TO, LexicalUnit.GREATER_THAN, LexicalUnit.PLUS_SIGN, LexicalUnit.COMMA, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.FROM, LexicalUnit.AND});
				break;

		}
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_BASE() throws Exception{
		ExprAST ret = null;
		this.read();
		switch(this.token.unit){
			case LEFT_PARENTHESIS:
				this.handle_EXPRESSION();
				this.read();
				this.match(LexicalUnit.RIGHT_PARENTHESIS);
				break;
			case NOT:
				this.handle_EXPRESSION();
				break;
			case MINUS_SIGN:
				this.handle_EXPRESSION();
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
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.LEFT_PARENTHESIS, LexicalUnit.NOT, LexicalUnit.MINUS_SIGN, LexicalUnit.IDENTIFIER, LexicalUnit.INTEGER, LexicalUnit.TRUE, LexicalUnit.FALSE});
				break;
		}
		return ret;

	}
	
	public ExprAST handle_EXPRESSION_TAIL() throws Exception{
		ExprAST ret = null;
		this.read();
		switch(this.token.unit){
			case OR:
				this.handle_EXPRESSION_1();
				this.handle_EXPRESSION_TAIL();
				break;
			case RIGHT_PARENTHESIS:
			case LOWER_OR_EQUALS:
			case THEN:
			case ASTERISK:
			case GIVING:
			case EQUALS_SIGN:
			case MINUS_SIGN:
			case LOWER_THAN:
			case END_OF_INSTRUCTION:
			case SLASH:
			case TO:
			case GREATER_THAN:
			case PLUS_SIGN:
			case COMMA:
			case GREATER_OR_EQUALS:
			case FROM:
			case AND:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.OR, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.THEN, LexicalUnit.ASTERISK, LexicalUnit.GIVING, LexicalUnit.EQUALS_SIGN, LexicalUnit.MINUS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.SLASH, LexicalUnit.TO, LexicalUnit.GREATER_THAN, LexicalUnit.PLUS_SIGN, LexicalUnit.COMMA, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.FROM, LexicalUnit.AND});
				break;

		}
		return ret;
	}
	
	public void handle_IDENT() throws Exception{
		this.read();
		this.match(LexicalUnit.IDENTIFICATION);
		this.read();
		this.match(LexicalUnit.DIVISION);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.PROGRAM_ID);
		this.read();
		this.match(LexicalUnit.DOT);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		this.program_id = this.token.getValue();
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.AUTHOR);
		this.read();
		this.match(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.DATE_WRITTEN);
		this.read();
		this.match(LexicalUnit.DOT);
		this.handle_WORDS();
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
	}
	
	public void handle_IF() throws Exception{
		this.read();
		this.match(LexicalUnit.IF);
		String label_0 = variableAllocator.getNext();
		String label_1 = variableAllocator.getNext();
		String label_2 = variableAllocator.getNext();
		Variable condition = this.handle_EXPRESSION();
		new If(condition.getName(), label_0, label_1);
		this.read();
		this.match(LexicalUnit.THEN);
		new Label(label_0);
		this.handle_INSTRUCTION_LIST();
		new Jump(label_2);
		new Label(label_1);
		this.handle_IF_TAIL();
		new Jump(label_2);
		new Label(label_2);
	}
	
	public void handle_IF_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case ELSE:
				this.handle_INSTRUCTION_LIST();
				this.read();
				this.match(LexicalUnit.END_IF);
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
				this.match(LexicalUnit.RUN);
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
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
			case ELSE:
			case END:
			case IDENTIFIER:
			case END_IF:
				this.unread();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.MOVE, LexicalUnit.COMPUTE, LexicalUnit.ADD, LexicalUnit.SUBTRACT, LexicalUnit.MULTIPLY, LexicalUnit.DIVIDE, LexicalUnit.IF, LexicalUnit.PERFORM, LexicalUnit.ACCEPT, LexicalUnit.DISPLAY, LexicalUnit.STOP, LexicalUnit.ELSE, LexicalUnit.END, LexicalUnit.IDENTIFIER, LexicalUnit.END_IF});
				break;
		}
	}
	
	public void handle_LABELS() throws Exception{
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		String function = this.token.getValue();
		new Function(function);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.handle_INSTRUCTION_LIST();
		new FunctionEnd(function);
		this.handle_LABELS_TAIL();
	}
	
	public void handle_LABELS_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case IDENTIFIER:
				variableAllocator.reset();
				String function = this.token.getValue();
				new Function(function);
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
				this.handle_INSTRUCTION_LIST();
				new FunctionEnd(function);
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
	
	public void handle_PROC() throws Exception{
		this.read();
		this.match(LexicalUnit.PROCEDURE);
		this.read();
		this.match(LexicalUnit.DIVISION);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		this.read();
		this.match(LexicalUnit.SECTION);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.handle_LABELS();
		this.read();
		this.match(LexicalUnit.END);
		this.read();
		this.match(LexicalUnit.PROGRAM);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		if(!this.program_id.equals(this.token.getValue()))
			throw new SCOBOLSemanticalException("error: program id does not match");
		this.read();
		this.match(LexicalUnit.DOT);
	}
	
	public void handle_PROGRAM() throws Exception{
		this.handle_IDENT();
		this.handle_ENV();
		this.handle_DATA();
		this.handle_PROC();
	}
	
	public void handle_READ() throws Exception{
		this.read();
		this.match(LexicalUnit.ACCEPT);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		new Accept("i" + this.variables.get(this.token.getValue()).getLLVMSize(), "%" + this.token.getValue());
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
	}
	
	public void handle_S() throws Exception{
		this.handle_PROGRAM();
		this.read();
		this.match(LexicalUnit.EOF);
	}
	
	public void handle_VAR_DECL() throws Exception{

		this.read();
		this.match(LexicalUnit.INTEGER);

		this.read();
		this.match(LexicalUnit.IDENTIFIER);

		String variableName = token.getValue();

		this.read();
		this.match(LexicalUnit.PIC);

		this.read();
		this.match(LexicalUnit.IMAGE);

		VariableDecl newVariable = (VariableDecl) this.parseImage();

		newVariable.setName(variableName);


		this.handle_VAR_DECL_TAIL(newVariable);
		newVariable.genCode();
		this.variables.put(variableName,newVariable);

	}

	public void handle_VAR_DECL_TAIL(VariableDecl newVariable) throws Exception{
		this.read();
		switch(this.token.unit){
			case END_OF_INSTRUCTION:
				break;
			case VALUE:
				this.read();
				this.match(LexicalUnit.INTEGER);

				newVariable.setValue(this.parseInteger());

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

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
		this.match(LexicalUnit.DISPLAY);
		this.handle_WRITE_TAIL();
	}
	
	public void handle_WRITE_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case LEFT_PARENTHESIS:
			case NOT:
			case MINUS_SIGN:
			case IDENTIFIER:
			case INTEGER:
			case TRUE:
			case FALSE:
				this.unread();
				Variable expression = this.handle_EXPRESSION();
				new Display(expression.getType(), expression.getName());
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case STRING:
				String variableName = stringPool.get(token.getValue());
				new Display(StringVariable.TYPE, variableName);
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.LEFT_PARENTHESIS, LexicalUnit.NOT, LexicalUnit.MINUS_SIGN, LexicalUnit.IDENTIFIER, LexicalUnit.INTEGER, LexicalUnit.TRUE, LexicalUnit.FALSE, LexicalUnit.STRING});
				break;
		}
	}
	
}
