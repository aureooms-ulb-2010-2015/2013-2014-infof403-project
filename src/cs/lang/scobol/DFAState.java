package cs.lang.scobol;

import java.util.Map;
import java.util.HashMap;

public class DFAState<S,T,L>{

	private T token;
	protected Map<L, S> transition = new HashMap<L, S>();

	public DFAState(T token){}

	public T token(){
		return token;
	}

	public S next(L l){
		return transition.get(l);
	}

}