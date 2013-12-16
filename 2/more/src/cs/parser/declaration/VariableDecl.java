package cs.parser.declaration;



public abstract class VariableDecl<T> {
	protected T val;
	protected String name = "";
	protected String LLVMsize = "";
	protected boolean assigned = false;


	public VariableExprAST (){
		
	}

	public VariableExprAST (T value){
		
		this.val = value;
	}

	public VariableExprAST (String size){
		
		this.setLLVMSize(size);
	}




	/* example : %t0 = alloca i32 */
	public void genCode(){ // in future test if allocated and allocate in llvm
		String ret = String.format("%s = alloca %s%s\n", this.getName(),this.getLLVMType(), this.getLLVMSize() );
		if(assigned){
			//store i32 %t3, i32* %t0
			ret+=String.format("store %s %s, %s%s* %s", this.getLLVMType(), this.getValue(), this.getLLVMType(), this.getLLVMSize(), this.getName());
		}

		System.out.println(ret);
	}

	public abstract String getValue();

	public void setValue(T val){
		this.val = val;
		assigned = true;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = "%"+name;
	}

	public String getLLVMSize(){
		return LLVMsize;
	}

	public void setLLVMSize(String size){
		LLVMsize = size;
	}

	public abstract String getLLVMType();
	
}
