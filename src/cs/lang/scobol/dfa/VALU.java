package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class VALU extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public VALU(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.VALUE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
