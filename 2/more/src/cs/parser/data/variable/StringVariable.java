package cs.parser.data.variable;


/**
 *
 * Struct for string variables.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class StringVariable implements Variable{

	public static final String TYPE = "string";

	public int size;
	public String name;

	public StringVariable(int size, String name){
		this.size = size;
		this.name = name;
	}

	public String getType(){
		return StringVariable.TYPE;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getSize(){
		return this.size;
	}
}