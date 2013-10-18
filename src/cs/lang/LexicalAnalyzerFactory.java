package cs.lang;

import java.io.InputStream;

public interface LexicalAnalyzerFactory<T>{
	
	public LexicalAnalyzer<T> get(String id, InputStream stream);
}