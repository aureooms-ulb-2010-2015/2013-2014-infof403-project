package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ENVIRONM extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ENVIRONM(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.ENVIRONME);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_8);
	}
}
