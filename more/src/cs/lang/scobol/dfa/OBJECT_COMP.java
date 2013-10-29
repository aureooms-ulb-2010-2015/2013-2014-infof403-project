package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class OBJECT_COMP extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public OBJECT_COMP(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('u', Language.DFAState.OBJECT_COMPU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_11);
	}
}
