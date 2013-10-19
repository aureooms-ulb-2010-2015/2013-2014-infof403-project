package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class W extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public W(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.WO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
