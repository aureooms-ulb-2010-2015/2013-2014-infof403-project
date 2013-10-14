package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class CONFIGURATION extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public CONFIGURATION(){
		super(SCobol.LexicalUnit.CONFIGURATION_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_13);
	}
}
