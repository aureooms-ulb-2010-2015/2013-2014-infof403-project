package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class OBJECT_COMPUTER extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public OBJECT_COMPUTER(){
		super(SCobol.LexicalUnit.OBJECT_COMPUTER_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
