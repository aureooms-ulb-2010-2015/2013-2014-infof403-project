package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class DATE_ extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public DATE_(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('w', SCobol.DFAState.DATE_W);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
