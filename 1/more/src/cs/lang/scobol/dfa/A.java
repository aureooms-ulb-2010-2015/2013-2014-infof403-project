package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class A extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public A(){
		super(Language.LexicalUnit.IDENTIFIER);
		transition.put('c', Language.DFAState.AC);
		transition.put('d', Language.DFAState.AD);
		transition.put('n', Language.DFAState.AN);
		transition.put('u', Language.DFAState.AU);
		DFATools.fill(transition, Alphabet.IDENTIFIER, Language.DFAState.IDENTIFIER_1);
	}
}
