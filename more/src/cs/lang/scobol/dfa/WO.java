package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WO extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WO(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('r', Language.DFAState.WOR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
