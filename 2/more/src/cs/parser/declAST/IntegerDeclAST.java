package cs.parser.declAST;

public class IntegerDeclAST extends DeclAST{
	protected int value;

	public IntegerDeclAST(){}

	protected void setValue(int val){
		this.value=val;
	}

	protected int getValue(){
		return value;
	}


}