package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class MULTIPL extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public MULTIPL(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('y', Language.DFAState.MULTIPLY);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_7);
	}
}
