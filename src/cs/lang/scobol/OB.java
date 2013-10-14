package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class OB extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public OB(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('j', SCobol.DFAState.OBJ);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
