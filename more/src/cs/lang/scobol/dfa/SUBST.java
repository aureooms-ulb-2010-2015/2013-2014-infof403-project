package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SUBST extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SUBST(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('r', Language.DFAState.SUBSTR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
