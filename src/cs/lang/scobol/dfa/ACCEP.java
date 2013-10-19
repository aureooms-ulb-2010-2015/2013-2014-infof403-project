package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ACCEP extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ACCEP(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.ACCEPT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
