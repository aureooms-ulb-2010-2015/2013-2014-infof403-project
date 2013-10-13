package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class GI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public GI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('v', SCobol.DFAState.GIV);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
