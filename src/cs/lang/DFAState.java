package cs.lang;

import java.util.Map;
import java.util.HashMap;

/**
 * Provides a structure for DFA states using HashMaps.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 * @param <S> state type
 * @param <T> token type
 * @param <L> input token type (alphabet letter type)
 */

public class DFAState<S,T,L>{

	private T token;
	protected Map<L, S> transition = new HashMap<L, S>();

	public DFAState(T token){
		this.token = token;
	}

	/**
	 * @return the corresponding token (null if not accepting)
	 */
	public T token(){
		return token;
	}

	/**
	 * @return the state corresponding to d(q,l)
	 */
	public S next(L l){
		return transition.get(l);
	}

}