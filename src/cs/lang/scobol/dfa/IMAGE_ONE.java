
package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IMAGE_ONE extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public IMAGE_ONE(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('(', Language.DFAState.IMAGE_TWO);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_2);
	}
}
