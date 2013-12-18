package cs.parser.code.assign; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;

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