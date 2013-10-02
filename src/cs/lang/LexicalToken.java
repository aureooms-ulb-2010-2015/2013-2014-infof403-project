package cs.lang;

public class LexicalToken<T>{
	private T id;
	private String value;
	private int pos;


	public LexicalToken(T id, String value, int pos){
		this.id = id;
		this.value = value;
		this.pos = pos;
	}

	public T getId() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

	public int getPos() {
		return this.pos;
	}
 }