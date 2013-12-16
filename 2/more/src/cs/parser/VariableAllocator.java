package cs.parser;

class VariableAllocator{
	
	private int next = -1;

	public VariableAllocator(){}

	public void reset(){
		this.next = -1;
	}

	public int getNext(){
		return ++this.next;
	}

}