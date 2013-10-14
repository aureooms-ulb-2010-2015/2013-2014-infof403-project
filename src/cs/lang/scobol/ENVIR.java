package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ENVIR extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ENVIR(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('o', SCobol.DFAState.ENVIRO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_5);
	}
}
