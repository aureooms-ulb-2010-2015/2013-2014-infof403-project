package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DIV extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIV(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('i', SCobol.DFAState.DIVI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_3);
	}
}
