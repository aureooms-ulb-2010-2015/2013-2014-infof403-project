package cs.parser.code.binary;

import cs.parser.data.variable.*;


/**
 *
 * Code generator base for '+, *, /, -' binary operators.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Op{
	private IntegerVariable var_0;
	private IntegerVariable var_1;
	private IntegerVariable var_2;
	private String op;

	public Op(IntegerVariable var_0, IntegerVariable var_1, IntegerVariable var_2, String op){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.var_2 = var_2;
		this.op = op;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = %s %s %s, %s\n", this.var_0.getName(), this.op, this.var_0.getType(), this.var_1.getName(), this.var_2.getName());
	}
}