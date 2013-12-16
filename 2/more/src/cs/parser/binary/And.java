package cs.parser.binary;

import cs.parser.variable.*;
import cs.parser.conditional.*;

public class And{
	private IntegerVariable var_0;
	private IntegerVariable var_1;
	private IntegerVariable var_2;
	private String label_0;
	private String label_1;

	public And(IntegerVariable var_0, IntegerVariable var_1, IntegerVariable var_2, String label_0, String label_1){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.var_2 = var_2;
		this.label_0 = label_0;
		this.label_1 = label_1;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = icmp ne %s %s, 0\n", this.var_0.getName(), this.var_0.getType(), this.var_1.getName());
		new If(this.var_0.getName(), this.label_0, this.label_1);
		new Label(this.label_0);
		System.out.printf("%s = icmp ne %s %s, 0\n", this.var_0.getName(), this.var_0.getType(), this.var_2.getName());
		new Jump(this.label_1);
		new Label(this.label_1);
	}
}
