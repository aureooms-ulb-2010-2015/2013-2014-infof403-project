package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class MULTIPLY extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public MULTIPLY(){
		super(SCobol.LexicalUnit.MULTIPLY_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
