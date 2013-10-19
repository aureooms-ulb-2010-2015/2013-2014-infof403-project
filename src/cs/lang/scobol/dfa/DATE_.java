package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DATE_ extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DATE_(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('w', Language.DFAState.DATE_W);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
