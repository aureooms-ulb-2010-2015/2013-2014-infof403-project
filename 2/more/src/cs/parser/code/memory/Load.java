package cs.parser.code.memory; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;


/**
 *
 * Code generator for global variable load operation.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Load{

	protected VariableDecl from;
	protected IntegerVariable to;

	public Load(IntegerVariable to, VariableDecl from){
		this.from = from;
		this.to = to;
		this.genCode();
	}

	public void genCode(){
		System.out.println( String.format("%s = load %s%s* %s", to.getName(), from.getLLVMType(), from.getLLVMSize(), from.getName()));
	}




}