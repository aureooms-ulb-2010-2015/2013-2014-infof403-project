package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFICATI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDENTIFICATI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.IDENTIFICATIO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_12);
	}
}
