package cs.parser.binary;

import cs.parser.variable.*;
import cs.parser.conditional.*;

public class And{
	private IntegerVariable var_0;
	private String label_0;
	private String label_1;

	public And(IntegerVariable var_0, String label_0, String label_1){
		this.var_0 = var_0;
		this.label_0 = label_0;
		this.label_1 = label_1;
	}

	public void genCodeLeft(IntegerVariable var_1){
		System.out.printf("%s = icmp ne %s %s, 0\n", this.var_0.getName(), this.var_0.getType(), var_1.getName());
		new If(this.var_0.getName(), this.label_0, this.label_1);
		new Label(this.label_0);
	}

	public void genCodeRight(IntegerVariable var_2){
		System.out.printf("%s = icmp ne %s %s, 0\n", this.var_0.getName(), this.var_0.getType(), var_2.getName());
		new Jump(this.label_1);
		new Label(this.label_1);
	}
}
