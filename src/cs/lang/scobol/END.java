package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class END extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public END(){
		super(SCobol.LexicalUnit.END_KEYWORD);
		transition.put('-', SCobol.DFAState.END_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_3);
	}
}
