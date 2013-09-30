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

import cs.lang.SCobol;

public class HelloWorld{
	
	public static void main(String[] args) throws FileNotFoundException, IOException{

		Map<SCobol.LexicalUnit,String> map = new HashMap<SCobol.LexicalUnit,String>() {
			{
				put(SCobol.LexicalUnit.IDENTIFICATION_KEYWORD, "identification");
				put(SCobol.LexicalUnit.DIVISION_KEYWORD, "division");
				put(SCobol.LexicalUnit.PROGRAM_ID_KEYWORD, "program\\-id");
				put(SCobol.LexicalUnit.AUTHOR_KEYWORD, "author");
				put(SCobol.LexicalUnit.DATE_WRITTEN_KEYWORD, "date\\-written");
				put(SCobol.LexicalUnit.ENVIRONMENT_KEYWORD, "environment");
				put(SCobol.LexicalUnit.CONFIGURATION_KEYWORD, "configuration");
				put(SCobol.LexicalUnit.SECTION_KEYWORD, "section");
				put(SCobol.LexicalUnit.SOURCE_COMPUTER_KEYWORD, "source\\-computer");
				put(SCobol.LexicalUnit.OBJECT_COMPUTER_KEYWORD, "object\\-computer");
				put(SCobol.LexicalUnit.DATA_KEYWORD, "data");
				put(SCobol.LexicalUnit.WORKING_STORAGE_KEYWORD, "working\\-storage");
				put(SCobol.LexicalUnit.PIC_KEYWORD, "pic");
				put(SCobol.LexicalUnit.VALUE_KEYWORD, "value");
				put(SCobol.LexicalUnit.PROCEDURE_KEYWORD, "procedure");
				put(SCobol.LexicalUnit.END_KEYWORD, "end");
				put(SCobol.LexicalUnit.PROGRAM_KEYWORD, "program");
				put(SCobol.LexicalUnit.STOP_KEYWORD, "stop");
				put(SCobol.LexicalUnit.RUN_KEYWORD, "run");
				put(SCobol.LexicalUnit.MOVE_KEYWORD, "move");
				put(SCobol.LexicalUnit.TO_KEYWORD, "to");
				put(SCobol.LexicalUnit.GIVING_KEYWORD, "giving");

				put(SCobol.LexicalUnit.COMPUTE_KEYWORD, "compute");
				put(SCobol.LexicalUnit.ADD_KEYWORD, "add");
				put(SCobol.LexicalUnit.SUBSTRACT_KEYWORD, "substract");
				put(SCobol.LexicalUnit.MULTIPLY_KEYWORD, "multiply");
				put(SCobol.LexicalUnit.DIVIDE_KEYWORD, "divide");
				put(SCobol.LexicalUnit.FROM_KEYWORD, "from");

				put(SCobol.LexicalUnit.NOT_KEYWORD, "not");
				put(SCobol.LexicalUnit.TRUE_KEYWORD, "true");
				put(SCobol.LexicalUnit.FALSE_KEYWORD, "false");
				put(SCobol.LexicalUnit.AND_KEYWORD, "and");
				put(SCobol.LexicalUnit.OR_KEYWORD, "or");

				put(SCobol.LexicalUnit.IF_KEYWORD, "if");
				put(SCobol.LexicalUnit.ELSE_KEYWORD, "else");
				put(SCobol.LexicalUnit.END_IF_KEYWORD, "end\\-if");
				put(SCobol.LexicalUnit.PERFORM_KEYWORD, "perform");
				put(SCobol.LexicalUnit.UNTIL_KEYWORD, "until");
				put(SCobol.LexicalUnit.ACCEPT_KEYWORD, "accept");
				put(SCobol.LexicalUnit.DISPLAY_KEYWORD, "display");

				put(SCobol.LexicalUnit.ASTERISK, "\\*");
				put(SCobol.LexicalUnit.SLASH, "/");
				put(SCobol.LexicalUnit.DOT, "\\.");
				put(SCobol.LexicalUnit.COMMA, ",");
				put(SCobol.LexicalUnit.LEFT_PARENTHESIS, "\\(");
				put(SCobol.LexicalUnit.RIGHT_PARENTHESIS, "\\)");
				put(SCobol.LexicalUnit.NEW_LINE, "\\n");

				put(SCobol.LexicalUnit.EQUALS_SIGN, "=");
				put(SCobol.LexicalUnit.LOWER_SIGN, "<");
				put(SCobol.LexicalUnit.LOWER_OR_EQUALS, "<=");
				put(SCobol.LexicalUnit.GREATER_SIGN, ">");
				put(SCobol.LexicalUnit.GREATER_OR_EQUALS, ">=");
				put(SCobol.LexicalUnit.MINUS_SIGN, "\\-");
				put(SCobol.LexicalUnit.PLUS_SIGN, "\\+");

				put(SCobol.LexicalUnit.IDENTIFIER, "[A-Za-z][0-9A-Za-z_\\-]{0,15}");
				put(SCobol.LexicalUnit.IMAGE, "s?9(?:\\([1-9][0-9]*\\))?(?:v9(?:\\([1-9][0-9]*\\))?)?");
				put(SCobol.LexicalUnit.INTEGER, "(?:\\+|-)?(?:[1-9][0-9]*)|(?:0)");
				put(SCobol.LexicalUnit.REAL, "(?:\\+|\\-)?(?:[1-9][0-9]*)|(?:0)(?:\\.[0-9]*[1-9])?");
				put(SCobol.LexicalUnit.STRING, "’[0-9A-Za-z\\+\\-\\*/:!\\? ]*’");

				put(SCobol.LexicalUnit.COMMENT, "(?:\\*|/).*\\.\\n");
			}
		};



		List<SCobol.LexicalUnit> units = Arrays.asList(SCobol.LexicalUnit.values());

		System.out.println(map);

		String regex = "";
		Iterator<SCobol.LexicalUnit> it = units.iterator();
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
			SCobol.LexicalUnit unit = null;
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