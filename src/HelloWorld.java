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
import cs.lang.LexicalAnalyzer;

public class HelloWorld{
	
	public static void main(String[] args) throws FileNotFoundException, IOException{

		List<SCobol.LexicalUnit> units = Arrays.asList(SCobol.LexicalUnit.values());

		System.out.println(SCobol.PATTERNS);

		String regex = "";
		Iterator<SCobol.LexicalUnit> it = units.iterator();
		if(it.hasNext()){
			regex += "(" + SCobol.PATTERNS.get(it.next()) + ")";
			while(it.hasNext()){
				regex += "|" + "(" + SCobol.PATTERNS.get(it.next()) + ")";
			}
		}

		System.out.println(units);
		System.out.println(regex);

		Pattern pattern = Pattern.compile(regex);


		File file = new File("test/1");
		InputStream fis = new FileInputStream(file);
		Scanner scanner = new Scanner(fis);

		LexicalAnalyzer analyzer = new LexicalAnalyzer();
		analyzer.run(scanner, units, pattern);

		fis.close();
	}
}