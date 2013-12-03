package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class MU extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public MU(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('l', Language.DFAState.MUL);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
