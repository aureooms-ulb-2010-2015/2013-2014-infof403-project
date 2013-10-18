package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DISPLAY extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DISPLAY(){
		super(SCobol.LexicalUnit.DISPLAY_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_7);
	}
}