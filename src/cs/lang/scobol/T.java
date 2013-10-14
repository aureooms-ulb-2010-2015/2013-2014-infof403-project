package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class T extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public T(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('o', SCobol.DFAState.TO);
		transition.put('r', SCobol.DFAState.TR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_1);
	}
}
