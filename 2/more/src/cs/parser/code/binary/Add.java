package cs.parser.code.binary;

import cs.parser.data.variable.*;

/**
 *
 * Code generator for the '+' binary operator.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Add extends Op{

	public Add(IntegerVariable var_0, IntegerVariable var_1, IntegerVariable var_2){
		super(var_0, var_1, var_2, var_0.isSigned() ? "add nsw" : "add");
	}
}