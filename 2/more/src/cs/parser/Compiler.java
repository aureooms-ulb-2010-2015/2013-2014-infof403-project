package cs.parser;


import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import cs.lexer.*;

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

	public void handle_VAR_DECL(){}

}