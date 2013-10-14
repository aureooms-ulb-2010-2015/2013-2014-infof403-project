package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class CONFI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public CONFI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('g', SCobol.DFAState.CONFIG);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_5);
	}
}
