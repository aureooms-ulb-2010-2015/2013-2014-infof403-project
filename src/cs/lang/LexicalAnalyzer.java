package cs.lang;

import cs.lang.LexicalToken;
import java.io.IOException;

/**
 * Provides an interface for LexicalAnalyzer implementations.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 * @see     LexicalToken
 */

public interface LexicalAnalyzer<T>{
	/**
	 * @return next token
	 *
	 * @throws IOException (optional) if the implementation
	 *         grabs data from a stream that is in an invalid state.
	 */
	public LexicalToken<T> nextToken() throws IOException;

	/**
	 * @return the current line in the stream
	 */
	public int getLine();

	/**
	 * @return the current col in the current line
	 */
	public int getCol();
}