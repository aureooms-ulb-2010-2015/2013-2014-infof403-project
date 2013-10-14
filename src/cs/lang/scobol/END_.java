package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class END_ extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public END_(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('i', SCobol.DFAState.END_I);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_4);
	}
}
