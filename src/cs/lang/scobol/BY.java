package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class BY extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public BY(){
		super(SCobol.LexicalUnit.BY_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
