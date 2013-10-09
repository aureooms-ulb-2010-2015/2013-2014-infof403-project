package cs.lang;

import cs.lang.LexicalToken;

public interface LexicalAnalyzer<T>{
	public LexicalToken<T> nextToken();
	public int getLine();
	public int getCol();
}