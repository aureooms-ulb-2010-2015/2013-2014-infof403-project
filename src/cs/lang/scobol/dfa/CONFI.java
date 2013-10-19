package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class CONFI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public CONFI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('g', Language.DFAState.CONFIG);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_5);
	}
}
