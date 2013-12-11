package cs.parser.exprAST;


/**
* BinaryExprAST - Expression class for a binary operator.
*/

public class BinaryExprAST extends ExprAST {
	protected char op;
	protected ExprAST l, r;

	public BinaryExprAST (char op, ExprAST l, ExprAST r){
		this.op = op;
		this.l = l;
		this.r = r;
	}
}
