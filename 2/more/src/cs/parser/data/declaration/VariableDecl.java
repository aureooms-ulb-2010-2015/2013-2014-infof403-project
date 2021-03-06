package cs.parser.data.declaration;


/**
 *
 * Base struct for variables declaration.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

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


	public void genCode(){
		if(!assigned){
			System.out.printf("%s = common global %s%s 0\n", this.getName(),this.getLLVMType(), this.getLLVMSize());
		}
		else{
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
		this.name = "@" + name;
	}

	public String getLLVMSize(){
		return LLVMsize;
	}

	public void setLLVMSize(String size){
		LLVMsize = size;
	}

	public abstract String getLLVMType();

	public boolean isSigned(){
		return signed;
	}

	public boolean isAssigned(){
		return assigned;
	}
	
}
