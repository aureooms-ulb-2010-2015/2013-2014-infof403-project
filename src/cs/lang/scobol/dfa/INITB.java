package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;
import cs.lang.DFATools;
import cs.lang.scobol.Alphabet;



public class INITB extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public INITB(){
		super(null);

		transition.put('*', Language.DFAState.COMMENT_BEGIN);
		transition.put('/', Language.DFAState.COMMENT_BEGIN);

	}
}