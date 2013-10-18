package cs.lang;

import cs.lang.SCobol;
import cs.lang.LexicalToken;
import java.util.Map;

/**
 * Stub class to parse token sequences .
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */

public class SCobolParser{

	private enum LocalState{
		NONE,
		IDENTIFIER,
		PROCEDURE,
		DATA
	}

	private enum State{
		HEADER,
		VARIABLES,
		LABELS
	}

	private State state = State.HEADER;
	private LocalState localState = LocalState.NONE;
	private String variable = "";
	private String label = "";

	/**
	 * Feeds the var and label tables with tokens.
	 *
	 * @param token current token
	 * @param variables variables map
	 * @param labels labels map
	 * @param line current line
	 *
	 */

	public void feed(LexicalToken<SCobol.LexicalUnit> token, Map<String, String> variables, Map<String, String> labels, int line){

		if(token.getValue().equals("data")){
			localState = LocalState.DATA;
		}
		else if(token.getValue().equals("procedure")){
			localState = LocalState.PROCEDURE;
		}
		else if(state == State.VARIABLES && token.getId() == SCobol.LexicalUnit.IDENTIFIER){
			localState = LocalState.IDENTIFIER;
			variable = token.getValue();
		}
		else if(state == State.LABELS && token.getId() == SCobol.LexicalUnit.IDENTIFIER){
			localState = LocalState.IDENTIFIER;
			label = token.getValue();
		}

		else{
			if(localState == LocalState.DATA && token.getValue().equals("division")){
				state = State.VARIABLES;
			}
			else if(localState == LocalState.PROCEDURE && token.getValue().equals("division")){
				state = State.LABELS;
			}

			if(state == State.VARIABLES && localState == LocalState.IDENTIFIER){
				if(token.getId() == SCobol.LexicalUnit.IMAGE)
					variables.put(variable, token.getValue());
				localState = LocalState.NONE;
			}

			if(state == State.LABELS && localState == LocalState.IDENTIFIER){
				if(token.getId() != SCobol.LexicalUnit.SECTION_KEYWORD){
					if(!variables.containsKey(label) && !labels.containsKey(label))
						labels.put(label, String.valueOf(line));
				}
				localState = LocalState.NONE;
			}
		}
	}
}