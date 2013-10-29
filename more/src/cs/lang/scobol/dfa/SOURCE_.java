package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SOURCE_ extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SOURCE_(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('c', Language.DFAState.SOURCE_C);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_7);
	}
}
