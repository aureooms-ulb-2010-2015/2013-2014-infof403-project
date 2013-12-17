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

	public void genCode(){
		System.out.printf("%s = add i32 %s, 0\n", this.to, Integer.toString(this.val));
	}

}