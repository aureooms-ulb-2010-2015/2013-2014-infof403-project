package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SOURC extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SOURC(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.SOURCE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
