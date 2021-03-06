package cs.parser;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import cs.lexer.*;

import cs.parser.code.io.*;
import cs.parser.code.comp.*;
import cs.parser.code.call.*;
import cs.parser.code.cast.*;
import cs.parser.code.unary.*;
import cs.parser.code.binary.*;
import cs.parser.code.string.*;
import cs.parser.code.memory.*;
import cs.parser.code.system.*;
import cs.parser.code.functional.*;
import cs.parser.code.conditional.*;

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;

import cs.parser.ast.assign.*;

import cs.parser.utils.*;

import cs.parser.error.*;

/**
 *
 * The S-COBOL parser.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */


public class Parser extends ParserBase{

	// BEGIN OF PARSING AUTOMATON

	private void handle_ASSIGNATION() throws Exception{
		this.read();
		switch(this.token.unit){
			case MOVE:{
				IntegerVariable expr = this.handle_EXPRESSION(); 

				this.read();
				this.match(LexicalUnit.TO);
				this.read();
				this.match(LexicalUnit.IDENTIFIER);

				String varName = token.getValue();

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				this.ensureDest(expr, new IntegerVariable(this.semanticalAnalyzer.getVariable(varName)));
				new Store(expr, this.semanticalAnalyzer.getVariable(varName));
				break;
			}
			case COMPUTE:{
				this.read();

				this.match(LexicalUnit.IDENTIFIER);

				String varName = token.getValue();
				
				this.read();
				this.match(LexicalUnit.EQUALS_SIGN);

				IntegerVariable expr = this.handle_EXPRESSION();

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
				this.ensureDest(expr, new IntegerVariable(this.semanticalAnalyzer.getVariable(varName)));
				new Store(expr, this.semanticalAnalyzer.getVariable(varName));
				break;
			}
			case ADD:{
				
				IntegerVariable right = this.handle_EXPRESSION();
				this.read();
				this.match(LexicalUnit.TO);
				this.read();
				this.match(LexicalUnit.IDENTIFIER);
				VariableDecl decl = this.semanticalAnalyzer.getVariable(token.getValue());
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				String var_1 = variableAllocator.getNext();
				IntegerVariable left = new IntegerVariable(decl, var_1);
				new Load(left, decl);
				this.ensureSize(left, right);

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(left.isSigned(), left.getSize(), var_0);
				new Add(result, left, right);
				this.ensureDest(result, new IntegerVariable(decl));
				new Store(result, decl);
				break;
			}
			case SUBTRACT:{
				
				IntegerVariable right = this.handle_EXPRESSION();
				this.read();
				this.match(LexicalUnit.FROM);
				this.read();
				this.match(LexicalUnit.IDENTIFIER);
				VariableDecl decl = this.semanticalAnalyzer.getVariable(token.getValue());
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				String var_1 = variableAllocator.getNext();
				IntegerVariable left = new IntegerVariable(decl, var_1);
				new Load(left, decl);
				this.ensureSize(left, right);

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(left.isSigned(), left.getSize(), var_0);
				new Sub(result, left, right);
				this.ensureDest(result, new IntegerVariable(decl));
				new Store(result, decl);
				break;
			}
			case MULTIPLY:{

				AssignmentTail tail = this.handle_ASSIGN_TAIL();
					
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				this.ensureSize(tail.getL(), tail.getR());

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(tail.getL().isSigned() || tail.getR().isSigned(), tail.getL().getSize(), var_0);
				new Mul(result, tail.getL(), tail.getR());

				this.ensureDest(result, new IntegerVariable(tail.getTo()));
				new Store(result, tail.getTo());
				break;
			}
			case DIVIDE:{
				
				AssignmentTail tail = this.handle_ASSIGN_TAIL();
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);


				this.ensureSize(tail.getL(), tail.getR());

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(tail.getL().isSigned() || tail.getR().isSigned(), tail.getL().getSize(), var_0);
				new Div(result, tail.getL(), tail.getR());

				this.ensureDest(result, new IntegerVariable(tail.getTo()));
				new Store(result, tail.getTo());
				break;
			}
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.MOVE, LexicalUnit.COMPUTE, LexicalUnit.ADD, LexicalUnit.SUBTRACT, LexicalUnit.MULTIPLY, LexicalUnit.DIVIDE});
				break;
		}
	}
	
	private AssignmentTail handle_ASSIGN_TAIL() throws Exception{

		IntegerVariable left = (IntegerVariable)this.handle_EXPRESSION();
		this.read();
		this.match(LexicalUnit.COMMA);
		IntegerVariable right = (IntegerVariable)this.handle_EXPRESSION();
		this.read();
		this.match(LexicalUnit.GIVING);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);

		return new AssignmentTail(left,right,this.semanticalAnalyzer.getVariable(token.getValue()));
	}
	
	private void handle_CALL() throws Exception{
		this.read();
		this.match(LexicalUnit.PERFORM);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		String function = this.token.getValue();
		this.semanticalAnalyzer.useLabel(function);
		String[] labels = this.handle_CALL_TAIL();
		if(labels != null){
			new Label(labels[1]);
			this.currentLabel = labels[1];
		}
		new Perform(function);
		if(labels != null) new Jump(labels[0]);
		if(labels != null){
			new Label(labels[2]);
			this.currentLabel = labels[2];
		}
	}
	
	private String[] handle_CALL_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case UNTIL:
				String label_0 = variableAllocator.getNext();
				String label_1 = variableAllocator.getNext();
				String label_2 = variableAllocator.getNext();
				new Jump(label_0);
				new Label(label_0);
				this.currentLabel = label_0;
				IntegerVariable condition = this.handle_EXPRESSION();
				new If(condition.getName(), label_2, label_1);
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
	
	
	private void handle_DATA() throws Exception{
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
		System.out.println("");
		this.semanticalAnalyzer.checkVariables();
	}
	
	private void handle_ENV() throws Exception{
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
	


	private IntegerVariable handle_EXPRESSION() throws Exception{
		IntegerVariable left = this.handle_EXPRESSION_1();
		return this.handle_EXPRESSION_TAIL(left);

	}
	
	private IntegerVariable handle_EXPRESSION_1() throws Exception{
		IntegerVariable left = this.handle_EXPRESSION_2();
		return this.handle_EXPRESSION_1_TAIL(left);
	}
	
	private IntegerVariable handle_EXPRESSION_1_TAIL(IntegerVariable left) throws Exception{
		this.read();
		switch(this.token.unit){
			case AND:{
				String var_0 = variableAllocator.getNext();
				String var_1 = variableAllocator.getNext();
				String var_2 = variableAllocator.getNext();
				String label_1 = variableAllocator.getNext();
				String label_2 = variableAllocator.getNext();
				And op = new And(var_0, var_1, var_2, this.currentLabel, label_1, label_2);
				op.genCodeLeft(left);
				this.currentLabel = label_1;
				IntegerVariable right = this.handle_EXPRESSION_2();
				op.genCodeRight(right, this.currentLabel);
				this.currentLabel = label_2;
				return this.handle_EXPRESSION_1_TAIL(new IntegerVariable(false, 1, var_2));
			}
			case THEN:
			case FROM:
			case GIVING:
			case TO:
			case END_OF_INSTRUCTION:
			case COMMA:
			case RIGHT_PARENTHESIS:
			case OR:
				this.unread();
				return left;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.AND, LexicalUnit.THEN, LexicalUnit.FROM, LexicalUnit.GIVING, LexicalUnit.TO, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.COMMA, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.OR});
				break;

		}
		return null;

	}
	
	private IntegerVariable handle_EXPRESSION_2() throws Exception{
		IntegerVariable left = this.handle_EXPRESSION_3();
		return this.handle_EXPRESSION_2_TAIL(left);
	}
	
	private IntegerVariable handle_EXPRESSION_2_TAIL(IntegerVariable left) throws Exception{
		this.read();

		switch(this.token.unit){
			case EQUALS_SIGN:{
				IntegerVariable right = this.handle_EXPRESSION_3();
				String var_0 = variableAllocator.getNext();
				this.ensureSize(left, right);
				new Comp(left, right, Comp.Op.EQ, var_0);
				IntegerVariable result = new IntegerVariable(false,1,var_0);
				return this.handle_EXPRESSION_2_TAIL(result);
			}
			case LOWER_THAN:{
				IntegerVariable right = this.handle_EXPRESSION_3();
				String var_0 = variableAllocator.getNext();
				this.ensureSize(left, right);
				new Comp(left, right, Comp.Op.LT, var_0);
				IntegerVariable result = new IntegerVariable(false,1,var_0);
				return this.handle_EXPRESSION_2_TAIL(result);
			}
			case GREATER_THAN:{
				IntegerVariable right = this.handle_EXPRESSION_3();
				String var_0 = variableAllocator.getNext();
				this.ensureSize(left, right);
				new Comp(left, right, Comp.Op.GT, var_0);
				IntegerVariable result = new IntegerVariable(false,1,var_0);
				return this.handle_EXPRESSION_2_TAIL(result);
			}
			case LOWER_OR_EQUALS:{
				IntegerVariable right = this.handle_EXPRESSION_3();
				String var_0 = variableAllocator.getNext();
				this.ensureSize(left, right);
				new Comp(left, right, Comp.Op.LE, var_0);
				IntegerVariable result = new IntegerVariable(false,1,var_0);
				return this.handle_EXPRESSION_2_TAIL(result);
			}
			case GREATER_OR_EQUALS:{
				IntegerVariable right = this.handle_EXPRESSION_3();
				String var_0 = variableAllocator.getNext();
				this.ensureSize(left, right);
				new Comp(left, right, Comp.Op.GE, var_0);
				IntegerVariable result = new IntegerVariable(false,1,var_0);
				return this.handle_EXPRESSION_2_TAIL(result);
			}
			case AND:
			case THEN:
			case FROM:
			case GIVING:
			case TO:
			case END_OF_INSTRUCTION:
			case COMMA:
			case RIGHT_PARENTHESIS:
			case OR:
				this.unread();
				return left;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.EQUALS_SIGN, LexicalUnit.LOWER_THAN, LexicalUnit.GREATER_THAN, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.AND, LexicalUnit.THEN, LexicalUnit.FROM, LexicalUnit.GIVING, LexicalUnit.TO, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.COMMA, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.OR});
				break;

		}
		return null;

	}
	
	private IntegerVariable handle_EXPRESSION_3() throws Exception{
		IntegerVariable left = this.handle_EXPRESSION_4();
		return this.handle_EXPRESSION_3_TAIL(left);

	}
	
	private IntegerVariable handle_EXPRESSION_3_TAIL(IntegerVariable left) throws Exception{
		this.read();
		switch(this.token.unit){
			case PLUS_SIGN:{
				IntegerVariable right = this.handle_EXPRESSION_4();
				this.ensureSize(left, right);

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(left.isSigned() || right.isSigned(), left.getSize(), var_0);
				new Add(result, left, right);
				
				return this.handle_EXPRESSION_3_TAIL(result);
			}
			case MINUS_SIGN:{
				IntegerVariable right = this.handle_EXPRESSION_4();
				this.ensureSize(left, right);

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(left.isSigned() || right.isSigned(), left.getSize(), var_0);
				new Sub(result, left, right);
				return this.handle_EXPRESSION_3_TAIL(result);
			}
			case AND:
			case THEN:
			case FROM:
			case GREATER_OR_EQUALS:
			case GIVING:
			case LOWER_THAN:
			case LOWER_OR_EQUALS:
			case TO:
			case END_OF_INSTRUCTION:
			case COMMA:
			case EQUALS_SIGN:
			case GREATER_THAN:
			case RIGHT_PARENTHESIS:
			case OR:
				this.unread();
				return left;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.PLUS_SIGN, LexicalUnit.MINUS_SIGN, LexicalUnit.AND, LexicalUnit.THEN, LexicalUnit.FROM, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.GIVING, LexicalUnit.LOWER_THAN, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.TO, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.COMMA, LexicalUnit.EQUALS_SIGN, LexicalUnit.GREATER_THAN, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.OR});
				break;

		}
		return null;

	}
	
	private IntegerVariable handle_EXPRESSION_4() throws Exception{
		IntegerVariable left = this.handle_EXPRESSION_BASE();
		return this.handle_EXPRESSION_4_TAIL(left);
	}

	
	private IntegerVariable handle_EXPRESSION_4_TAIL(IntegerVariable left) throws Exception{
		this.read();
		switch(this.token.unit){
			case ASTERISK:{

				IntegerVariable right = this.handle_EXPRESSION_BASE();
				this.ensureSize(left, right);

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(left.isSigned() || right.isSigned(), left.getSize(), var_0);
				new Mul(result, left, right);
				
				return this.handle_EXPRESSION_4_TAIL(result);
			}
			case SLASH:{
				IntegerVariable right = this.handle_EXPRESSION_BASE();
				this.ensureSize(left, right);

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(left.isSigned() || right.isSigned(), left.getSize(), var_0);
				new Div(result, left, right);
				
				return this.handle_EXPRESSION_4_TAIL(result);
			}
			case THEN:
			case EQUALS_SIGN:
			case GREATER_OR_EQUALS:
			case LOWER_THAN:
			case END_OF_INSTRUCTION:
			case GREATER_THAN:
			case RIGHT_PARENTHESIS:
			case PLUS_SIGN:
			case AND:
			case FROM:
			case GIVING:
			case LOWER_OR_EQUALS:
			case TO:
			case COMMA:
			case MINUS_SIGN:
			case OR:
				this.unread();
				return left;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.ASTERISK, LexicalUnit.SLASH, LexicalUnit.THEN, LexicalUnit.EQUALS_SIGN, LexicalUnit.GREATER_OR_EQUALS, LexicalUnit.LOWER_THAN, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.GREATER_THAN, LexicalUnit.RIGHT_PARENTHESIS, LexicalUnit.PLUS_SIGN, LexicalUnit.AND, LexicalUnit.FROM, LexicalUnit.GIVING, LexicalUnit.LOWER_OR_EQUALS, LexicalUnit.TO, LexicalUnit.COMMA, LexicalUnit.MINUS_SIGN, LexicalUnit.OR});
				break;

		}
		return null;

	}
	
	private IntegerVariable handle_EXPRESSION_BASE() throws Exception{
		this.read();
		switch(this.token.unit){
			case LEFT_PARENTHESIS:{
				IntegerVariable result = this.handle_EXPRESSION();
				this.read();
				this.match(LexicalUnit.RIGHT_PARENTHESIS);
				return result;
			}
			case NOT:{
				String var_0 = variableAllocator.getNext();
				IntegerVariable expr = this.handle_EXPRESSION_BASE();
				IntegerVariable result = new IntegerVariable(false, 1, var_0);
				this.ensureDest(expr, result);
				new Not(result.getName(), expr);
				return result;
			}
			case MINUS_SIGN:{
				String var_0 = variableAllocator.getNext();
				IntegerVariable expr = this.handle_EXPRESSION_BASE();
				IntegerVariable result = new IntegerVariable(expr.isSigned(), expr.getSize(), var_0);
				new Neg(result , expr.getName());
				return result;
			}
			case IDENTIFIER:{
				String var_0 = variableAllocator.getNext();
				VariableDecl declared = this.semanticalAnalyzer.getVariable(token.getValue());
				IntegerVariable result = new IntegerVariable(declared.isSigned(), Integer.decode(declared.getLLVMSize()), var_0);
				new Load(result, this.semanticalAnalyzer.getVariable(token.getValue()));
				return result;
			}
			case INTEGER:{
				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(true, 64, var_0);
				new LoadInteger(var_0, Long.decode(this.token.getValue()));
				return result;
			}
			case TRUE:{
				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(false, 1, var_0);
				new LoadInteger(var_0, 1);
				return result;
			}
			case FALSE:{
				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(false, 1, var_0);
				new LoadInteger(var_0, 0);
				return result;
			}
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.LEFT_PARENTHESIS, LexicalUnit.NOT, LexicalUnit.MINUS_SIGN, LexicalUnit.IDENTIFIER, LexicalUnit.INTEGER, LexicalUnit.TRUE, LexicalUnit.FALSE});
				break;
		}
		return null;

	}
	
	private IntegerVariable handle_EXPRESSION_TAIL(IntegerVariable left) throws Exception{
		this.read();
		switch(this.token.unit){
			case OR:{
				String var_0 = variableAllocator.getNext();
				String var_1 = variableAllocator.getNext();
				String var_2 = variableAllocator.getNext();
				String label_1 = variableAllocator.getNext();
				String label_2 = variableAllocator.getNext();
				Or op = new Or(var_0, var_1, var_2, this.currentLabel, label_1, label_2);
				op.genCodeLeft(left);
				this.currentLabel = label_1;
				IntegerVariable right = this.handle_EXPRESSION_1();
				op.genCodeRight(right, this.currentLabel);
				this.currentLabel = label_2;
				return this.handle_EXPRESSION_TAIL(new IntegerVariable(false, 1, var_2));
			}
			case THEN:
			case FROM:
			case GIVING:
			case TO:
			case END_OF_INSTRUCTION:
			case COMMA:
			case RIGHT_PARENTHESIS:
				this.unread();
				return left;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.OR, LexicalUnit.THEN, LexicalUnit.FROM, LexicalUnit.GIVING, LexicalUnit.TO, LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.COMMA, LexicalUnit.RIGHT_PARENTHESIS});
				break;

		}
		return null;
	}
	
	private void handle_IDENT() throws Exception{
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
		this.semanticalAnalyzer.setProgramId(this.token.getValue());
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
	
	private void handle_IF() throws Exception{
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
		this.currentLabel = label_0;
		this.handle_INSTRUCTION_LIST();
		new Jump(label_2);
		new Label(label_1);
		this.currentLabel = label_1;
		this.handle_IF_TAIL();
		new Jump(label_2);
		new Label(label_2);
		this.currentLabel = label_2;
	}
	
	private void handle_IF_TAIL() throws Exception{
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
	
	private void handle_INSTRUCTION() throws Exception{
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
				new Exit();
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.MOVE, LexicalUnit.COMPUTE, LexicalUnit.ADD, LexicalUnit.SUBTRACT, LexicalUnit.MULTIPLY, LexicalUnit.DIVIDE, LexicalUnit.IF, LexicalUnit.PERFORM, LexicalUnit.ACCEPT, LexicalUnit.DISPLAY, LexicalUnit.STOP});
				break;
		}
	}
	
	private void handle_INSTRUCTION_LIST() throws Exception{
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
	
	private void handle_LABELS() throws Exception{
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		String function = this.token.getValue();
		this.semanticalAnalyzer.defLabel(function);
		new Function(function);
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
		this.handle_INSTRUCTION_LIST();
		new FunctionEnd(function);
		this.handle_LABELS_TAIL();
	}
	
	private void handle_LABELS_TAIL() throws Exception{
		this.read();
		switch(this.token.unit){
			case IDENTIFIER:
				variableAllocator.reset();
				this.resetCurrentLabel();
				String function = this.token.getValue();
				this.semanticalAnalyzer.defLabel(function);
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
	
	private void handle_PROC() throws Exception{
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
		this.semanticalAnalyzer.matchProgramId(this.token.getValue());
		this.read();
		this.match(LexicalUnit.DOT);
	}
	
	private void handle_PROGRAM() throws Exception{
		this.handle_IDENT();
		this.handle_ENV();
		this.handle_DATA();
		this.handle_PROC();
	}
	
	private void handle_READ() throws Exception{
		this.read();
		this.match(LexicalUnit.ACCEPT);
		this.read();
		this.match(LexicalUnit.IDENTIFIER);
		new Accept(new IntegerVariable(this.semanticalAnalyzer.getVariable(this.token.getValue())));
		this.read();
		this.match(LexicalUnit.END_OF_INSTRUCTION);
	}
	
	private void handle_S() throws Exception{
		this.handle_PROGRAM();
		this.read();
		this.match(LexicalUnit.EOF);
	}
	
	private void handle_VAR_DECL() throws Exception{

		this.read();
		this.match(LexicalUnit.INTEGER);

		this.read();
		this.match(LexicalUnit.IDENTIFIER);

		String variableName = token.getValue();

		this.read();
		this.match(LexicalUnit.PIC);

		this.read();
		this.match(LexicalUnit.IMAGE);

		VariableDecl newVariable = (VariableDecl) Image.parse(this.token.getValue());

		newVariable.setName(variableName);


		this.handle_VAR_DECL_TAIL(newVariable);
		newVariable.genCode();
		this.semanticalAnalyzer.declareVariable(variableName, newVariable);

	}

	private void handle_VAR_DECL_TAIL(VariableDecl newVariable) throws Exception{
		this.read();
		switch(this.token.unit){
			case END_OF_INSTRUCTION:
				break;
			case VALUE:
				this.read();
				this.match(LexicalUnit.INTEGER);

				newVariable.setValue(Long.decode(token.getValue()));

				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				break;

			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.END_OF_INSTRUCTION, LexicalUnit.VALUE});
				break;
		}

	}
	
	private void handle_VAR_LIST() throws Exception{
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
	
	private void handle_WORDS() throws Exception{
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
	
	private void handle_WRITE() throws Exception{
		this.read();
		this.match(LexicalUnit.DISPLAY);
		this.handle_WRITE_TAIL();
	}
	
	private void handle_WRITE_TAIL() throws Exception{
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
				IntegerVariable expression = this.handle_EXPRESSION();
				new Display(expression);
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
				break;
			case STRING:
				StringVariable variable = stringPool.get(token.getValue().substring(1, token.getValue().length() - 1));
				new Display(variable);
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);
				break;
			default:
				this.handle_bad_token(new LexicalUnit[]{LexicalUnit.LEFT_PARENTHESIS, LexicalUnit.NOT, LexicalUnit.MINUS_SIGN, LexicalUnit.IDENTIFIER, LexicalUnit.INTEGER, LexicalUnit.TRUE, LexicalUnit.FALSE, LexicalUnit.STRING});
				break;
		}
	}


	// END OF PARSING AUTOMATON


	private StringPool stringPool = new StringPool();
	private VariableAllocator variableAllocator = new VariableAllocator();

	private String currentLabel = "%0";



	public Parser(Scanner scanner, SemanticalAnalyzer semanticalAnalyzer){
		super(scanner, semanticalAnalyzer);
	}

	public void compile() throws Exception{
		this.handle_S();
		this.semanticalAnalyzer.checkLabels();
		this.stringPool.genCode();
		Display.genLibCode();
		Accept.genLibCode();
		Exit.genLibCode();
	}

	private void ensureSize(IntegerVariable left, IntegerVariable right){
		if(left.getSize() > right.getSize()) this.extendSize(right, left);
		else if(left.getSize() < right.getSize()) this.extendSize(left, right);
	}

	private void extendSize(IntegerVariable from, IntegerVariable to){
		String var = variableAllocator.getNext();
		IntegerVariable tmp = from.clone();
		IntegerVariable extended = new IntegerVariable(from.isSigned(), to.getSize(), var);
		from.mimic(extended);
		new Ext(from, tmp);
	}

	private void ensureDest(IntegerVariable left, IntegerVariable right){
		if(left.getSize() > right.getSize()) this.truncSize(left, right);
		else if(left.getSize() < right.getSize()) this.extendSize(left, right);
	}

	private void truncSize(IntegerVariable from, IntegerVariable to){
		String var = variableAllocator.getNext();
		IntegerVariable tmp = from.clone();
		IntegerVariable truncated = new IntegerVariable(to.isSigned(), to.getSize(), var);
		from.mimic(truncated);
		new Trunc(from, tmp);
	}

	private void resetCurrentLabel(){
		this.currentLabel = "%0";
	}
	
}
