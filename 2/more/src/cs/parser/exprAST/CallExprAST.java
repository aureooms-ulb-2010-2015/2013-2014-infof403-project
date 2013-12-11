package cs.parser.exprAST;

import java.util.ArrayList;


/**
*CallExprAST - Expression class for function calls.
*
*/

public class CallExprAST extends ExprAST {
	
	protected String callee;
	protected ArrayList<ExprAST> args;

	public CallExprAST(String callee, ArrayList<ExprAST> args){
		this.callee=callee;
		this.args=args;
	}
}