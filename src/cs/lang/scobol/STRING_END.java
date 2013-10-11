package cs.lang.scobol;

import cs.lang.DFATools;
import cs.lang.Alphabet;

import cs.lang.SCobol;
import cs.lang.DFAState;

public class STRING_END extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public STRING_END(){
		super(SCobol.LexicalUnit.STRING);
	}
}