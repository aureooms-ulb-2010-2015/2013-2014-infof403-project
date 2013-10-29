package cs.lang.scobol.dfa;

import cs.lang.DFATools;
import cs.lang.scobol.Alphabet;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class STRING_INSIDE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public STRING_INSIDE(){
		super(null);
		transition.put('\'', Language.DFAState.STRING_END);
		// [0-9A-Za-z+-*/:!? ]
		DFATools.fill(transition, Alphabet.DIGIT, Language.DFAState.STRING_INSIDE);
		DFATools.fill(transition, Alphabet.LETTER, Language.DFAState.STRING_INSIDE);
		transition.put('+', Language.DFAState.STRING_INSIDE);
		transition.put('-', Language.DFAState.STRING_INSIDE);
		transition.put('*', Language.DFAState.STRING_INSIDE);
		transition.put('/', Language.DFAState.STRING_INSIDE);
		transition.put(':', Language.DFAState.STRING_INSIDE);
		transition.put('!', Language.DFAState.STRING_INSIDE);
		transition.put('?', Language.DFAState.STRING_INSIDE);
		transition.put(' ', Language.DFAState.STRING_INSIDE);
	}
}