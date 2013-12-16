package cs.parser.variable;

public class IntegerVariable implements Variable{

	private static final String TYPE_PREFIX = "i";

	public int size;
	public String name;
	public boolean signed = true;

	public IntegerVariable(boolean signed, int size, String name){
		this.size = size;
		this.name = name;
		this.signed = signed;
	}

	public String getType(){
		return IntegerVariable.TYPE_PREFIX + Integer.toString(this.size);
	}
	
	public String getName(){
		return this.name;
	}

	public int getSize(){
		return this.size;
	}

	

}