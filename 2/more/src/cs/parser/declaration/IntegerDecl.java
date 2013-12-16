package cs.parser.declaration;

public class IntegerDecl extends VariableDecl<Integer>{
	


	public IntegerDecl(){
		super();
	}
	public IntegerDecl (String size){
		super(size);
		
	}

	public String getLLVMType(){return "i";}

	public String getValue(){return Integer.toString(val);}
	

}