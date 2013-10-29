package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class CO extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public CO(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('m', Language.DFAState.COM);
		transition.put('n', Language.DFAState.CON);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
