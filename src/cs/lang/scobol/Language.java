package cs.lang.scobol;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

import cs.lang.DFAState;
import cs.lang.scobol.dfa.*;

/**
 * Static data describing the S-COBOL language.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Language{
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
		BY_KEYWORD,

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

		END_OF_INSTRUCTION,
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

	/**
	 * List of tokens announcing the end of a line.
	 */
	public static final List<LexicalUnit> SEP_L = new ArrayList<LexicalUnit>(){
		{
			add(LexicalUnit.NEW_LINE);
			add(LexicalUnit.COMMENT);
			add(LexicalUnit.END_OF_INSTRUCTION);
		}
	};

	/**
	 * List of tokens not containing any data.
	 */
	public static final List<LexicalUnit> SKIP_L = new ArrayList<LexicalUnit>(){
		{
			add(LexicalUnit.WHITE_SPACE);
		}
	};

	/**
	 * Used with LexicalAnalyzer2.
	 *
	 * @see cs.lang.LexicalAnalyzer2
	 */

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
			put(LexicalUnit.BY_KEYWORD, "by");

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

			put(LexicalUnit.END_OF_INSTRUCTION, "\\.\\n");
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
		INITB,
		COMMENT_BEGIN,
		COMMENT_END,
		COMMENT_DOT,
		COMMENT_INSIDE,
		INTEGER_FINAL_NINE,
		INTEGER_FINAL_1,
		INTEGER_FINAL_2,
		REAL_INSIDE,
		REAL_FINAL,
		STRING_END,
		STRING_INSIDE,
		IDENTIFIER_0,
		IDENTIFIER_1,
		IDENTIFIER_2,
		IDENTIFIER_3,
		IDENTIFIER_4,
		IDENTIFIER_5,
		IDENTIFIER_6,
		IDENTIFIER_7,
		IDENTIFIER_8,
		IDENTIFIER_9,
		IDENTIFIER_10,
		IDENTIFIER_11,
		IDENTIFIER_12,
		IDENTIFIER_13,
		IDENTIFIER_14,
		IDENTIFIER_15,
		NEW_LINE,
		WHITE_SPACE,
		EQUALS_SIGN,
		LOWER_OR_EQUALS,
		LOWER_SIGN,
		GREATER_SIGN,
		GREATER_OR_EQUALS,
		MINUS_SIGN,
		PLUS_SIGN,
		IMAGE_TWO,
		IMAGE_THREE,
		IMAGE_FINAL_ONE,
		IMAGE_FOUR,
		IMAGE_FIVE,
		IMAGE_SIX,
		IMAGE_ONE,
		IMAGE_FINAL_TWO,


		ASTERISK,
		SLASH,
		COMMA,
		DOT,
		LEFT_PARENTHESIS,
		RIGHT_PARENTHESIS,
		END_OF_INSTRUCTION,

		A,
		AC,
		ACC,
		ACCE,
		ACCEP,
		ACCEPT,
		AD,
		ADD,
		AN,
		AND,
		AU,
		AUT,
		AUTH,
		AUTHO,
		AUTHOR,
		B,
		BY,
		C,
		CO,
		COM,
		COMP,
		COMPU,
		COMPUT,
		COMPUTE,
		CON,
		CONF,
		CONFI,
		CONFIG,
		CONFIGU,
		CONFIGUR,
		CONFIGURA,
		CONFIGURAT,
		CONFIGURATI,
		CONFIGURATIO,
		CONFIGURATION,
		D,
		DA,
		DAT,
		DATA,
		DATE,
		DATE_,
		DATE_W,
		DATE_WR,
		DATE_WRI,
		DATE_WRIT,
		DATE_WRITT,
		DATE_WRITTE,
		DATE_WRITTEN,
		DI,
		DIS,
		DISP,
		DISPL,
		DISPLA,
		DISPLAY,
		DIV,
		DIVI,
		DIVID,
		DIVIDE,
		DIVIS,
		DIVISI,
		DIVISIO,
		DIVISION,
		E,
		EL,
		ELS,
		ELSE,
		EN,
		END,
		END_,
		END_I,
		END_IF,
		ENV,
		ENVI,
		ENVIR,
		ENVIRO,
		ENVIRON,
		ENVIRONM,
		ENVIRONME,
		ENVIRONMEN,
		ENVIRONMENT,
		F,
		FA,
		FAL,
		FALS,
		FALSE,
		FR,
		FRO,
		FROM,
		G,
		GI,
		GIV,
		GIVI,
		GIVIN,
		GIVING,
		I,
		ID,
		IDE,
		IDEN,
		IDENT,
		IDENTI,
		IDENTIF,
		IDENTIFI,
		IDENTIFIC,
		IDENTIFICA,
		IDENTIFICAT,
		IDENTIFICATI,
		IDENTIFICATIO,
		IDENTIFICATION,
		IF,
		M,
		MO,
		MOV,
		MOVE,
		MU,
		MUL,
		MULT,
		MULTI,
		MULTIP,
		MULTIPL,
		MULTIPLY,
		N,
		NO,
		NOT,
		O,
		OB,
		OBJ,
		OBJE,
		OBJEC,
		OBJECT,
		OBJECT_,
		OBJECT_C,
		OBJECT_CO,
		OBJECT_COM,
		OBJECT_COMP,
		OBJECT_COMPU,
		OBJECT_COMPUT,
		OBJECT_COMPUTE,
		OBJECT_COMPUTER,
		OR,
		P,
		PE,
		PER,
		PERF,
		PERFO,
		PERFOR,
		PERFORM,
		PI,
		PIC,
		PR,
		PRO,
		PROC,
		PROCE,
		PROCED,
		PROCEDU,
		PROCEDUR,
		PROCEDURE,
		PROG,
		PROGR,
		PROGRA,
		PROGRAM,
		PROGRAM_,
		PROGRAM_I,
		PROGRAM_ID,
		R,
		RU,
		RUN,
		S,
		SE,
		SEC,
		SECT,
		SECTI,
		SECTIO,
		SECTION,
		SO,
		SOU,
		SOUR,
		SOURC,
		SOURCE,
		SOURCE_,
		SOURCE_C,
		SOURCE_CO,
		SOURCE_COM,
		SOURCE_COMP,
		SOURCE_COMPU,
		SOURCE_COMPUT,
		SOURCE_COMPUTE,
		SOURCE_COMPUTER,
		ST,
		STO,
		STOP,
		SU,
		SUB,
		SUBS,
		SUBST,
		SUBSTR,
		SUBSTRA,
		SUBSTRAC,
		SUBSTRACT,
		T,
		TO,
		TR,
		TRU,
		TRUE,
		U,
		UN,
		UNT,
		UNTI,
		UNTIL,
		V,
		VA,
		VAL,
		VALU,
		VALUE,
		W,
		WO,
		WOR,
		WORK,
		WORKI,
		WORKIN,
		WORKING,
		WORKING_,
		WORKING_S,
		WORKING_ST,
		WORKING_STO,
		WORKING_STOR,
		WORKING_STORA,
		WORKING_STORAG,
		WORKING_STORAGE,
	}

	/**
	 * Used with LexicalAnalyzer1 (incomplete).
	 *
	 * @see cs.lang.LexicalAnalyzer1
	 *
	 */

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

	/**
	 * Used with LexicalAnalyzer1 (incomplete).
	 *
	 * @see cs.lang.LexicalAnalyzer1
	 *
	 */

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


	/**
	 * Used with LexicalAnalyzer3.
	 *
	 * @see cs.lang.LexicalAnalyzer3
	 */

	public static final Map<DFAState, cs.lang.DFAState<DFAState, LexicalUnit, Character>> STATE
	= new HashMap<DFAState, cs.lang.DFAState<DFAState, LexicalUnit, Character>>(){
		{
			put(DFAState.INIT, new INIT());
			put(DFAState.INTEGER_FINAL_1, new INTEGER_FINAL_1());
			put(DFAState.INTEGER_FINAL_2, new INTEGER_FINAL_2());
			put(DFAState.REAL_INSIDE, new REAL_INSIDE());
			put(DFAState.REAL_FINAL, new REAL_FINAL());
			put(DFAState.INTEGER_FINAL_NINE, new INTEGER_FINAL_NINE());
			put(DFAState.STRING_END, new STRING_END());
			put(DFAState.STRING_INSIDE, new STRING_INSIDE());
			
			put(DFAState.IDENTIFIER_0, new IDENTIFIER_0());
			put(DFAState.IDENTIFIER_1, new IDENTIFIER_1());
			put(DFAState.IDENTIFIER_2, new IDENTIFIER_2());
			put(DFAState.IDENTIFIER_3, new IDENTIFIER_3());
			put(DFAState.IDENTIFIER_4, new IDENTIFIER_4());
			put(DFAState.IDENTIFIER_5, new IDENTIFIER_5());
			put(DFAState.IDENTIFIER_6, new IDENTIFIER_6());
			put(DFAState.IDENTIFIER_7, new IDENTIFIER_7());
			put(DFAState.IDENTIFIER_8, new IDENTIFIER_8());
			put(DFAState.IDENTIFIER_9, new IDENTIFIER_9());
			put(DFAState.IDENTIFIER_10, new IDENTIFIER_10());
			put(DFAState.IDENTIFIER_11, new IDENTIFIER_11());
			put(DFAState.IDENTIFIER_12, new IDENTIFIER_12());
			put(DFAState.IDENTIFIER_13, new IDENTIFIER_13());
			put(DFAState.IDENTIFIER_14, new IDENTIFIER_14());
			put(DFAState.IDENTIFIER_15, new IDENTIFIER_15());

			put(DFAState.EQUALS_SIGN, new EQUALS_SIGN());
			put(DFAState.LOWER_OR_EQUALS, new LOWER_OR_EQUALS());
			put(DFAState.LOWER_SIGN, new LOWER_SIGN());
			put(DFAState.GREATER_SIGN, new GREATER_SIGN());
			put(DFAState.GREATER_OR_EQUALS, new GREATER_OR_EQUALS());
			put(DFAState.PLUS_SIGN, new PLUS_SIGN());
			put(DFAState.MINUS_SIGN, new MINUS_SIGN());
			put(DFAState.IMAGE_ONE, new IMAGE_ONE());
			put(DFAState.IMAGE_TWO, new IMAGE_TWO());
			put(DFAState.IMAGE_FINAL_ONE, new IMAGE_FINAL_ONE());
			put(DFAState.IMAGE_THREE, new IMAGE_THREE());
			put(DFAState.IMAGE_FOUR, new IMAGE_FOUR());
			put(DFAState.IMAGE_FIVE, new IMAGE_FIVE());
			put(DFAState.IMAGE_SIX, new IMAGE_SIX());
			put(DFAState.IMAGE_FINAL_TWO, new IMAGE_FINAL_TWO());

			

			put(DFAState.NEW_LINE, new NEW_LINE());
			put(DFAState.WHITE_SPACE, new WHITE_SPACE());

			put(DFAState.ASTERISK, new ASTERISK());
			put(DFAState.SLASH, new SLASH());
			put(DFAState.COMMA, new COMMA());
			put(DFAState.DOT, new DOT());
			put(DFAState.LEFT_PARENTHESIS, new LEFT_PARENTHESIS());
			put(DFAState.RIGHT_PARENTHESIS, new RIGHT_PARENTHESIS());
			put(DFAState.END_OF_INSTRUCTION, new END_OF_INSTRUCTION());


			put(DFAState.A, new A());
			put(DFAState.AC, new AC());
			put(DFAState.ACC, new ACC());
			put(DFAState.ACCE, new ACCE());
			put(DFAState.ACCEP, new ACCEP());
			put(DFAState.ACCEPT, new ACCEPT());
			put(DFAState.AD, new AD());
			put(DFAState.ADD, new ADD());
			put(DFAState.AN, new AN());
			put(DFAState.AND, new AND());
			put(DFAState.AU, new AU());
			put(DFAState.AUT, new AUT());
			put(DFAState.AUTH, new AUTH());
			put(DFAState.AUTHO, new AUTHO());
			put(DFAState.AUTHOR, new AUTHOR());
			put(DFAState.B, new B());
			put(DFAState.BY, new BY());
			put(DFAState.C, new C());
			put(DFAState.CO, new CO());
			put(DFAState.COM, new COM());
			put(DFAState.COMP, new COMP());
			put(DFAState.COMPU, new COMPU());
			put(DFAState.COMPUT, new COMPUT());
			put(DFAState.COMPUTE, new COMPUTE());
			put(DFAState.CON, new CON());
			put(DFAState.CONF, new CONF());
			put(DFAState.CONFI, new CONFI());
			put(DFAState.CONFIG, new CONFIG());
			put(DFAState.CONFIGU, new CONFIGU());
			put(DFAState.CONFIGUR, new CONFIGUR());
			put(DFAState.CONFIGURA, new CONFIGURA());
			put(DFAState.CONFIGURAT, new CONFIGURAT());
			put(DFAState.CONFIGURATI, new CONFIGURATI());
			put(DFAState.CONFIGURATIO, new CONFIGURATIO());
			put(DFAState.CONFIGURATION, new CONFIGURATION());
			put(DFAState.D, new D());
			put(DFAState.DA, new DA());
			put(DFAState.DAT, new DAT());
			put(DFAState.DATA, new DATA());
			put(DFAState.DATE, new DATE());
			put(DFAState.DATE_, new DATE_());
			put(DFAState.DATE_W, new DATE_W());
			put(DFAState.DATE_WR, new DATE_WR());
			put(DFAState.DATE_WRI, new DATE_WRI());
			put(DFAState.DATE_WRIT, new DATE_WRIT());
			put(DFAState.DATE_WRITT, new DATE_WRITT());
			put(DFAState.DATE_WRITTE, new DATE_WRITTE());
			put(DFAState.DATE_WRITTEN, new DATE_WRITTEN());
			put(DFAState.DI, new DI());
			put(DFAState.DIS, new DIS());
			put(DFAState.DISP, new DISP());
			put(DFAState.DISPL, new DISPL());
			put(DFAState.DISPLA, new DISPLA());
			put(DFAState.DISPLAY, new DISPLAY());
			put(DFAState.DIV, new DIV());
			put(DFAState.DIVI, new DIVI());
			put(DFAState.DIVID, new DIVID());
			put(DFAState.DIVIDE, new DIVIDE());
			put(DFAState.DIVIS, new DIVIS());
			put(DFAState.DIVISI, new DIVISI());
			put(DFAState.DIVISIO, new DIVISIO());
			put(DFAState.DIVISION, new DIVISION());
			put(DFAState.E, new E());
			put(DFAState.EL, new EL());
			put(DFAState.ELS, new ELS());
			put(DFAState.ELSE, new ELSE());
			put(DFAState.EN, new EN());
			put(DFAState.END, new END());
			put(DFAState.END_, new END_());
			put(DFAState.END_I, new END_I());
			put(DFAState.END_IF, new END_IF());
			put(DFAState.ENV, new ENV());
			put(DFAState.ENVI, new ENVI());
			put(DFAState.ENVIR, new ENVIR());
			put(DFAState.ENVIRO, new ENVIRO());
			put(DFAState.ENVIRON, new ENVIRON());
			put(DFAState.ENVIRONM, new ENVIRONM());
			put(DFAState.ENVIRONME, new ENVIRONME());
			put(DFAState.ENVIRONMEN, new ENVIRONMEN());
			put(DFAState.ENVIRONMENT, new ENVIRONMENT());
			put(DFAState.F, new F());
			put(DFAState.FA, new FA());
			put(DFAState.FAL, new FAL());
			put(DFAState.FALS, new FALS());
			put(DFAState.FALSE, new FALSE());
			put(DFAState.FR, new FR());
			put(DFAState.FRO, new FRO());
			put(DFAState.FROM, new FROM());
			put(DFAState.G, new G());
			put(DFAState.GI, new GI());
			put(DFAState.GIV, new GIV());
			put(DFAState.GIVI, new GIVI());
			put(DFAState.GIVIN, new GIVIN());
			put(DFAState.GIVING, new GIVING());
			put(DFAState.I, new I());
			put(DFAState.ID, new ID());
			put(DFAState.IDE, new IDE());
			put(DFAState.IDEN, new IDEN());
			put(DFAState.IDENT, new IDENT());
			put(DFAState.IDENTI, new IDENTI());
			put(DFAState.IDENTIF, new IDENTIF());
			put(DFAState.IDENTIFI, new IDENTIFI());
			put(DFAState.IDENTIFIC, new IDENTIFIC());
			put(DFAState.IDENTIFICA, new IDENTIFICA());
			put(DFAState.IDENTIFICAT, new IDENTIFICAT());
			put(DFAState.IDENTIFICATI, new IDENTIFICATI());
			put(DFAState.IDENTIFICATIO, new IDENTIFICATIO());
			put(DFAState.IDENTIFICATION, new IDENTIFICATION());
			put(DFAState.IF, new IF());
			put(DFAState.M, new M());
			put(DFAState.MO, new MO());
			put(DFAState.MOV, new MOV());
			put(DFAState.MOVE, new MOVE());
			put(DFAState.MU, new MU());
			put(DFAState.MUL, new MUL());
			put(DFAState.MULT, new MULT());
			put(DFAState.MULTI, new MULTI());
			put(DFAState.MULTIP, new MULTIP());
			put(DFAState.MULTIPL, new MULTIPL());
			put(DFAState.MULTIPLY, new MULTIPLY());
			put(DFAState.N, new N());
			put(DFAState.NO, new NO());
			put(DFAState.NOT, new NOT());
			put(DFAState.O, new O());
			put(DFAState.OB, new OB());
			put(DFAState.OBJ, new OBJ());
			put(DFAState.OBJE, new OBJE());
			put(DFAState.OBJEC, new OBJEC());
			put(DFAState.OBJECT, new OBJECT());
			put(DFAState.OBJECT_, new OBJECT_());
			put(DFAState.OBJECT_C, new OBJECT_C());
			put(DFAState.OBJECT_CO, new OBJECT_CO());
			put(DFAState.OBJECT_COM, new OBJECT_COM());
			put(DFAState.OBJECT_COMP, new OBJECT_COMP());
			put(DFAState.OBJECT_COMPU, new OBJECT_COMPU());
			put(DFAState.OBJECT_COMPUT, new OBJECT_COMPUT());
			put(DFAState.OBJECT_COMPUTE, new OBJECT_COMPUTE());
			put(DFAState.OBJECT_COMPUTER, new OBJECT_COMPUTER());
			put(DFAState.OR, new OR());
			put(DFAState.P, new P());
			put(DFAState.PE, new PE());
			put(DFAState.PER, new PER());
			put(DFAState.PERF, new PERF());
			put(DFAState.PERFO, new PERFO());
			put(DFAState.PERFOR, new PERFOR());
			put(DFAState.PERFORM, new PERFORM());
			put(DFAState.PI, new PI());
			put(DFAState.PIC, new PIC());
			put(DFAState.PR, new PR());
			put(DFAState.PRO, new PRO());
			put(DFAState.PROC, new PROC());
			put(DFAState.PROCE, new PROCE());
			put(DFAState.PROCED, new PROCED());
			put(DFAState.PROCEDU, new PROCEDU());
			put(DFAState.PROCEDUR, new PROCEDUR());
			put(DFAState.PROCEDURE, new PROCEDURE());
			put(DFAState.PROG, new PROG());
			put(DFAState.PROGR, new PROGR());
			put(DFAState.PROGRA, new PROGRA());
			put(DFAState.PROGRAM, new PROGRAM());
			put(DFAState.PROGRAM_, new PROGRAM_());
			put(DFAState.PROGRAM_I, new PROGRAM_I());
			put(DFAState.PROGRAM_ID, new PROGRAM_ID());
			put(DFAState.R, new R());
			put(DFAState.RU, new RU());
			put(DFAState.RUN, new RUN());
			put(DFAState.S, new S());
			put(DFAState.SE, new SE());
			put(DFAState.SEC, new SEC());
			put(DFAState.SECT, new SECT());
			put(DFAState.SECTI, new SECTI());
			put(DFAState.SECTIO, new SECTIO());
			put(DFAState.SECTION, new SECTION());
			put(DFAState.SO, new SO());
			put(DFAState.SOU, new SOU());
			put(DFAState.SOUR, new SOUR());
			put(DFAState.SOURC, new SOURC());
			put(DFAState.SOURCE, new SOURCE());
			put(DFAState.SOURCE_, new SOURCE_());
			put(DFAState.SOURCE_C, new SOURCE_C());
			put(DFAState.SOURCE_CO, new SOURCE_CO());
			put(DFAState.SOURCE_COM, new SOURCE_COM());
			put(DFAState.SOURCE_COMP, new SOURCE_COMP());
			put(DFAState.SOURCE_COMPU, new SOURCE_COMPU());
			put(DFAState.SOURCE_COMPUT, new SOURCE_COMPUT());
			put(DFAState.SOURCE_COMPUTE, new SOURCE_COMPUTE());
			put(DFAState.SOURCE_COMPUTER, new SOURCE_COMPUTER());
			put(DFAState.ST, new ST());
			put(DFAState.STO, new STO());
			put(DFAState.STOP, new STOP());
			put(DFAState.SU, new SU());
			put(DFAState.SUB, new SUB());
			put(DFAState.SUBS, new SUBS());
			put(DFAState.SUBST, new SUBST());
			put(DFAState.SUBSTR, new SUBSTR());
			put(DFAState.SUBSTRA, new SUBSTRA());
			put(DFAState.SUBSTRAC, new SUBSTRAC());
			put(DFAState.SUBSTRACT, new SUBSTRACT());
			put(DFAState.T, new T());
			put(DFAState.TO, new TO());
			put(DFAState.TR, new TR());
			put(DFAState.TRU, new TRU());
			put(DFAState.TRUE, new TRUE());
			put(DFAState.U, new U());
			put(DFAState.UN, new UN());
			put(DFAState.UNT, new UNT());
			put(DFAState.UNTI, new UNTI());
			put(DFAState.UNTIL, new UNTIL());
			put(DFAState.V, new V());
			put(DFAState.VA, new VA());
			put(DFAState.VAL, new VAL());
			put(DFAState.VALU, new VALU());
			put(DFAState.VALUE, new VALUE());
			put(DFAState.W, new W());
			put(DFAState.WO, new WO());
			put(DFAState.WOR, new WOR());
			put(DFAState.WORK, new WORK());
			put(DFAState.WORKI, new WORKI());
			put(DFAState.WORKIN, new WORKIN());
			put(DFAState.WORKING, new WORKING());
			put(DFAState.WORKING_, new WORKING_());
			put(DFAState.WORKING_S, new WORKING_S());
			put(DFAState.WORKING_ST, new WORKING_ST());
			put(DFAState.WORKING_STO, new WORKING_STO());
			put(DFAState.WORKING_STOR, new WORKING_STOR());
			put(DFAState.WORKING_STORA, new WORKING_STORA());
			put(DFAState.WORKING_STORAG, new WORKING_STORAG());
			put(DFAState.WORKING_STORAGE, new WORKING_STORAGE());

		}
	};

	/**
	 * Used with LexicalAnalyzer3.
	 *
	 * @see cs.lang.LexicalAnalyzer3
	 */

	public static final Map<DFAState, cs.lang.DFAState<DFAState, LexicalUnit, Character>> STATEB
	= new HashMap<DFAState, cs.lang.DFAState<DFAState, LexicalUnit, Character>>(){
		{
			put(DFAState.INITB, new INITB());
			put(DFAState.COMMENT_BEGIN, new COMMENT_INSIDE());
			put(DFAState.COMMENT_INSIDE, new COMMENT_INSIDE());
			put(DFAState.COMMENT_DOT, new COMMENT_DOT());
			put(DFAState.COMMENT_END, new COMMENT_END());
		}
	};
}