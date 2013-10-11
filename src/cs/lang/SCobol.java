package cs.lang;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

import cs.lang.DFAState;
import cs.lang.scobol.*;

public class SCobol{
	public enum LexicalUnit {
		COMMENT,

		IDENTIFICATION_KEYWORD,
		DIVISION_KEYWORD,
		PROGRAM_ID_KEYWORD,
		AUTHOR_KEYWORD,
		DATE_WRITTEN_KEYWORD,
		ENVIRONMENT_KEYWORD,
		CONFIGURATION_KEYWORD,
		SECTION_KEYWORD,
		SOURCE_COMPUTER_KEYWORD,
		OBJECT_COMPUTER_KEYWORD,
		DATA_KEYWORD,
		WORKING_STORAGE_KEYWORD,
		PIC_KEYWORD,
		VALUE_KEYWORD,
		PROCEDURE_KEYWORD,
		END_KEYWORD,
		PROGRAM_KEYWORD,
		STOP_KEYWORD,
		RUN_KEYWORD,
		MOVE_KEYWORD,
		TO_KEYWORD,
		GIVING_KEYWORD,

		COMPUTE_KEYWORD,
		ADD_KEYWORD,
		SUBSTRACT_KEYWORD,
		MULTIPLY_KEYWORD,
		DIVIDE_KEYWORD,
		FROM_KEYWORD,

		NOT_KEYWORD,
		TRUE_KEYWORD,
		FALSE_KEYWORD,
		AND_KEYWORD,
		OR_KEYWORD,

		IF_KEYWORD,
		ELSE_KEYWORD,
		END_IF_KEYWORD,
		PERFORM_KEYWORD,
		UNTIL_KEYWORD,
		ACCEPT_KEYWORD,
		DISPLAY_KEYWORD,

		ASTERISK,
		SLASH,
		DOT,
		COMMA,
		LEFT_PARENTHESIS,
		RIGHT_PARENTHESIS,
		NEW_LINE,

		EQUALS_SIGN,
		LOWER_SIGN,
		LOWER_OR_EQUALS,
		GREATER_SIGN,
		GREATER_OR_EQUALS,
		MINUS_SIGN,
		PLUS_SIGN,

		IMAGE,
		REAL,
		INTEGER,
		STRING,
		IDENTIFIER,

		WHITE_SPACE,
		BAD_TOKEN
	}


	public static final List<LexicalUnit> SEP_L = new ArrayList<LexicalUnit>(){
		{
			add(LexicalUnit.NEW_LINE);
			add(LexicalUnit.COMMENT);
		}
	};


	public static final Map<LexicalUnit,String> PATTERNS = new HashMap<LexicalUnit,String>() {
		{
			put(LexicalUnit.IDENTIFICATION_KEYWORD, "identification");
			put(LexicalUnit.DIVISION_KEYWORD, "division");
			put(LexicalUnit.PROGRAM_ID_KEYWORD, "program\\-id");
			put(LexicalUnit.AUTHOR_KEYWORD, "author");
			put(LexicalUnit.DATE_WRITTEN_KEYWORD, "date\\-written");
			put(LexicalUnit.ENVIRONMENT_KEYWORD, "environment");
			put(LexicalUnit.CONFIGURATION_KEYWORD, "configuration");
			put(LexicalUnit.SECTION_KEYWORD, "section");
			put(LexicalUnit.SOURCE_COMPUTER_KEYWORD, "source\\-computer");
			put(LexicalUnit.OBJECT_COMPUTER_KEYWORD, "object\\-computer");
			put(LexicalUnit.DATA_KEYWORD, "data");
			put(LexicalUnit.WORKING_STORAGE_KEYWORD, "working\\-storage");
			put(LexicalUnit.PIC_KEYWORD, "pic");
			put(LexicalUnit.VALUE_KEYWORD, "value");
			put(LexicalUnit.PROCEDURE_KEYWORD, "procedure");
			put(LexicalUnit.END_KEYWORD, "end");
			put(LexicalUnit.PROGRAM_KEYWORD, "program");
			put(LexicalUnit.STOP_KEYWORD, "stop");
			put(LexicalUnit.RUN_KEYWORD, "run");
			put(LexicalUnit.MOVE_KEYWORD, "move");
			put(LexicalUnit.TO_KEYWORD, "to");
			put(LexicalUnit.GIVING_KEYWORD, "giving");

			put(LexicalUnit.COMPUTE_KEYWORD, "compute");
			put(LexicalUnit.ADD_KEYWORD, "add");
			put(LexicalUnit.SUBSTRACT_KEYWORD, "substract");
			put(LexicalUnit.MULTIPLY_KEYWORD, "multiply");
			put(LexicalUnit.DIVIDE_KEYWORD, "divide");
			put(LexicalUnit.FROM_KEYWORD, "from");

			put(LexicalUnit.NOT_KEYWORD, "not");
			put(LexicalUnit.TRUE_KEYWORD, "true");
			put(LexicalUnit.FALSE_KEYWORD, "false");
			put(LexicalUnit.AND_KEYWORD, "and");
			put(LexicalUnit.OR_KEYWORD, "or");

			put(LexicalUnit.IF_KEYWORD, "if");
			put(LexicalUnit.ELSE_KEYWORD, "else");
			put(LexicalUnit.END_IF_KEYWORD, "end\\-if");
			put(LexicalUnit.PERFORM_KEYWORD, "perform");
			put(LexicalUnit.UNTIL_KEYWORD, "until");
			put(LexicalUnit.ACCEPT_KEYWORD, "accept");
			put(LexicalUnit.DISPLAY_KEYWORD, "display");

			put(LexicalUnit.ASTERISK, "\\*");
			put(LexicalUnit.SLASH, "/");
			put(LexicalUnit.DOT, "\\.");
			put(LexicalUnit.COMMA, ",");
			put(LexicalUnit.LEFT_PARENTHESIS, "\\(");
			put(LexicalUnit.RIGHT_PARENTHESIS, "\\)");
			put(LexicalUnit.NEW_LINE, "\\n");

			put(LexicalUnit.EQUALS_SIGN, "=");
			put(LexicalUnit.LOWER_SIGN, "<");
			put(LexicalUnit.LOWER_OR_EQUALS, "<=");
			put(LexicalUnit.GREATER_SIGN, ">");
			put(LexicalUnit.GREATER_OR_EQUALS, ">=");
			put(LexicalUnit.MINUS_SIGN, "\\-");
			put(LexicalUnit.PLUS_SIGN, "\\+");

			put(LexicalUnit.IDENTIFIER, "[A-Za-z][0-9A-Za-z_\\-]{0,15}");
			put(LexicalUnit.IMAGE, "s?9(?:\\([1-9][0-9]*\\))?(?:v9(?:\\([1-9][0-9]*\\))?)?");
			put(LexicalUnit.INTEGER, "(?:\\+|-)?(?:[1-9][0-9]*)|(?:0)");
			put(LexicalUnit.REAL, "(?:\\+|\\-)?(?:(?:[1-9][0-9]*)|(?:0))(?:\\.[0-9]+)");
			put(LexicalUnit.STRING, "'[0-9A-Za-z\\+\\-\\*/:!\\? ]*'");

			put(LexicalUnit.COMMENT, "(?:\\*|/).*\\.\\n");

			put(LexicalUnit.WHITE_SPACE, "[ \\t]");
			put(LexicalUnit.BAD_TOKEN, ".");
		}
	};


	public enum DFAState {
		INIT,
		COMMENT_INSIDE,
		COMMENT_DOT,
		COMMENT_END,
		D,
		DI,
		DIV,
		DIVI,
		DIVIS,
		DIVISI,
		DIVISIO,
		DIVISION,
		DA,
		DAT,
		DATA,
		STRING_END,
		STRING_INSIDE
	}

	public static final Map<DFAState, Map<Character, DFAState>> TRANSITION = new HashMap<DFAState, Map<Character, DFAState>>(){
		{
			put(DFAState.INIT, new HashMap<Character, DFAState>(){
				{
					put('d', DFAState.D);
				}
			});
			put(DFAState.D, new HashMap<Character, DFAState>(){
				{
					put('i', DFAState.DI);
					put('a', DFAState.DA);
				}
			});
			put(DFAState.DA, new HashMap<Character, DFAState>(){
				{
					put('t', DFAState.DAT);
				}
			});
			put(DFAState.DAT, new HashMap<Character, DFAState>(){
				{
					put('a', DFAState.DATA);
				}
			});
			put(DFAState.DATA, new HashMap<Character, DFAState>(){
				{
					
				}
			});
			put(DFAState.DI, new HashMap<Character, DFAState>(){
				{
					put('v', DFAState.DIV);
				}
			});
			put(DFAState.DIV, new HashMap<Character, DFAState>(){
				{
					put('i', DFAState.DIVI);
				}
			});
			put(DFAState.DIVI, new HashMap<Character, DFAState>(){
				{
					put('s', DFAState.DIVIS);
				}
			});
			put(DFAState.DIVIS, new HashMap<Character, DFAState>(){
				{
					put('i', DFAState.DIVISI);
				}
			});
			put(DFAState.DIVISI, new HashMap<Character, DFAState>(){
				{
					put('o', DFAState.DIVISIO);
				}
			});
			put(DFAState.DIVISIO, new HashMap<Character, DFAState>(){
				{
					put('n', DFAState.DIVISION);
				}
			});
			put(DFAState.DIVISION, new HashMap<Character, DFAState>(){
				{

				}
			});
		}
	};

	public static final Map<DFAState, LexicalUnit> TOKEN_M = new HashMap<DFAState, LexicalUnit>(){
		{
			put(DFAState.INIT, null);
			put(DFAState.COMMENT_END, LexicalUnit.COMMENT);
			put(DFAState.D, LexicalUnit.IDENTIFIER);
			put(DFAState.DA, LexicalUnit.IDENTIFIER);
			put(DFAState.DAT, LexicalUnit.IDENTIFIER);
			put(DFAState.DATA, LexicalUnit.DATA_KEYWORD);
			put(DFAState.DI, LexicalUnit.IDENTIFIER);
			put(DFAState.DIV, LexicalUnit.IDENTIFIER);
			put(DFAState.DIVI, LexicalUnit.IDENTIFIER);
			put(DFAState.DIVIS, LexicalUnit.IDENTIFIER);
			put(DFAState.DIVISI, LexicalUnit.IDENTIFIER);
			put(DFAState.DIVISIO, LexicalUnit.IDENTIFIER);
			put(DFAState.DIVISION, LexicalUnit.DIVISION_KEYWORD);
		}
	};

	public static final Map<DFAState, cs.lang.DFAState<DFAState, LexicalUnit, Character>> STATE
	= new HashMap<DFAState, cs.lang.DFAState<DFAState, LexicalUnit, Character>>(){
		{
			put(DFAState.INIT, new INIT());
			put(DFAState.COMMENT_INSIDE, new COMMENT_INSIDE());
			put(DFAState.COMMENT_DOT, new COMMENT_DOT());
			put(DFAState.COMMENT_END, new COMMENT_END());
			put(DFAState.D, new D());
			put(DFAState.DA, new DA());
			put(DFAState.DAT, new DAT());
			put(DFAState.DATA, new DATA());
			put(DFAState.DI, new DI());
			put(DFAState.DIV, new DIV());
			put(DFAState.DIVI, new DIVI());
			put(DFAState.DIVIS, new DIVIS());
			put(DFAState.DIVISI, new DIVISI());
			put(DFAState.DIVISIO, new DIVISIO());
			put(DFAState.DIVISION, new DIVISION());
			put(DFAState.STRING_END, new STRING_END());
			put(DFAState.STRING_INSIDE, new STRING_INSIDE());

		}
	};
}