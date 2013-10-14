package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SOURCE_COM extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SOURCE_COM(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('p', SCobol.DFAState.SOURCE_COMP);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_10);
	}
}
