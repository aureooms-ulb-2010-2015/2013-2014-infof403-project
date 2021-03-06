package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;
import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class MINUS_SIGN extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public MINUS_SIGN (){
		super(Language.LexicalUnit.MINUS_SIGN);
		transition.put('0', Language.DFAState.INTEGER_FINAL_1);

		DFATools.fill(transition, Alphabet.NON_NULL_DIGIT , Language.DFAState.INTEGER_FINAL_2);


	}
}