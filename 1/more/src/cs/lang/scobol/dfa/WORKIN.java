package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class WORKIN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public WORKIN(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('g', Language.DFAState.WORKING);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_6);
	}
}
