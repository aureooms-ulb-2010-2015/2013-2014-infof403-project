package cs.parser.code.memory; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;

public class LoadInteger {

	protected int val;
	protected String to;

	public LoadInteger(String to, int val){
		this.val = val;
		this.to = to;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = add i32 %s, 0\n", this.to, Integer.toString(this.val));
	}

}