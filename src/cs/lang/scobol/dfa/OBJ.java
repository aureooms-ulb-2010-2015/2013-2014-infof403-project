package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class OBJ extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public OBJ(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.OBJE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
