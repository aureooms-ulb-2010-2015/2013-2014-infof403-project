package cs.lang;

import java.io.InputStream;

/**
 * Provides an interface for LexicalAnalyzer factories.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */

public interface LexicalAnalyzerFactory<T>{
	
	public LexicalAnalyzer<T> get(String id, InputStream stream);
}