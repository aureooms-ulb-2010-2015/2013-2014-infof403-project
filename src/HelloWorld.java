import java.util.Map;
import java.util.HashMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import java.io.IOException;
import java.io.FileNotFoundException;


public class HelloWorld{

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
		PROGRAM_KEYWORD,
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

		IDENTIFIER,
		IMAGE,
		INTEGER,
		REAL,
		STRING
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		System.out.println("Hello world!");

		String[] myStringArray = {"a","b","c"};

		System.out.println(myStringArray);

		System.out.println(HelloWorld.Day.SUNDAY);

		Map<String,LexicalUnit> map = new HashMap<String,LexicalUnit>() {
			{
				put("identification", LexicalUnit.IDENTIFICATION_KEYWORD);
				put("division", LexicalUnit.DIVISION_KEYWORD);
				put("program-id", LexicalUnit.PROGRAM_ID_KEYWORD);
				put("author", LexicalUnit.AUTHOR_KEYWORD);
				put("date-written", LexicalUnit.DATE_WRITTEN_KEYWORD);
				put("environment", LexicalUnit.ENVIRONMENT_KEYWORD);
				put("configuration", LexicalUnit.CONFIGURATION_KEYWORD);
				put("section", LexicalUnit.SECTION_KEYWORD);
				put("source-computer", LexicalUnit.SOURCE_COMPUTER_KEYWORD);
				put("object-computer", LexicalUnit.OBJECT_COMPUTER_KEYWORD);
				put("data", LexicalUnit.DATA_KEYWORD);
				put("working-storage", LexicalUnit.WORKING_STORAGE_KEYWORD);
				put("pic", LexicalUnit.PIC_KEYWORD);
				put("value", LexicalUnit.VALUE_KEYWORD);
				put("procedure", LexicalUnit.PROCEDURE_KEYWORD);
				put("end", LexicalUnit.END_KEYWORD);
				put("program", LexicalUnit.PROGRAM_KEYWORD);
				put("stop", LexicalUnit.STOP_KEYWORD);
				put("run", LexicalUnit.RUN_KEYWORD);
				put("move", LexicalUnit.MOVE_KEYWORD);
				put("to", LexicalUnit.TO_KEYWORD);
				put("giving", LexicalUnit.GIVING_KEYWORD);

				put("compute", LexicalUnit.COMPUTE_KEYWORD);
				put("add", LexicalUnit.ADD_KEYWORD);
				put("subtract", LexicalUnit.SUBTRACT_KEYWORD);
				put("multiply", LexicalUnit.MULTIPLY_KEYWORD);
				put("divide", LexicalUnit.DIVIDE_KEYWORD);

				put("not", LexicalUnit.NOT_KEYWORD);
				put("true", LexicalUnit.TRUE_KEYWORD);
				put("false", LexicalUnit.FALSE_KEYWORD);
				put("and", LexicalUnit.AND_KEYWORD);
				put("or", LexicalUnit.OR_KEYWORD);

				put("if", LexicalUnit.IF_KEYWORD);
				put("else", LexicalUnit.ELSE_KEYWORD);
				put("end-if", LexicalUnit.END_IF_KEYWORD);
				put("perform", LexicalUnit.PERFORM_KEYWORD);
				put("until", LexicalUnit.UNTIL_KEYWORD);
				put("accept", LexicalUnit.ACCEPT_KEYWORD);
				put("display", LexicalUnit.DISPLAY_KEYWORD);

				put("*", LexicalUnit.ASTERISK);
				put("/", LexicalUnit.SLASH);
				put(".", LexicalUnit.DOT);
				put(",", LexicalUnit.COMMA);
				put("(", LexicalUnit.LEFT_PARENTHESIS);
				put(")", LexicalUnit.RIGHT_PARENTHESIS);
				put("\n", LexicalUnit.NEW_LINE);

				put("=", LexicalUnit.EQUALS_SIGN);
				put("<", LexicalUnit.LOWER_SIGN);
				put("<=", LexicalUnit.LOWER_OR_EQUALS);
				put(">", LexicalUnit.GREATER_SIGN);
				put(">=", LexicalUnit.GREATER_OR_EQUALS);
				put("-", LexicalUnit.MINUS_SIGN);
				put("+", LexicalUnit.PLUS_SIGN);

				put("[A-Za-z][0-9A-Za-z_-]{0,15}", LexicalUnit.IDENTIFIER);
				put("s?9(\\([1-0][0-9]*\\))?(v9(\\([1-0][0-9]*\\))?)?", LexicalUnit.IMAGE);
				put("(+|-)?[1-9][0-9]*", LexicalUnit.INTEGER);
				put("(+|-)?([1-9][0-9]*(.[0-9]*[1-9])?)|(0.[0-9]*[1-9])", LexicalUnit.REAL);
				put("'[0-9A-Za-z+-\\*/:!\\? ]*'", LexicalUnit.STRING);
			}
		};

		System.out.println(map);

		for (Map.Entry<String,LexicalUnit> entry : map.entrySet()) {
			String key = entry.getKey();
			LexicalUnit value = entry.getValue();
			System.out.println(key + " : " + value);
		}


		File file = new File("test/1");
		InputStream fis = new FileInputStream(file);
		Scanner scanner = new Scanner(fis);

		for(int i = 0; i < 10; ++i){
			String match = scanner.findWithinHorizon("(identification)|([A-Za-z][0-9A-Za-z_-]{0,15})", 0);
			System.out.println(match);
			System.out.println(scanner.match().group(1));
		}

		fis.close();
	}
}