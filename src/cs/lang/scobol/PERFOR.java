package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PERFOR extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PERFOR(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('m', SCobol.DFAState.PERFORM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
