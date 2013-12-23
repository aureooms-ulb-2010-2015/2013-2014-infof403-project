package cs.parser.code.call;


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
		System.out.printf("call void @%s()\n", this.function);
	}
}