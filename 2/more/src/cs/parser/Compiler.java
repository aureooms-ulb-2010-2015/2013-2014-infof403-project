package cs.parser;


import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import cs.lexer.*;
import cs.parser.functAST.*;
import cs.parser.exprAST.*;
import cs.parser.declAST.*;

public class Compiler{

	private Scanner cobolScanner;
	private Symbol<String> token;
	private boolean isReduced = false;

	public Compiler(Scanner cobolScanner){
		this.cobolScanner = cobolScanner;
	}

	public void shift() throws Exception{
		if(this.isReduced) this.isReduced = false;
		else this.token = cobolScanner.next_token();
	}

	public void reduce() throws Exception{
		this.isReduced = true;
	}

	public void check_token_unit(LexicalUnit unit) throws Exception{
		if(!this.is_token_unit(unit)) this.handle_bad_token(unit);
	}

	public boolean is_token_unit(LexicalUnit unit){
		return this.token.unit.equals(unit);
	}

	public void handle_bad_token(LexicalUnit unit  ) throws Exception{
		throw new SCOBOLGrammaticalException(unit, this.token.unit, this.token.getValue(), (Integer) this.token.get(Symbol.LINE), (Integer) this.token.get(Symbol.COLUMN));
	}

	//
	// Expression parsing
	//

	protected DeclAST parseInteger(){
		return new IntegerDeclAST(Integer.decode(token.getValue()));
	}

	protected DeclAST parseReal(){
		return new RealDeclAST(Double.valueOf(token.getValue()));
	}

	/**
	*http://www.3480-3590-data-conversion.com/article-packed-fields.html
	* S9(7) COMP-3.     Byte size = (7 + 1) / 2 = 4
	*
    * S9(5)V99 COMP-3.  Byte size = (5 + 2 + 1) / 2 = 4
	*
    * S9(6) COMP-3.     Byte size = (6 + 1) / 2 = 3.5, rounded to 4
	*
	*/

	protected DeclAST parseImage(){
		DeclAST ret = null;
		if(token.getValue().contains("v") || token.getValue().contains("V")){
			ret = new RealDeclAST(Double.valueOf(token.getValue()));
		}
		else{
			ret = new IntegerDeclAST(Integer.decode(token.getValue()));
		}
		
		return ret;
	}


	public void compile() throws Exception{
		this.handle_PROGRAM();

		// TODO clean

		// Symbol token;
		// do{
		// 	token = cobolScanner.next_token();

		// 	if(token != null){
		// 		System.out.println("token: "+token.getValue()+" \tlexical unit: "+token.unit.toString());
		// 	}

		// }while(token == null || !token.unit.equals(LexicalUnit.EOF));
		
		// // Printing the table
		// final Map<String,Symbol<?>> tableOfSymbols = cobolScanner.getTableOfSymbols();
		// List<Symbol<String>> variables = new ArrayList<Symbol<String>>();
		// List<Symbol<String>> labels	 = new ArrayList<Symbol<String>>();
		// // we distinguish vars/labels
		// for(String identifier:tableOfSymbols.keySet()){
		// 	try{
		// 		final Symbol<String> symbol = (Symbol<String>)tableOfSymbols.get(identifier);
		// 		if(symbol != null){
		// 			if(symbol.containsKey(Symbol.IMAGE)) variables.add(symbol);
		// 			else labels.add(symbol);
		// 		}
		// 	}catch(ClassCastException cce){ cce.printStackTrace(); /* we just ignore remaining information from the table*/}
		// }
		// // we sort vars/labels
		// final Comparator<Symbol<String>> sorter = new Comparator<Symbol<String>>(){
		// 	public int compare(Symbol<String> identifier1, Symbol<String> identifier2){
		// 		return identifier1.getValue().compareTo(identifier2.getValue());
		// 	}
		// };
		// Collections.sort(variables,sorter);
		// Collections.sort(labels,sorter);
		// // print
		// System.out.println("variables");
		// for(Symbol<String> identifier:variables)
		// 	System.out.println(identifier.getValue()+"\t"+identifier.get(Symbol.IMAGE));
		// System.out.println("labels");
		// for(Symbol<String> identifier:labels)
		// 	System.out.println(identifier.getValue()+"\t"+identifier.get(Symbol.LINE));
			
	}

	/**
	 *
	 * [0] <PROGRAM> → <IDENT> <ENV> <DATA> <PROC>
	 *
	 *
	 */

	public void handle_PROGRAM() throws Exception{
		this.handle_IDENT();
		this.handle_ENV();
		this.handle_DATA();
		this.handle_PROC();
	}

	/**
	* <IDENT> →  identification division <END_INST> program-id.ID<END_INST> author. WORDS<END_INST>date-written. WORDS <END_INST>
	*/
	public void handle_IDENT() throws Exception{
		
		this.shift();
		this.check_token_unit(LexicalUnit.IDENTIFICATION);

		this.shift();
		this.check_token_unit(LexicalUnit.DIVISION);

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

		this.shift();
		this.check_token_unit(LexicalUnit.PROGRAM_ID);

		this.shift();
		this.check_token_unit(LexicalUnit.DOT);

		this.shift();
		this.check_token_unit(LexicalUnit.IDENTIFIER);

		System.out.println("PROGRAM_ID (IDENT): " + token.getValue());

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

		this.shift();
		this.check_token_unit(LexicalUnit.AUTHOR);

		this.shift();
		this.check_token_unit(LexicalUnit.DOT);

		this.handle_WORDS();

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

		this.shift();
		this.check_token_unit(LexicalUnit.DATE_WRITTEN);

		this.shift();
		this.check_token_unit(LexicalUnit.DOT);

		this.handle_WORDS();

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

		//test token.next() belongs to follow 
	}
	/**environment division<END_INST>configuration section<END_INST>
	*source-computer. WORDS<END_INST>object-computer. WORDS<END_INST>
	*
	*/
	public void handle_ENV() throws Exception{

		this.shift();
		this.check_token_unit(LexicalUnit.ENVIRONMENT);

		this.shift();
		this.check_token_unit(LexicalUnit.DIVISION);

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

		this.shift();
		this.check_token_unit(LexicalUnit.CONFIGURATION);

		this.shift();
		this.check_token_unit(LexicalUnit.SECTION);

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

		this.shift();
		this.check_token_unit(LexicalUnit.SOURCE_COMPUTER);

		this.shift();
		this.check_token_unit(LexicalUnit.DOT);

		this.handle_WORDS();

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);


		this.shift();
		this.check_token_unit(LexicalUnit.OBJECT_COMPUTER);

		this.shift();
		this.check_token_unit(LexicalUnit.DOT);

		this.handle_WORDS();

		this.shift();
		this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);

		//if(!// test follow)  throw new cobolSyntaxException( );

	}

	public void handle_DATA() throws Exception{

	}

	public void handle_PROC() throws Exception{

	}

	/**
	* <WORDS> → ID <WORDS>
	*
    *		  → ε
	*/
	public void handle_WORDS() throws Exception{
		this.shift();
		switch(this.token.unit){
			case IDENTIFIER:
				// TODO add to words
				this.handle_WORDS();
				break;
			case END_OF_INSTRUCTION:
				this.reduce();
				break;

			default:
				// TODO problem
				break;
		}
	}
	/**
	* <VAR_LIST>  →  <VAR_DECL> <VAR_LIST>
	*			 →    ε
	*/
	public void handle_VAR_LIST() throws Exception{
		this.shift();
		switch(this.token.unit){
			case INTEGER:
				this.handle_VAR_DECL();
				this.handle_VAR_LIST();
				break;
			case DATA:
				this.reduce();
				break;
			default:
				break;

		}
	}

	/**
	*
	*<LABELS> → ID<END_INST> <INSTRUCTION_LIST><LABELSPRIME>
	*
	*/
	public void handle_LABELS() throws Exception{
		this.shift();
		switch(this.token.unit){
			case IDENTIFIER:
				this.shift();
				this.check_token_unit(LexicalUnit.END_OF_INSTRUCTION);
				this.handle_INSTRUCTION_LIST();
				this.handle_LABELS_END();
				break;
			default:
				//todo problem
				break;
		}


	}
	public void handle_LABELS_END() throws Exception{}
	/**
	*
	*<INSTRUCTION_LIST>     →  <INSTRUCTION> <INSTRUCTIONLIST>
	*						→    ε
	*/
	public void handle_INSTRUCTION_LIST() throws Exception{
		this.shift();
		switch(this.token.unit){
			case STOP:
				case MOVE:
				case COMPUTE:
				case ADD:
				case SUBTRACT:
				case MULTIPLY:
				case DIVIDE:
				case IF:
				case END_ID:
				case ELSE:
				case PERFORM:
				case ACCEPT:
				case DISPLAY:
				case IDENTIFIER:
					this.handle_INSTRUCTION();
					this.handle_INSTRUCTION_LIST();
					break;
			default:
				// TODO PROBLEM
				break;
		}
	}

	public void handle_VAR_DECL(){}

	public void handle_INSTRUCTION() throws Exception{
		switch(this.token.unit){

			case MOVE:
			case COMPUTE:
			case ADD:
			case SUBTRACT:
			case MULTIPLY:
			case DIVIDE:
				this.handle_ASSIGNATION();
				break;

			case IF:
				this.handle_IF();
				break;	

			case PERFORM:
				this.handle_CALL();
				break;

			case ACCEPT:
				this.handle_READ();
				break;

			case DISPLAY:
				this.handle_WRITE();
				break;

			case STOP:
				this.shift();
				this.check_token_unit(LexicalUnit.RUN);
				this.handle_END_INSTRUCTION();
				break;

			case END_ID:
			case ELSE:
			case IDENTIFIER:
			case END:
				this.reduce();
				break;

			default:
				// TODO PROBLEM
				break;
		}
	}

	public void handle_ASSIGNATION() throws Exception{}
	public void handle_IF() throws Exception{}
	public void handle_CALL() throws Exception{}
	public void handle_READ() throws Exception{}
	public void handle_WRITE() throws Exception{}
	public void handle_END_INSTRUCTION() throws Exception{}


}



// gauv <end_instr>  <instruction list> <assignation> <expression_prime> <if> <call> <read> <writeprime>
// auré <DATA> <PROC> <var decl> <var declprime> <label prime> <instruction> <assignation_end> <expression> <op> <if_end> <callprime> <write>
