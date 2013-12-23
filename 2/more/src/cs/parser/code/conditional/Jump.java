package cs.parser.code.conditional;


/**
 *
 * Code generator for jump statements.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Jump{
	private String label;
	
	public Jump(String label){
		this.label = label;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("br label %s\n", this.label);
	}

}