package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class EL extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public EL(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('s', SCobol.DFAState.ELS);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_2);
	}
}
