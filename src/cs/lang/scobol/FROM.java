package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class FROM extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public FROM(){
		super(SCobol.LexicalUnit.FROM_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_4);
	}
}
