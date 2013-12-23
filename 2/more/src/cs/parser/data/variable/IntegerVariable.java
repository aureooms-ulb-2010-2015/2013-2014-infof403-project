package cs.parser.data.variable;

import cs.parser.data.declaration.*;


/**
 *
 * Struct for integer variables.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class IntegerVariable implements Variable{

	private static final String TYPE_PREFIX = "i";

	private boolean signed;
	private int size;
	private String name;

	public IntegerVariable(boolean signed, int size, String name){
		this.signed = signed;
		this.size = size;
		this.name = name;
	}

	public IntegerVariable(VariableDecl decl){
		this.signed = decl.isSigned();
		this.size = Integer.decode(decl.getLLVMSize());
		this.name = decl.getName();
	}

	public IntegerVariable(VariableDecl decl, String tmp){
		this.signed = decl.isSigned();
		this.size = Integer.decode(decl.getLLVMSize());
		this.name = tmp;
	}

	public IntegerVariable(IntegerVariable other){
		this.mimic(other);
	}

	public IntegerVariable clone(){
		return new IntegerVariable(this);
	}

	public void mimic(IntegerVariable other){
		this.signed = other.signed;
		this.size = other.size;
		this.name = other.name;
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

	public boolean isSigned(){
		return this.signed;
	}

	

}