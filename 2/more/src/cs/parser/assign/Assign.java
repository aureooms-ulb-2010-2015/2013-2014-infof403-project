package cs.parser.assign; 

import cs.parser.variable.*;
import cs.parser.declaration.*;

public class Assign {

	protected IntegerVariable from;
	protected  VariableDecl to;

	public Assign(IntegerVariable from, VariableDecl to){
		this.from = from;
		this.to = to;
		this.genCode();
	}

	//store i32 0, i32* %1
	public void genCode(){
		System.out.println( String.format("store %s %s, %s%s* %s", from.getType(), from.getName(), to.getLLVMType(), to.getLLVMSize(), to.getName()) );
	}




}