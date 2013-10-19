package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('s', Language.DFAState.DIS);
		transition.put('v', Language.DFAState.DIV);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
