package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ACCE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ACCE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('p', Language.DFAState.ACCEP);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
