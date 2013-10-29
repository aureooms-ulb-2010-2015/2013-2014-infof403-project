package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class AUT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public AUT(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('h', Language.DFAState.AUTH);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
