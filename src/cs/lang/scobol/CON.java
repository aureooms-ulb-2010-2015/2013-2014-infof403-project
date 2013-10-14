package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class CON extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public CON(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('f', SCobol.DFAState.CONF);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_3);
	}
}
