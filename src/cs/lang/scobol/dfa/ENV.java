package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ENV extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ENV(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('i', Language.DFAState.ENVI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
