package cs.parser.binary;

import cs.parser.variable.*;
import cs.parser.conditional.*;

public class Or{
	private String var_0;
	private String var_1;
	private String var_2;
	private String label_0;
	private String label_1;
	private String label_2;

	public Or(String var_0, String var_1, String var_2, String label_0, String label_1, String label_2){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.var_2 = var_2;
		this.label_0 = label_0;
		this.label_1 = label_1;
		this.label_2 = label_2;
	}

	public void genCodeLeft(IntegerVariable left){
		IntegerVariable tmp = new IntegerVariable(left.isSigned(), left.getSize(), this.var_0);
		System.out.printf("%s = icmp eq %s %s, 0\n", tmp.getName(), tmp.getType(), left.getName());
		new If(tmp.getName(), this.label_1, this.label_2);
		new Label(this.label_1);
	}

	public void genCodeRight(IntegerVariable right, String call_label){
		IntegerVariable tmp = new IntegerVariable(right.isSigned(), right.getSize(), this.var_1);
		System.out.printf("%s = icmp ne %s %s, 0\n", tmp.getName(), tmp.getType(), right.getName());
		new Jump(this.label_2);
		new Label(this.label_2);
		System.out.printf("%s = phi i1 [ true, %s ], [ %s, %s ]\n", this.var_2, this.label_0, tmp.getName(), call_label);
		
	}
}
