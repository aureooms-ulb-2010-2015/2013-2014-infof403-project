package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class COM extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public COM(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('p', Language.DFAState.COMP);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
