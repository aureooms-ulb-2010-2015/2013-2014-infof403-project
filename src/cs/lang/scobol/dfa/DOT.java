package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class DOT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public DOT(){
		super(Language.LexicalUnit.DOT);
	}
}
