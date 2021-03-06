package cs.parser.code.cast;

import cs.parser.data.variable.*;


/**
 *
 * Code generator for extension casts.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Ext{
	private IntegerVariable var_0;
	private IntegerVariable var_1;
	private String op;

	public Ext(IntegerVariable var_0, IntegerVariable var_1){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.op = this.var_0.isSigned() ? "sext" : "zext";
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = %s %s %s to %s\n", this.var_0.getName(), this.op, this.var_1.getType(), this.var_1.getName(), this.var_0.getType());
	}
}