package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class ID extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public ID(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('e', Language.DFAState.IDE);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
