package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('c', Language.DFAState.PIC);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
