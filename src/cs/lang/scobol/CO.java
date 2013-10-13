package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class CO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public CO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('m', SCobol.DFAState.COM);
		transition.put('n', SCobol.DFAState.CON);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
