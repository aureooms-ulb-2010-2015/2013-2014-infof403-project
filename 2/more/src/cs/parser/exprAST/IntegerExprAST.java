package cs.parser.exprAST;

public class IntegerExprAST extends VariableExprAST<Integer>{
	


	public IntegerExprAST(){
		super();
	}
	public IntegerExprAST (String size){
		super(size);
		
	}

	public String getLLVMType(){return "i";}
	

}