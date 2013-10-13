package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class FALSE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public FALSE(){
		super(SCobol.LexicalUnit.FALSE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
