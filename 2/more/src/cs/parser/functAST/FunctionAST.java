package cs.parser.functAST;

import cs.parser.exprAST.*;

/**
*
* FunctionAST - This class represents a function definition itself.
*/
public class FunctionAST{
	PrototypeAST proto;
	ExprAST body;

	public FunctionAST (PrototypeAST proto, ExprAST body){
		this.body = body;
		this.proto = proto;
	}
}