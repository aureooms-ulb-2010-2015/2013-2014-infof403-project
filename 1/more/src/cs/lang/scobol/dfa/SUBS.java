package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SUBS extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SUBS(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.SUBST);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
