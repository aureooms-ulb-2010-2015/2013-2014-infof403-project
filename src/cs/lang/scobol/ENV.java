package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ENV extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ENV(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('i', SCobol.DFAState.ENVI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
