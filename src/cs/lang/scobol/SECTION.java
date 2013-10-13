package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SECTION extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SECTION(){
		super(SCobol.LexicalUnit.SECTION_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
