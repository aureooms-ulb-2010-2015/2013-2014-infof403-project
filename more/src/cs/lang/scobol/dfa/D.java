package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class D extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public D(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('a', Language.DFAState.DA);
		transition.put('i', Language.DFAState.DI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
