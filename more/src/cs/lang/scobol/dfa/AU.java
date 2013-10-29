package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class AU extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public AU(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.AUT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
