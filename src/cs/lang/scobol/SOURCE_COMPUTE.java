package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SOURCE_COMPUTE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SOURCE_COMPUTE(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('r', SCobol.DFAState.SOURCE_COMPUTER);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
