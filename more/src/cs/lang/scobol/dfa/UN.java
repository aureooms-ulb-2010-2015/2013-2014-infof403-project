package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class UN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public UN(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.UNT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
