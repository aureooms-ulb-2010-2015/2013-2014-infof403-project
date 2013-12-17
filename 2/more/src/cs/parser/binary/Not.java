package cs.parser.binary;

import cs.parser.variable.*;

public class Not{
	private String var_0;
	private IntegerVariable var_1;
	
	public Not(String var_0, IntegerVariable var_1){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = xor %s %s, 1\n", this.var_0, this.var_1.getType(), this.var_1.getName());
	}
}