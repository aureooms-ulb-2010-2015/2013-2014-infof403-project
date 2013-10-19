package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DIVI extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DIVI(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('d', Language.DFAState.DIVID);
		transition.put('s', Language.DFAState.DIVIS);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_4);
	}
}
