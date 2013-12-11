package cs.parser.functAST;

import cs.parser.exprAST.*;

import java.util.ArrayList;

/**
* PrototypeAST - This class represents the "prototype" for a function,
* which captures its name, and its argument names (thus implicitly the number
* of arguments the function takes)
*/

public class PrototypeAST{
	protected String name;
	protected ArrayList <String> args;

	public PrototypeAST(String name, ArrayList<String> args){
		this.name = name;
		this.args = args;
	}


}