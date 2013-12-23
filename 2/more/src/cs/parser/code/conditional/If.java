package cs.parser.code.conditional;


/**
 *
 * Code generator for the 'if' conditional jump.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class If{

	private String variable;
	private String label_0;
	private String label_1;
	
	public If(String variable, String label_0, String label_1){
		this.variable = variable;
		this.label_0 = label_0;
		this.label_1 = label_1;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("br i1 %s, label %s, label %s\n", this.variable, this.label_0, this.label_1);
	}


}