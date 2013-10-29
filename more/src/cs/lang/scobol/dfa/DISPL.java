package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DISPL extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DISPL(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('a', Language.DFAState.DISPLA);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
