package cs.parser.code.binary;

import cs.parser.data.variable.*;
import cs.parser.code.conditional.*;

/**
 *
 * Code generator for the 'and' binary operator.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class And extends Phi{

	public And(String var_0, String var_1, String var_2, String label_0, String label_1, String label_2){
		super(var_0, var_1, var_2, label_0, label_1, label_2, "ne", "false");
	}

}
