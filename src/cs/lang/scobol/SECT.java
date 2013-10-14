package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SECT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SECT(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('i', SCobol.DFAState.SECTI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_4);
	}
}
