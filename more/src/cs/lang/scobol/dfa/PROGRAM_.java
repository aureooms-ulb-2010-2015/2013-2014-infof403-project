package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PROGRAM_ extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PROGRAM_(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('i', Language.DFAState.PROGRAM_I);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_8);
	}
}
