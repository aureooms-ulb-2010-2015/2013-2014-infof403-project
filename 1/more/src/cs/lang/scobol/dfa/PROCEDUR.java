package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PROCEDUR extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PROCEDUR(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.PROCEDURE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_8);
	}
}
