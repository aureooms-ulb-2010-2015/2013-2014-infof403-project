package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DATE_WRI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DATE_WRI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('t', SCobol.DFAState.DATE_WRIT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_8);
	}
}
