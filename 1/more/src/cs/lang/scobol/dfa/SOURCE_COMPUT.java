package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class SOURCE_COMPUT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public SOURCE_COMPUT(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.SOURCE_COMPUTE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_13);
	}
}
