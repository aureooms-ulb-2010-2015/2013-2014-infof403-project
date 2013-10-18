package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SUBSTRACT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SUBSTRACT(){
		super(SCobol.LexicalUnit.SUBSTRACT_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_9);
	}
}
