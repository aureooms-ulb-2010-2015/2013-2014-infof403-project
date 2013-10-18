package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PROCEDURE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PROCEDURE(){
		super(SCobol.LexicalUnit.PROCEDURE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_9);
	}
}
