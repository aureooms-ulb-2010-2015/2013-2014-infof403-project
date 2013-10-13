package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DIVI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('d', SCobol.DFAState.DIVID);
		transition.put('s', SCobol.DFAState.DIVIS);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
