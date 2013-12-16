package cs.parser.binary;

import cs.parser.variable.*;

public class Mul extends Op{

	public Mul(IntegerVariable var_0, IntegerVariable var_1, IntegerVariable var_2){
		super(var_0, var_1, var_2, "mul");
	}
}