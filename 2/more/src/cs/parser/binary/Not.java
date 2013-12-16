package cs.parser.binary;

public class Not{
	private String var_0;
	private String var_1;
	
	public Not(String var_0, String var_1){
		this.var_0 = var_0;
		this.var_1 = var_1;
		this.genCode();
	}

	public void genCode(){
		System.out.printf("%s = xor i1 %s, true\n", this.var_0, this.var_1);
	}
}