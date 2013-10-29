package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class MULTI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public MULTI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('p', Language.DFAState.MULTIP);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
