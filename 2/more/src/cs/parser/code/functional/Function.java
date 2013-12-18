package cs.parser.code.functional;


public class Function{

	public static String MAIN = "start";
	
	private String name;

	public Function(String name){
		this.name = name;
		this.genCode();
	}

	public void genCode(){
		if(this.name.equals(Function.MAIN)) System.out.printf("define i64 @main(){", this.name);
		else System.out.printf("define void @%s(){", this.name);
		System.out.println();
	}
}