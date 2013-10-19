package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PROCE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PROCE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('d', Language.DFAState.PROCED);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
