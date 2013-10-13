package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class WOR extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public WOR(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('k', SCobol.DFAState.WORK);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
