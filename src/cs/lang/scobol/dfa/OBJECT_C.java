package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class OBJECT_C extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public OBJECT_C(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('o', Language.DFAState.OBJECT_CO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_8);
	}
}
