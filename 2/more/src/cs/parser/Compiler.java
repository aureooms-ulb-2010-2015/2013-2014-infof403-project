package cs.parser;


import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import cs.lexer.*;

public class Compiler{

	Scanner cobolScanner;


	public Compiler(Scanner cobolScanner){
		this.cobolScanner= cobolScanner;

	}


	public void compile() throws Exception{

		/*this.handle_IDENT();
		this.handle_ENV();
		this.handle_DATA();
		this.handle_PROC();
		return;*/




		// TODO clean

		Symbol token;
		do{
			token = cobolScanner.next_token();

			if(token != null){
				System.out.println("token: "+token.getValue()+" \tlexical unit: "+token.unit.toString());
			}

		}while(token == null || !token.unit.equals(LexicalUnit.EOF));
		
		// Printing the table
		final Map<String,Symbol<?>> tableOfSymbols = cobolScanner.getTableOfSymbols();
		List<Symbol<String>> variables = new ArrayList<Symbol<String>>();
		List<Symbol<String>> labels	 = new ArrayList<Symbol<String>>();
		// we distinguish vars/labels
		for(String identifier:tableOfSymbols.keySet()){
			try{
				final Symbol<String> symbol = (Symbol<String>)tableOfSymbols.get(identifier);
				if(symbol != null){
					if(symbol.containsKey(Symbol.IMAGE)) variables.add(symbol);
					else labels.add(symbol);
				}
			}catch(ClassCastException cce){ cce.printStackTrace(); /* we just ignore remaining information from the table*/}
		}
		// we sort vars/labels
		final Comparator<Symbol<String>> sorter = new Comparator<Symbol<String>>(){
			public int compare(Symbol<String> identifier1, Symbol<String> identifier2){
				return identifier1.getValue().compareTo(identifier2.getValue());
			}
		};
		Collections.sort(variables,sorter);
		Collections.sort(labels,sorter);
		// print
		System.out.println("variables");
		for(Symbol<String> identifier:variables)
			System.out.println(identifier.getValue()+"\t"+identifier.get(Symbol.IMAGE));
		System.out.println("labels");
		for(Symbol<String> identifier:labels)
			System.out.println(identifier.getValue()+"\t"+identifier.get(Symbol.LINE));
			
	}

	/**
	* <IDENT> →  identification division <END_INST> program-id.ID<END_INST> author. WORDS<END_INST>date-written. WORDS <END_INST>
	*/
	public void handle_IDENT() throws Exception{
		Symbol token;
		
		
		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.IDENTIFICATION)) throw new cobolSyntaxException(LexicalUnit.IDENTIFICATION,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.DIVISION)) throw new cobolSyntaxException(LexicalUnit.IDENTIFICATION,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.END_OF_INSTRUCTION)) throw new cobolSyntaxException(LexicalUnit.END_OF_INSTRUCTION,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.PROGRAM_ID)) throw new cobolSyntaxException(LexicalUnit.PROGRAM_ID,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.DOT)) throw new cobolSyntaxException(LexicalUnit.DOT,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.IDENTIFIER)) throw new cobolSyntaxException(LexicalUnit.IDENTIFIER,token.unit,token.LINE, token.COLUMN );

		System.out.println("PROGRAM_ID (IDENT): "+token.getValue());

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.END_OF_INSTRUCTION)) throw new cobolSyntaxException(LexicalUnit.END_OF_INSTRUCTION,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.AUTHOR)) throw new cobolSyntaxException(LexicalUnit.AUTHOR,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.DOT)) throw new cobolSyntaxException(LexicalUnit.DOT,token.unit,token.LINE, token.COLUMN );

		this.handle_WORDS();

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.END_OF_INSTRUCTION)) throw new cobolSyntaxException(LexicalUnit.END_OF_INSTRUCTION,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.DATE_WRITTEN)) throw new cobolSyntaxException(LexicalUnit.DATE_WRITTEN,token.unit,token.LINE, token.COLUMN );

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.DOT)) throw new cobolSyntaxException(LexicalUnit.DOT,token.unit,token.LINE, token.COLUMN );

		this.handle_WORDS();

		token = cobolScanner.next_token();
		if(!token.unit.equals(LexicalUnit.END_OF_INSTRUCTION)) throw new cobolSyntaxException(LexicalUnit.END_OF_INSTRUCTION,token.unit,token.LINE, token.COLUMN );

		//test token.next() belongs to follow 
	}

	public void handle_ENV() throws cobolSyntaxException{

	}

	public void handle_DATA() throws cobolSyntaxException{

	}

	public void handle_PROC() throws cobolSyntaxException{

	}

	public void handle_WORDS() throws cobolSyntaxException{

	}

}