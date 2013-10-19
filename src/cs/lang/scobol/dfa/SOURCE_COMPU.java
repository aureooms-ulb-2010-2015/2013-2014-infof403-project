package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SOURCE_COMPU extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SOURCE_COMPU(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.SOURCE_COMPUT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_12);
	}
}
