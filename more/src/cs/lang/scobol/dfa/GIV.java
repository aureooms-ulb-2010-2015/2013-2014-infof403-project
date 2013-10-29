package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class GIV extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public GIV(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('i', Language.DFAState.GIVI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
