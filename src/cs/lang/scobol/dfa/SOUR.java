package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SOUR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SOUR(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('c', Language.DFAState.SOURC);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
