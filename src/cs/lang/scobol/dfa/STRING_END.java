package cs.lang.scobol.dfa;

import cs.lang.DFATools;
import cs.lang.scobol.Alphabet;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class STRING_END extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public STRING_END(){
		super(Language.LexicalUnit.STRING);
	}
}