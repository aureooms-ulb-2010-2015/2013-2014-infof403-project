package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class U extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public U(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('n', Language.DFAState.UN);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
