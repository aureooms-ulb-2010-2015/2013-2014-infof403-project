package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PERFORM extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PERFORM(){
		super(SCobol.LexicalUnit.PERFORM_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
