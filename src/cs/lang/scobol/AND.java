package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class AND extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public AND(){
		super(SCobol.LexicalUnit.AND_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
