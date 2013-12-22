package cs.parser.code.memory; 

import cs.parser.data.variable.*;
import cs.parser.data.declaration.*;

public class LoadInteger {

	protected long val;
	protected String to;

	public LoadInteger(String to, long val){
		this.val = val;
		this.to = to;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = add i64 %s, 0\n", this.to, Long.toString(this.val));
	}

}