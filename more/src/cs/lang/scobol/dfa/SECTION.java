package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SECTION extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SECTION(){
		super(Language.LexicalUnit.SECTION_KEYWORD);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_7);
	}
}
