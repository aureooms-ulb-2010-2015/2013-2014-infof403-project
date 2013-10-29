package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class UNT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public UNT(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('i', Language.DFAState.UNTI);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_3);
	}
}
