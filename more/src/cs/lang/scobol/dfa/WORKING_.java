package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKING_ extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKING_(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('s', Language.DFAState.WORKING_S);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_8);
	}
}
