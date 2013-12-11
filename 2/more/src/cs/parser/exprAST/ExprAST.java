package cs.parser.exprAST;


/**
* ExprAST - Base class for all expression nodes.
*/
public class ExprAST{

	protected String type;
	protected String name;


	public ExprAST(){}
	public ExprAST(String type){
		this.type = type;
	}

	public void setName(String name){this.name = name;}
	
}