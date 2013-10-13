package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class NOT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public NOT(){
		super(SCobol.LexicalUnit.NOT_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
