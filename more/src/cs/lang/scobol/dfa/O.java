package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class O extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public O(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('b', Language.DFAState.OB);
		transition.put('r', Language.DFAState.OR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
