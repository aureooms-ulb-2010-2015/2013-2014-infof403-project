package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class UNTI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public UNTI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('l', SCobol.DFAState.UNTIL);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
