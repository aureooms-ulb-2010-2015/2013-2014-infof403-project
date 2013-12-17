package cs.parser.declaration;



public abstract class VariableDecl<T> {
	protected T val;
	protected String name = "";
	protected String LLVMsize = "";
	protected boolean assigned = false;
	protected boolean signed = false;


	public VariableDecl (){
		
	}

	public VariableDecl (T value, boolean signed){
		this.signed = signed;
		this.val = value;
	}

	public VariableDecl (String size, boolean signed){
		this.signed = signed;
		this.setLLVMSize(size);
	}


	//@b = global i32 2, align 4
	//@a = common global i32 0
	public void genCode(){ // in future test if allocated and allocate in llvm
		if(!assigned){
			System.out.printf("%s = common global %s%s 0\n", this.getName(),this.getLLVMType(), this.getLLVMSize());
		}
		else{
			//store i32 %t3, i32* %t0
			System.out.printf("%s = global %s%s %s\n", this.getName(), this.getLLVMType(), this.getLLVMSize(), this.getValue());
		}

		
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
		this.name = "@"+name;
	}

	public String getLLVMSize(){
		return LLVMsize;
	}

	public void setLLVMSize(String size){
		LLVMsize = size;
	}

	public abstract String getLLVMType();
	
}
