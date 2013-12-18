package cs.parser.code.assign; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;

public class AssignTemp {

	protected VariableDecl from;
	protected IntegerVariable to;

	public AssignTemp(IntegerVariable to, VariableDecl from){
		this.from = from;
		this.to = to;
		this.genCode();
	}

	//store i32 0, i32* %1
	public void genCode(){
		System.out.println( String.format("%s = load %s%s* %s", to.getName(), from.getLLVMType(), from.getLLVMSize(), from.getName()));

	}




}