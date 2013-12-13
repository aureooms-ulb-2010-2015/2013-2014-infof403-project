package cs.parser.exprAST;


/**
* BinaryExprAST - Expression class for a binary operator.
*/

public class VariableExprAST<T> extends ExprAST {
	protected T val;
	protected String name = "";
	protected String LLVMname = "";


	public VariableExprAST (){super();}

	public VariableExprAST (T value){
		super();
		this.val = value;
	}



	public T getValue(){return val;}

	public void setValue(T val){this.val = val;}

	public String getName(){ return name;}
	public void setName(String name){ this.name = name;}

	public String getLLVMName(){ return LLVMname;}
	public void setLLVMName(String name){ this.LLVMname = name;}
}
