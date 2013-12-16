package cs.parser;

class VariableAllocator{
	
	private int next = -1;

	public VariableAllocator(){}

	public void reset(){
		this.next = -1;
	}

	public String getNext(){
		return "%" + Integer.toString(++this.next);
	}

}