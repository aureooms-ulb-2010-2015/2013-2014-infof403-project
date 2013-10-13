package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IDENTI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IDENTI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('f', SCobol.DFAState.IDENTIF);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
