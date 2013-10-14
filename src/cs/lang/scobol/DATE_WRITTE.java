package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DATE_WRITTE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DATE_WRITTE(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('n', SCobol.DFAState.DATE_WRITTEN);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_11);
	}
}
