package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class CONFIGURATIO extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public CONFIGURATIO(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		transition.put('n', SCobol.DFAState.CONFIGURATION);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
