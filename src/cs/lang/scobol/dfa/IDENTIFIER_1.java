package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFIER_1 extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDENTIFIER_1(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('(',  Language.DFAState.IMAGE_ONE);

		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
