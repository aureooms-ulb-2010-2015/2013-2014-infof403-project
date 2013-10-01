package cs.lang;

public class LexicalToken<T>{
	private T id;
	private String value;

	public LexicalToken(T id, String value){
		this.id = id;
		this.value = value;
	}

	public T getId() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

 }