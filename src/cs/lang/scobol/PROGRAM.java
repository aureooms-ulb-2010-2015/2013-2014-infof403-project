package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PROGRAM extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PROGRAM(){
		super(SCobol.LexicalUnit.PROGRAM_KEYWORD);
		transition.put('-', SCobol.DFAState.PROGRAM_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_7);
	}
}
