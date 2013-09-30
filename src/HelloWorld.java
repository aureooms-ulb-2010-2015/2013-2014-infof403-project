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
import cs.lang.LexicalRegex;
import cs.lang.LexicalAnalyzer;
import cs.lang.LexicalToken;

public class HelloWorld{
	
	public static void main(String[] args) throws FileNotFoundException, IOException{

		List<SCobol.LexicalUnit> units = Arrays.asList(SCobol.LexicalUnit.values());
		Iterator<SCobol.LexicalUnit> it = units.iterator();

		String regex = LexicalRegex.build(it, SCobol.PATTERNS);

		System.out.println(units);
		System.out.println(regex);

		Pattern pattern = Pattern.compile(regex);


		File file = new File("test/1");
		InputStream fis = new FileInputStream(file);
		Scanner scanner = new Scanner(fis);

		LexicalAnalyzer<SCobol.LexicalUnit> analyzer = new LexicalAnalyzer<SCobol.LexicalUnit>(scanner, units, pattern);

		while(true){
			LexicalToken<SCobol.LexicalUnit> token = analyzer.nextToken();
			if(token == null) break;
			System.out.print("token : ");
			System.out.print(token.getValue());
			System.out.print("\t");
			System.out.print("lexical unit : ");
			System.out.print(token.getId());
			System.out.print("\n");
		}


		fis.close();
	}
}