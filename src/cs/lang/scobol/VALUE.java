package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class VALUE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public VALUE(){
		super(SCobol.LexicalUnit.VALUE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
