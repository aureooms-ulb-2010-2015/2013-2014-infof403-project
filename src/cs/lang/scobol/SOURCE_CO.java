package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class SOURCE_CO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public SOURCE_CO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('m', SCobol.DFAState.SOURCE_COM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
