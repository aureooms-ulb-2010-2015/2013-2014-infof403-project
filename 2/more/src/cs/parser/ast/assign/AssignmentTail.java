package cs.parser.ast.assign; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;

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
