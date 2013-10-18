package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ENVIRONMENT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ENVIRONMENT(){
		super(SCobol.LexicalUnit.ENVIRONMENT_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_11);
	}
}