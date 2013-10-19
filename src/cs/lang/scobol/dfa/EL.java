package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class EL extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public EL(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('s', Language.DFAState.ELS);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
