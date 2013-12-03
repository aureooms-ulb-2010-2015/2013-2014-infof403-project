package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class MO extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public MO(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('v', Language.DFAState.MOV);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
