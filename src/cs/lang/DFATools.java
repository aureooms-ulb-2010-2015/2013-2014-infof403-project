package cs.lang;

import java.util.Map;
import java.util.List;

/**
 * Provides facility functions to manipulate transition maps.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */

public class DFATools{

	/**
	 * Makes a transition map point to a specific state 
	 * for a certain class of letters iff that
	 * transition doesn't already exists
	 *
	 * @param <S> state type
	 * @param <L> input token type (alphabet letter type)
	 *
	 * @param transition transition map
	 * @param letters a list of letters
	 * @param state the endpoint of all transitions
	 *
	 */
	
	public static <S,L> void fill(Map<L, S> transition, List<L> letters, S state){
		for(L l : letters){
			if(!transition.containsKey(l)) transition.put(l, state);
		}
	}
}