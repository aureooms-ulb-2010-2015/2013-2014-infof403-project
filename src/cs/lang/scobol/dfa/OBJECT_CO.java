package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class OBJECT_CO extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public OBJECT_CO(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('m', Language.DFAState.OBJECT_COM);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_9);
	}
}
