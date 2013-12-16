package cs.parser.assign; 

import ../Variable;

public class Assign {

	protected  var;
	protected  expr;

	public Assign(){
	}

	public Assign( var){
		this.setVar(var);

	}

	public Assign( var, expr){
		this.setVar(var);
		this.setExpr(expr);
	}

	public void setExpr( expr){
		this.expr = expr;
	}

	public void setVar( var){
		this.var = var; 
	}
	//store i32 0, i32* %1
	public String genCode(){
		return String("store %s %s, %s* %s",expr.getretType()

	}




}