package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class END_IF extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public END_IF(){
		super(SCobol.LexicalUnit.END_IF_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_6);
	}
}
