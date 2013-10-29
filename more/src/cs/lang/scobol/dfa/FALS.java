package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class FALS extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public FALS(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.FALSE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
