package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DIVIDE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DIVIDE(){
		super(SCobol.LexicalUnit.DIVIDE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
