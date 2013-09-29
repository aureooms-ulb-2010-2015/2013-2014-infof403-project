
class HelloWorld{

	public enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
		THURSDAY, FRIDAY, SATURDAY 
	}

	public enum LexicalUnit {
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
		PROGRAM,
		STOP_KEYWORD,
		RUN_KEYWORD,
		MOVE_KEYWORD,
		TO_KEYWORD,
		GIVING_KEYWORD,

		COMPUTE_KEYWORD,
		ADD_KEYWORD,
		SUBTRACT_KEYWORD,
		MULTIPLY_KEYWORD,
		DIVIDE_KEYWORD,

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

		IDENTIFIER,
		IMAGE,
		INTEGER,
		REAL,
		STRING
	}
	
	public static void main(String[] args) {
		System.out.println("Hello world!");

		String[] myStringArray = {"a","b","c"};

		System.out.println(myStringArray);

		System.out.println(HelloWorld.Day.SUNDAY);


	// 	identification, division, program-id, author, . (a dot), nn
	// (a new line), date-written, environment, configuration, section, source-computer,
	// object-computer, data, working-storage, pic, value, procedure, end, program,
	// stop, run, move, to, compute, add, subtract, multiply, divide, giving, , (comma),
	// ( (left parenthesis), ) (right parenthesis), - (minus sign), + (plus sign), = (equals sign), * (asterisk),
	// / (slash), not, true, false, < (lower sign), > (greater sign), <= (lower or equals), >= (greater or
	// equals), and, or, if, else, end-if, perform, until, accept, display, identiﬁer, image,
	// integer, real and string
	}
}