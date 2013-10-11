package cs.lang.scobol;

import cs.lang.DFATools;
import cs.lang.Alphabet;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class STRING_INSIDE extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public STRING_INSIDE(){
		super(null);
		transition.put('\'', SCobol.DFAState.STRING_END);
		// [0-9A-Za-z+-*/:!? ]
		DFATools.fill(transition, Alphabet.DIGIT, SCobol.DFAState.STRING_INSIDE);
		DFATools.fill(transition, Alphabet.LETTER, SCobol.DFAState.STRING_INSIDE);
		transition.put('+', SCobol.DFAState.STRING_INSIDE);
		transition.put('-', SCobol.DFAState.STRING_INSIDE);
		transition.put('*', SCobol.DFAState.STRING_INSIDE);
		transition.put('/', SCobol.DFAState.STRING_INSIDE);
		transition.put(':', SCobol.DFAState.STRING_INSIDE);
		transition.put('!', SCobol.DFAState.STRING_INSIDE);
		transition.put('?', SCobol.DFAState.STRING_INSIDE);
		transition.put(' ', SCobol.DFAState.STRING_INSIDE);
	}
}