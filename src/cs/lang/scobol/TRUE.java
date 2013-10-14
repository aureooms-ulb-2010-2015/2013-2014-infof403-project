package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class TRUE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public TRUE(){
		super(SCobol.LexicalUnit.TRUE_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_4);
	}
}
