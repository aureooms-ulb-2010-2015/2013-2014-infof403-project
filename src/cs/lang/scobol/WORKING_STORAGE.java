package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class WORKING_STORAGE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public WORKING_STORAGE(){
		super(SCobol.LexicalUnit.WORKING_STORAGE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_15);
	}
}
