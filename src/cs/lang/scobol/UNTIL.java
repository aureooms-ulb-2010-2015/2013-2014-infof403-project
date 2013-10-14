package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class UNTIL extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public UNTIL(){
		super(SCobol.LexicalUnit.UNTIL_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_5);
	}
}
