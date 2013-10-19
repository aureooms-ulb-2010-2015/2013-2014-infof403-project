package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class E extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public E(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('l', Language.DFAState.EL);
		transition.put('n', Language.DFAState.EN);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
