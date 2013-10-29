package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PROGRAM extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PROGRAM(){
		super(Language.LexicalUnit.PROGRAM_KEYWORD);
		transition.put('-', Language.DFAState.PROGRAM_);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_7);
	}
}
