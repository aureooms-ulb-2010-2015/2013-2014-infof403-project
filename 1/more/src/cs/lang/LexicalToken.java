package cs.lang;

/**
 * Data structure used to represent a token.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 * @param <T> token type
 */

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