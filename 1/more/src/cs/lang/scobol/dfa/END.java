package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class END extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public END(){
		super(Language.LexicalUnit.END_KEYWORD);
		transition.put('-', Language.DFAState.END_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
