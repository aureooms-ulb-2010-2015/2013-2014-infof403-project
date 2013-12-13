

package cs.parser.exprAST;

public class RealExprAST extends VariableExprAST<Double>{
	
	public RealExprAST(){
		super();
	}
	
	public RealExprAST (String size){
		super(size);
	}

	public String getLLVMType(){return "i";}//replace by float declaration syntax in LLVM
}