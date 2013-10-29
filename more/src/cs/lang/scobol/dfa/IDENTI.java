package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDENTI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('f', Language.DFAState.IDENTIF);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
