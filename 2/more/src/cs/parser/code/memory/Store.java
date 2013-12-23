package cs.parser.code.memory; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;


/**
 *
 * Code generator for global variable store operation.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Store {

	protected IntegerVariable from;
	protected  VariableDecl to;

	public Store(IntegerVariable from, VariableDecl to){
		this.from = from;
		this.to = to;
		this.genCode();
	}

	public void genCode(){
		System.out.println( String.format("store %s %s, %s%s* %s", from.getType(), from.getName(), to.getLLVMType(), to.getLLVMSize(), to.getName()) );
	}
}