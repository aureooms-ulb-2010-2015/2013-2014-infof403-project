package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IDE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('n', Language.DFAState.IDEN);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
