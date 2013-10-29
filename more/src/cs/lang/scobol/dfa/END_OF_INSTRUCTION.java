package cs.lang.scobol.dfa;
import cs.lang.scobol.Language;
import cs.lang.DFAState;

public class END_OF_INSTRUCTION extends DFAState<Language.DFAState, Language.LexicalUnit, Character>{
	public END_OF_INSTRUCTION (){
		super(Language.LexicalUnit.END_OF_INSTRUCTION);


	}
}