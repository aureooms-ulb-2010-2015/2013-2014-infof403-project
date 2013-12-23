package cs.parser;

import cs.parser.error.*;

import cs.lexer.*;

/**
 *
 * A base class for the S-CCOBOL parser.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class ParserBase{

	private Scanner scanner;
	protected SemanticalAnalyzer semanticalAnalyzer; 
	
	protected Symbol<String> token;
	private boolean inBuffer = false;

	
	public ParserBase(Scanner scanner, SemanticalAnalyzer semanticalAnalyzer){
		this.scanner = scanner;
		this.semanticalAnalyzer = semanticalAnalyzer;
	}

	protected void read() throws Exception{
		if(this.inBuffer) this.inBuffer = false;
		else this.token = scanner.next_token();
	}

	protected void unread() throws Exception{
		this.inBuffer = true;
	}

	protected void match(LexicalUnit unit) throws Exception{
		if(!this.token.unit.equals(unit)) this.handle_bad_token(unit);
	}

	protected void handle_bad_token(LexicalUnit[] units) throws Exception{
		throw new GrammaticalException(units, this.token.unit, this.token.getValue(), (Integer) this.token.get(Symbol.LINE), (Integer) this.token.get(Symbol.COLUMN));
	}

	protected void handle_bad_token(LexicalUnit unit) throws Exception{
		throw new GrammaticalException(unit, this.token.unit, this.token.getValue(), (Integer) this.token.get(Symbol.LINE), (Integer) this.token.get(Symbol.COLUMN));
	}
}