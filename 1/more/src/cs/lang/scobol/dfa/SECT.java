package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SECT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SECT(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('i', Language.DFAState.SECTI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
