package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class CONF extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public CONF(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('i', Language.DFAState.CONFI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
