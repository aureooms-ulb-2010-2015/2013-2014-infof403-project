package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFIER_4 extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDENTIFIER_4(){
		super(Language.LexicalUnit.IDENTIFIER);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
