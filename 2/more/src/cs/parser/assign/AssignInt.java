package cs.parser.assign; 

import cs.parser.variable.*;
import cs.parser.declaration.*;

public class AssignInt {

	protected int val;
	protected String to;

	public AssignInt(String to, int val){
		this.val = val;
		this.to = to;
		this.genCode();
	}

	//store i32 0, i32* %1
	public void genCode(){
		System.out.println( String.format("store i32 %s, i32* %s", Integer.toString(this.val), this.to) );

	}




}