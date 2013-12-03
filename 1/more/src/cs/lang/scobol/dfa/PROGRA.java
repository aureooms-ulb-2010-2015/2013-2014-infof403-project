package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PROGRA extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PROGRA(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('m', Language.DFAState.PROGRAM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
