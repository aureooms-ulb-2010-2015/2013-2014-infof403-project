package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SOURCE_COM extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SOURCE_COM(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('p', Language.DFAState.SOURCE_COMP);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_10);
	}
}
