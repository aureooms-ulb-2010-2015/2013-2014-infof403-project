package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SUBSTR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SUBSTR(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('a', Language.DFAState.SUBSTRA);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
