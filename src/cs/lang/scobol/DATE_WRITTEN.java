package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DATE_WRITTEN extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DATE_WRITTEN(){
		super(SCobol.LexicalUnit.DATE_WRITTEN_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_12);
	}
}
