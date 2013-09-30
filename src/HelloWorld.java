import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

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
				put(LexicalUnit.IMAGE, "s?9(\\([1-9][0-9]*\\))?(v9(\\([1-9][0-9]*\\))?)?");
				put(LexicalUnit.INTEGER, "(\\+|-)?[1-9][0-9]*");
				put(LexicalUnit.REAL, "(\\+|\\-)?([1-9][0-9]*(\\.[0-9]*[1-9])?)|(0.[0-9]*[1-9])");
				put(LexicalUnit.STRING, "'[0-9A-Za-z\\+\\-\\*/:!\\? ]*'");
			}
		};



		List<LexicalUnit> units = new ArrayList<LexicalUnit>() {
			{
				add(LexicalUnit.IDENTIFICATION_KEYWORD);
				add(LexicalUnit.DIVISION_KEYWORD);
				add(LexicalUnit.PROGRAM_ID_KEYWORD);
				add(LexicalUnit.AUTHOR_KEYWORD);
				add(LexicalUnit.DATE_WRITTEN_KEYWORD);
				add(LexicalUnit.ENVIRONMENT_KEYWORD);
				add(LexicalUnit.CONFIGURATION_KEYWORD);
				add(LexicalUnit.SECTION_KEYWORD);
				add(LexicalUnit.SOURCE_COMPUTER_KEYWORD);
				add(LexicalUnit.OBJECT_COMPUTER_KEYWORD);
				add(LexicalUnit.DATA_KEYWORD);
				add(LexicalUnit.WORKING_STORAGE_KEYWORD);
				add(LexicalUnit.PIC_KEYWORD);
				add(LexicalUnit.VALUE_KEYWORD);
				add(LexicalUnit.PROCEDURE_KEYWORD);
				add(LexicalUnit.END_KEYWORD);
				add(LexicalUnit.PROGRAM_KEYWORD);
				add(LexicalUnit.STOP_KEYWORD);
				add(LexicalUnit.RUN_KEYWORD);
				add(LexicalUnit.MOVE_KEYWORD);
				add(LexicalUnit.TO_KEYWORD);
				add(LexicalUnit.GIVING_KEYWORD);

				add(LexicalUnit.COMPUTE_KEYWORD);
				add(LexicalUnit.ADD_KEYWORD);
				add(LexicalUnit.SUBTRACT_KEYWORD);
				add(LexicalUnit.MULTIPLY_KEYWORD);
				add(LexicalUnit.DIVIDE_KEYWORD);

				add(LexicalUnit.NOT_KEYWORD);
				add(LexicalUnit.TRUE_KEYWORD);
				add(LexicalUnit.FALSE_KEYWORD);
				add(LexicalUnit.AND_KEYWORD);
				add(LexicalUnit.OR_KEYWORD);

				add(LexicalUnit.IF_KEYWORD);
				add(LexicalUnit.ELSE_KEYWORD);
				add(LexicalUnit.END_IF_KEYWORD);
				add(LexicalUnit.PERFORM_KEYWORD);
				add(LexicalUnit.UNTIL_KEYWORD);
				add(LexicalUnit.ACCEPT_KEYWORD);
				add(LexicalUnit.DISPLAY_KEYWORD);

				add(LexicalUnit.ASTERISK);
				add(LexicalUnit.SLASH);
				add(LexicalUnit.DOT);
				add(LexicalUnit.COMMA);
				add(LexicalUnit.LEFT_PARENTHESIS);
				add(LexicalUnit.RIGHT_PARENTHESIS);
				add(LexicalUnit.NEW_LINE);

				add(LexicalUnit.EQUALS_SIGN);
				add(LexicalUnit.LOWER_SIGN);
				add(LexicalUnit.LOWER_OR_EQUALS);
				add(LexicalUnit.GREATER_SIGN);
				add(LexicalUnit.GREATER_OR_EQUALS);
				add(LexicalUnit.MINUS_SIGN);
				add(LexicalUnit.PLUS_SIGN);

				add(LexicalUnit.IDENTIFIER);
				add(LexicalUnit.IMAGE);
				add(LexicalUnit.INTEGER);
				add(LexicalUnit.REAL);
				add(LexicalUnit.STRING);
			}
		};

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

		for(int i = 0; i < 10; ++i){
			String match = scanner.findWithinHorizon(pattern, 0);
			System.out.println(match);
			System.out.println(scanner.match().group(1));
		}

		fis.close();
	}
}