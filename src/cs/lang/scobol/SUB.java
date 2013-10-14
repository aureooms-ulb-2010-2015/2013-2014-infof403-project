package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SUB extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SUB(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('s', SCobol.DFAState.SUBS);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_3);
	}
}
