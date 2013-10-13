package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DATA extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DATA(){
		super(SCobol.LexicalUnit.DATA_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
