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

}