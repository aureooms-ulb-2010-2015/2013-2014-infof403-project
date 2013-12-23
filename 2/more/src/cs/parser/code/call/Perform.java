package cs.parser.code.call;

import cs.parser.code.functional.*;

/**
 *
 * Code generator for function calls.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Perform{
	private String function;
	
	public Perform(String function){
		this.function = function;
		this.genCode();
	}

	public void genCode(){
		if(this.function.equals(Function.MAIN)) System.out.printf("call void @%s()\n", this.function);
		else System.out.printf("call void @%s%s()\n", Function.USER_PREFIX, this.function);
	}
}