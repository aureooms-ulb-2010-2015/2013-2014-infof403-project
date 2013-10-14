package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SECTIO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SECTIO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('n', SCobol.DFAState.SECTION);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_6);
	}
}
