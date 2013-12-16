package cs.parser.variable;

public class IntegerVariable implements Variable{

	private static final String TYPE_PREFIX = "i";

	public int size;
	public String name;

	public IntegerVariable(int size, String name){
		this.size = size;
		this.name = name;
	}

	public String getType(){
		return IntegerVariable.TYPE_PREFIX + Integer.toString(this.size);
	}
	
	public String getName(){
		return this.name;
	}
}