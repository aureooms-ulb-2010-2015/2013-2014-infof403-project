package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class OBJEC extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public OBJEC(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('t', Language.DFAState.OBJECT);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
