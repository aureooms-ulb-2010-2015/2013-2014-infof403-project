package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class F extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public F(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('a', Language.DFAState.FA);
		transition.put('r', Language.DFAState.FR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
