public class Assign {

	protected IntegerVariable from;
	protected  VariableDecl to;

	public Assign(IntegerVariable from, VariableDecl to){
		this.from = from;
		this.to = to;
		this.genCode();
	}

	public void genCode(){
		System.out.println( String.format("store %s %s, %s%s* %s", from.getType(), from.getName(), to.getLLVMType(), to.getLLVMSize(), to.getName()) );
	}
}