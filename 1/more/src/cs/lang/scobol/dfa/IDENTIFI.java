package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDENTIFI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('c', Language.DFAState.IDENTIFIC);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_8);
	}
}
