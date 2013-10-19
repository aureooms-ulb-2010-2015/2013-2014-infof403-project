package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFIC extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDENTIFIC(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('a', Language.DFAState.IDENTIFICA);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_9);
	}
}
