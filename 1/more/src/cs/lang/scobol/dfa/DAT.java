package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DAT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DAT(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('a', Language.DFAState.DATA);
		transition.put('e', Language.DFAState.DATE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
