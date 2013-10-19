package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('c', Language.DFAState.SEC);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
