package cs.parser.code.functional;


/**
 *
 * Code generator for functions return value.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class FunctionEnd{
	
	private String name;

	public FunctionEnd(String name){
		this.name = name;
		this.genCode();
	}

	public void genCode(){
		if(this.name.equals(Function.MAIN)) System.out.println("ret i64 0");
		else System.out.println("ret void");
		System.out.println("}");
		System.out.println();
	}
}