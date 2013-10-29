package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('n', Language.DFAState.WORKIN);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
