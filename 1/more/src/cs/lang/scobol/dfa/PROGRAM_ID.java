package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class PROGRAM_ID extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public PROGRAM_ID(){
		super(Language.LexicalUnit.PROGRAM_ID_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_10);
	}
}
