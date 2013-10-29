package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class T extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public T(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.TO);
		transition.put('r', Language.DFAState.TR);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
