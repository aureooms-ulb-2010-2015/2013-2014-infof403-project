package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class GIVING extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public GIVING(){
		super(SCobol.LexicalUnit.GIVING_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
