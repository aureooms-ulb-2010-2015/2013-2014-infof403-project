package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class COMP extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public COMP(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('u', Language.DFAState.COMPU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
