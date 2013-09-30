import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.IOException;
import java.io.FileNotFoundException;


public class HelloWorld{

	public enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
		THURSDAY, FRIDAY, SATURDAY 
	}

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

		IMAGE,
		INTEGER,
		REAL,
		STRING,
		IDENTIFIER
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		System.out.println("Hello world!");

		String[] myStringArray = {"a","b","c"};

		System.out.println(myStringArray);

		System.out.println(HelloWorld.Day.SUNDAY);

		Map<LexicalUnit,String> map = new HashMap<LexicalUnit,String>() {
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
				put(LexicalUnit.SUBTRACT_KEYWORD, "subtract");
				put(LexicalUnit.MULTIPLY_KEYWORD, "multiply");
				put(LexicalUnit.DIVIDE_KEYWORD, "divide");

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
				put(LexicalUnit.INTEGER, "(?:\\+|-)?[1-9][0-9]*");
				put(LexicalUnit.REAL, "(?:\\+|\\-)?(?:[1-9][0-9]*(?:\\.[0-9]*[1-9])?)|(?:0.[0-9]*[1-9])");
				put(LexicalUnit.STRING, "'[0-9A-Za-z\\+\\-\\*/:!\\? ]*'");

				put(LexicalUnit.COMMENT, "(?:\\*|/).*\\.\\n");
			}
		};



		List<LexicalUnit> units = Arrays.asList(LexicalUnit.values());

		System.out.println(map);

		String regex = "";
		Iterator<LexicalUnit> it = units.iterator();
		if(it.hasNext()){
			regex += "(" + map.get(it.next()) + ")";
			while(it.hasNext()){
				regex += "|" + "(" + map.get(it.next()) + ")";
			}
		}

		System.out.println(units);
		System.out.println(regex);

		Pattern pattern = Pattern.compile(regex);


		File file = new File("test/1");
		InputStream fis = new FileInputStream(file);
		Scanner scanner = new Scanner(fis);

		while(true){
			String match = scanner.findWithinHorizon(pattern, 0);
			if(match == null) break;
			System.out.print("token : ");
			System.out.print(match.replace("\n","\\n"));
			System.out.print("\t");
			System.out.print("lexical unit : ");
			LexicalUnit unit = null;
			for(int j = 1; j <= scanner.match().groupCount(); ++j){
				if(scanner.match().group(j) != null){
					unit = units.get(j-1);
					break;
				}
			}
			System.out.print(unit);
			System.out.print("\n");
		}

		fis.close();
	}
}