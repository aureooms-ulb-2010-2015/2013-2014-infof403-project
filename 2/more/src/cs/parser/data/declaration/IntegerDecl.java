package cs.parser.data.declaration;

public class IntegerDecl extends VariableDecl<Long>{
	


	public IntegerDecl(){
		super();
	}
	public IntegerDecl (String size, boolean signed){
		super(size,signed);
		
	}

	public String getLLVMType(){return "i";}

	public String getValue(){return Long.toString(val);}
	

}