package cs.parser.code.conditional;


/**
 *
 * Code generator for jump labels.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Label{
	private String label;
	
	public Label(String label){
		this.label = label;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s:\n", this.label.substring(1));
	}
	
}