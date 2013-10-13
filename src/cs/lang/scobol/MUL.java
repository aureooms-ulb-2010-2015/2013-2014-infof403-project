package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class MUL extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public MUL(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('t', SCobol.DFAState.MULT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
