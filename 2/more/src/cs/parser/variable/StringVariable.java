package cs.parser.variable;

public class StringVariable implements Variable{

	public static final String TYPE = "string";

	public String name;

	public StringVariable(String name){
		this.name = name;
	}

	public String getType(){
		return StringVariable.TYPE;
	}
	
	public String getName(){
		return this.name;
	}
}