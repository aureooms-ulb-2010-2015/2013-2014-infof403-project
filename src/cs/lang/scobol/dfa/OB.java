package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class OB extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public OB(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('j', Language.DFAState.OBJ);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
