package cs.parser.code.system;

public class Exit{

	public Exit(){
		this.genCode();
	}

	public static void genLibCode(){
		System.out.println("declare void @exit(i32) noreturn nounwind");
	}
	
	public void genCode(){
		System.out.println("call void @exit(i32 0) noreturn nounwind");
		System.out.println("unreachable");
	}

}