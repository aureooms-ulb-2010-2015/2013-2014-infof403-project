package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;
import cs.lang.DFATools;
import cs.lang.Alphabet;



public class INIT extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public INIT(){
		super(null);
		transition.put('a', SCobol.DFAState.A);
		transition.put('b', SCobol.DFAState.B);
		transition.put('c', SCobol.DFAState.C);
		transition.put('d', SCobol.DFAState.D);
		transition.put('e', SCobol.DFAState.E);
		transition.put('f', SCobol.DFAState.F);
		transition.put('g', SCobol.DFAState.G);
		transition.put('i', SCobol.DFAState.I);
		transition.put('m', SCobol.DFAState.M);
		transition.put('n', SCobol.DFAState.N);
		transition.put('o', SCobol.DFAState.O);
		transition.put('p', SCobol.DFAState.P);
		transition.put('r', SCobol.DFAState.R);
		transition.put('s', SCobol.DFAState.S);
		transition.put('t', SCobol.DFAState.T);
		transition.put('u', SCobol.DFAState.U);
		transition.put('v', SCobol.DFAState.V);
		transition.put('w', SCobol.DFAState.W);

		transition.put('\n', SCobol.DFAState.NEW_LINE);
		transition.put(' ', SCobol.DFAState.WHITE_SPACE);
		transition.put('\t', SCobol.DFAState.WHITE_SPACE);


		transition.put('=', SCobol.DFAState.EQUALS_SIGN);
		transition.put('<', SCobol.DFAState.LOWER_SIGN);
		transition.put('>', SCobol.DFAState.GREATER_SIGN);
		

		

		



		transition.put('+', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('-', SCobol.DFAState.INTEGER_INSIDE);
		transition.put('0', SCobol.DFAState.INTEGER_FINAL_1);
		transition.put('\'', SCobol.DFAState.STRING_INSIDE);
		transition.put('9', SCobol.DFAState.INTEGER_FINAL_NINE);


		transition.put('*', SCobol.DFAState.ASTERISK);
		transition.put('/', SCobol.DFAState.SLASH);
		transition.put(',', SCobol.DFAState.COMMA);
		transition.put('.', SCobol.DFAState.DOT);
		transition.put('(', SCobol.DFAState.LEFT_PARENTHESIS);
		transition.put(')', SCobol.DFAState.RIGHT_PARENTHESIS);





		DFATools.fill(transition, Alphabet.ONE_HEIGHT_DIGIT , SCobol.DFAState.INTEGER_FINAL_2);


	}
}