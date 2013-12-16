package cs.parser.exprAST;


/**
* BinaryExprAST - Expression class for a binary operator.
*/

public class BinaryExprAST extends ExprAST {
	protected char op;
	protected ExprAST l, r;
	protected String rightVar;
	protected String retType;

	public BinaryExprAST (char op, ExprAST l, ExprAST r){
		this.setOp(op);
		this.setLExpr(l);
		this.setOp(op);
	}

	public BinaryExprAST (ExprAST l){
		this.setLExpr(l);
		
	}

	public BinaryExprAST (ExprAST l, ExprAST r){
		this.setLExpr(l);
		this.setRExpr(r);
		
	}

	public void setRightVar(String right){
		this.rightVar = right;
	}

	public void setRetType(String retType){
		this.retType = retType;
	}

	public String getRetType(){
		ret retType;
	}

	public BinaryExprAST (char op){
		this.setOp(op);
		
	}

    public void setLExpr(ExprAST l){
    	this.l = l;
    }
	public void setRExpr(ExprAST r){
		this.r = r;
	}

	public void setOp(char op){
		this.op = op;
	}
}
