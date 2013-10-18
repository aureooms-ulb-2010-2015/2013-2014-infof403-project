package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DI extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DI(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('s', SCobol.DFAState.DIS);
		transition.put('v', SCobol.DFAState.DIV);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
