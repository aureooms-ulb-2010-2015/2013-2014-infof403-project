package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DIS extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIS(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('p', SCobol.DFAState.DISP);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
