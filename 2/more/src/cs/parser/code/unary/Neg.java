package cs.parser.code.unary;

import cs.parser.data.variable.*;


/**
 *
 * Code generator for the '-' unary operator.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Neg{
	private IntegerVariable var_0;
	private String var_1;
	
	public Neg(IntegerVariable var_0, String var_1){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = sub nsw %s 0, %s\n", this.var_0.getName(), this.var_0.getType(), this.var_1);
	}
}