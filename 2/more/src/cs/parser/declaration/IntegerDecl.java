package cs.parser.declaration;

public class IntegerDecl extends VariableDecl<Integer>{
	


	public IntegerDecl(){
		super();
	}
	public IntegerDecl (String size, boolean signed){
		super(size,signed);
		
	}

	public String getLLVMType(){return "i";}

	public String getValue(){return Integer.toString(val);}
	

}