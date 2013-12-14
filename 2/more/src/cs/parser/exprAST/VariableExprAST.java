package cs.parser.exprAST;


/**
* BinaryExprAST - Expression class for a binary operator.
*/

public abstract class VariableExprAST<T> extends ExprAST {
	protected T val;
	protected String name = "";
	protected String LLVMname = "";
	protected String LLVMsize = "";
	protected boolean assigned = false;


	public VariableExprAST (){
		super();
	}

	public VariableExprAST (T value){
		super();
		this.val = value;
	}

	public VariableExprAST (String size){
		super();
		this.setLLVMSize(size);
	}




	/* example : %t0 = alloca i32 */
	public String genLLVM(){ // in future test if allocated and allocate in llvm
		return this.getLLVMName() + " = alloca " + this.getLLVMType() + this.getLLVMSize();
	}

	public T getValue(){return val;}

	public void setValue(T val){
		this.val = val;
		assigned = true;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getLLVMName(){
		return LLVMname;
	}

	public void setLLVMName(String name){ 
		this.LLVMname = name;
	}

	public String getLLVMSize(){
		return LLVMsize;
	}

	public void setLLVMSize(String size){
		LLVMsize = size;
	}

	public abstract String getLLVMType();
	
}
