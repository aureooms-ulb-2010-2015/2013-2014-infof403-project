package cs.lang;

import cs.lang.LexicalToken;
import java.io.IOException;

public interface LexicalAnalyzer<T>{
	public LexicalToken<T> nextToken() throws IOException;
	public int getLine();
	public int getCol();
}