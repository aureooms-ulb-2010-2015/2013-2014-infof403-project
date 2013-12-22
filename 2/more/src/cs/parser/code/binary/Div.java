package cs.parser.code.binary;

import cs.parser.data.variable.*;

public class Div extends Op{

	public Div(IntegerVariable var_0, IntegerVariable var_1, IntegerVariable var_2){
		super(var_0, var_1, var_2, var_0.isSigned() ? "sdiv" : "udiv");
	}
}