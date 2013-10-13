package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class ELSE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public ELSE(){
		super(SCobol.LexicalUnit.ELSE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
