package cs.parser.code.cast;

import cs.parser.data.variable.*;

public class Trunc{
	private IntegerVariable var_0;
	private IntegerVariable var_1;

	public Trunc(IntegerVariable var_0, IntegerVariable var_1){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = trunc %s %s to %s\n", this.var_0.getName(), this.var_1.getType(), this.var_1.getName(), this.var_0.getType());
	}
}

 //%6 = trunc i64 %5 to i32