package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class FA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public FA(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('l', SCobol.DFAState.FAL);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
