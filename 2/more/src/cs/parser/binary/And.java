package cs.parser.binary;

import cs.parser.variable.*;
import cs.parser.conditional.*;

public class And{
	private IntegerVariable var_0;
	private IntegerVariable var_1;
	private IntegerVariable var_2;
	private String label_0;
	private String label_1;
	private String label_2;

	public And(IntegerVariable var_0, IntegerVariable var_1, IntegerVariable var_2, String label_0, String label_1, String label_2){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.var_2 = var_2;
		this.label_0 = label_0;
		this.label_1 = label_1;
		this.label_2 = label_2;
	}

	public void genCodeLeft(IntegerVariable left){
		System.out.printf("%s = icmp ne %s %s, 0\n", this.var_0.getName(), this.var_0.getType(), left.getName());
		new If(this.var_0.getName(), this.label_1, this.label_2);
		new Label(this.label_1);
	}

	public void genCodeRight(IntegerVariable right){
		System.out.printf("%s = icmp ne %s %s, 0\n", this.var_1.getName(), this.var_1.getType(), right.getName());
		new Jump(this.label_2);
		new Label(this.label_2);
		System.out.printf("%s = phi i1 [ false, %s ], [ %s, %s ]\n", this.var_2.getName(), this.label_0, this.var_1.getName(), this.label_1);
		
	}
}
