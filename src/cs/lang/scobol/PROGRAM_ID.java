package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PROGRAM_ID extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PROGRAM_ID(){
		super(SCobol.LexicalUnit.PROGRAM_ID_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_10);
	}
}
