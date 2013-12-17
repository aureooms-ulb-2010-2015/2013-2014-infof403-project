package cs.parser.assign; 

import cs.parser.variable.*;
import cs.parser.declaration.*;

public class AssignOp {

	protected IntegerVariable l;
	protected IntegerVariable r;
	protected String tempVar;
	protected VariableDecl to;
	protected String op;

	public AssignOp(IntegerVariable l, IntegerVariable r, String temp, VariableDecl to, String op){
		this.l = l;
		this.r = r;
		this.tempVar = temp;
		this.to = to;
		this.op = op;

		if(this.op == "div"){
			if( l.isSigned() || r.isSigned()){ this.op = "sdiv";}
			else {this.op = "udiv";}
		}

		this.genCode();
	}

	// %temp = add nsw i32 %2, %3
 	// store i32 %4, i32* %c, align 4

	//store i32 0, i32* %1
	public void genCode(){
		String greater = (l.getSize() >= r.getSize() ) ? l.getType() :  r.getType();
		System.out.printf("%s = %s %s %s, %s\n", tempVar, op, greater, l.getName(), r.getName() );
		System.out.printf("store %s %s, %s%s* %s\n", greater, tempVar, to.getLLVMType(), to.getLLVMSize(), to.getName() );
	}




}