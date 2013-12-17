package cs.parser.functional;


public class FunctionEnd{
	
	private String name;

	public FunctionEnd(String name){
		this.name = name;
		this.genCode();
	}

	public void genCode(){
		if(this.name.equals(Function.MAIN)) System.out.println("ret i64 0");
		System.out.println("}");
		System.out.println();
	}
}