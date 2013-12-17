package cs.parser.assign; 

import cs.parser.variable.*;
import cs.parser.declaration.*;

public class AssignSA {

	protected IntegerVariable that_much;
	protected VariableDecl to;
	protected String tempVar;
	protected String  tempVar2;
	protected String op;

	public AssignSA(VariableDecl to, IntegerVariable from, String tempVar, String tempVar2, String op){
		this.that_much = from;
		this.to = to;
		this.tempVar = tempVar;
		this.tempVar2 = tempVar2;
		this.op = op;
		this.genCode();
	}

	 


	//%2 = load i32* %c, align 4
  	//%3 = sub nsw i32 %2, 1
	//store i32 %3, i32* %c


	public void genCode(){
		System.out.printf("%s = load %s%s* %s\n", tempVar, to.getLLVMType(), to.getLLVMSize(), to.getName());
		System.out.printf("%s = %s %s%s %s, %s\n", tempVar2, this.op, to.getLLVMType(), to.getLLVMSize(), tempVar, that_much.getName());
		System.out.printf("store %s%s %s, %s%s* %s\n", to.getLLVMType(), to.getLLVMSize(), tempVar2, to.getLLVMType(), to.getLLVMSize(), to.getName());
	}




}