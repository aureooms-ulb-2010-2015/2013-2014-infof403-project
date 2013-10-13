package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class AUT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public AUT(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('h', SCobol.DFAState.AUTH);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
