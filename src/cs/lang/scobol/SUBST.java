package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SUBST extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SUBST(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('r', SCobol.DFAState.SUBSTR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
