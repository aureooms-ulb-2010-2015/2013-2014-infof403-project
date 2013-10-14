package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class IDENTIFICATION extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IDENTIFICATION(){
		super(SCobol.LexicalUnit.IDENTIFICATION_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_14);
	}
}
