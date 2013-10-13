package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class PIC extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public PIC(){
		super(SCobol.LexicalUnit.PIC_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
