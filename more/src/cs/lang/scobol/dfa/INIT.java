package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;
import cs.lang.DFATools;
import cs.lang.scobol.Alphabet;



public class INIT extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public INIT(){
		super(null);
		transition.put('a', Language.DFAState.A);
		transition.put('b', Language.DFAState.B);
		transition.put('c', Language.DFAState.C);
		transition.put('d', Language.DFAState.D);
		transition.put('e', Language.DFAState.E);
		transition.put('f', Language.DFAState.F);
		transition.put('g', Language.DFAState.G);
		transition.put('i', Language.DFAState.I);
		transition.put('m', Language.DFAState.M);
		transition.put('n', Language.DFAState.N);
		transition.put('o', Language.DFAState.O);
		transition.put('p', Language.DFAState.P);
		transition.put('r', Language.DFAState.R);
		transition.put('s', Language.DFAState.S);
		transition.put('t', Language.DFAState.T);
		transition.put('u', Language.DFAState.U);
		transition.put('v', Language.DFAState.V);
		transition.put('w', Language.DFAState.W);

		transition.put('\n', Language.DFAState.NEW_LINE);
		transition.put(' ', Language.DFAState.WHITE_SPACE);
		transition.put('\t', Language.DFAState.WHITE_SPACE);


		transition.put('=', Language.DFAState.EQUALS_SIGN);
		transition.put('<', Language.DFAState.LOWER_SIGN);
		transition.put('>', Language.DFAState.GREATER_SIGN);
		transition.put('-', Language.DFAState.MINUS_SIGN);
		transition.put('+', Language.DFAState.PLUS_SIGN);



		transition.put('0', Language.DFAState.INTEGER_FINAL_1);
		transition.put('\'', Language.DFAState.STRING_INSIDE);
		transition.put('9', Language.DFAState.INTEGER_FINAL_NINE);


		transition.put('*', Language.DFAState.ASTERISK);
		transition.put('/', Language.DFAState.SLASH);
		transition.put(',', Language.DFAState.COMMA);
		transition.put('.', Language.DFAState.DOT);
		transition.put('(', Language.DFAState.LEFT_PARENTHESIS);
		transition.put(')', Language.DFAState.RIGHT_PARENTHESIS);





		DFATools.fill(transition, Alphabet.ONE_HEIGHT_DIGIT , Language.DFAState.INTEGER_FINAL_2);
		DFATools.fill(transition, Alphabet.LETTER , Language.DFAState.IDENTIFIER_0);// first "letter" of an identifier has to be alphabetical


	}
}