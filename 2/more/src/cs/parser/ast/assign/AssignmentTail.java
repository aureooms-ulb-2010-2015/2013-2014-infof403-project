package cs.parser.ast.assign; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;

/**
 *
 * AST struct for multiply and divide assignment operations.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class AssignmentTail {


	public IntegerVariable l;
	public IntegerVariable r;
	public VariableDecl to;

	public AssignmentTail (IntegerVariable l, IntegerVariable r, VariableDecl to){
		this.to = to;
		this.l = l;
		this.r = r;

	}

	public IntegerVariable getL(){
		return l;
	}
	public IntegerVariable getR(){
		return r;
	}
	public VariableDecl getTo(){
		return to;
	}

}
