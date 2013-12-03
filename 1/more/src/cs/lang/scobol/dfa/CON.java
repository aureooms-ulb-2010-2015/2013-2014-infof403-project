package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class CON extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public CON(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('f', Language.DFAState.CONF);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
