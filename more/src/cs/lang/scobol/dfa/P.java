package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class P extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public P(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.PE);
		transition.put('i', Language.DFAState.PI);
		transition.put('r', Language.DFAState.PR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
