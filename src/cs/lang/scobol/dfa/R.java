package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class R extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public R(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('u', Language.DFAState.RU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
