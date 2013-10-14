package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class CONFIGUR extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public CONFIGUR(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('a', SCobol.DFAState.CONFIGURA);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_8);
	}
}
