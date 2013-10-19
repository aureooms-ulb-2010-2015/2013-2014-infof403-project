package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class CONFIG extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public CONFIG(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('u', Language.DFAState.CONFIGU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
