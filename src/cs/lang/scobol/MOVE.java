package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class MOVE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public MOVE(){
		super(SCobol.LexicalUnit.MOVE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_4);
	}
}
