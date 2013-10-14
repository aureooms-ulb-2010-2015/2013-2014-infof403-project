package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IDENTIFIER_0 extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IDENTIFIER_0(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_1);
	}
}
