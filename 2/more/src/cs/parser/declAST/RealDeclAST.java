
package cs.parser.declAST;

public class RealDeclAST extends DeclAST{
	protected double value;

	public RealDeclAST(){}

	protected void setValue(double val){
		this.value = val;
	}

	protected double getValue(){
		return value;
	}

}