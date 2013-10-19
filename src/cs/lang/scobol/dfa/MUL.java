package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class MUL extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public MUL(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.MULT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
