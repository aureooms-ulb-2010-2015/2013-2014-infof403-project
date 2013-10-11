package cs.lang;

import java.util.Map;
import java.util.List;

public class DFATools{
	
	public static <S,T,L> void fill(Map<L, S> transition, List<L> letters, S state){
		for(L l : letters){
			if(!transition.containsKey(l)) transition.put(l, state);
		}
	}
}