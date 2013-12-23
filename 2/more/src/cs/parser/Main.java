package cs.parser;

import cs.lexer.*;


/**
 * Simple Main for the SCOBOL Parser.
 *
 * Input is read from stdin.
 * Output is written on stdout.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Main{
	public static void main(String args[])throws Exception{
		Scanner scanner = new Scanner(System.in);
		SemanticalAnalyzer semanticalAnalyzer = new SemanticalAnalyzer();
		Parser parser = new Parser(scanner, semanticalAnalyzer);
		try{
			parser.compile();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
}
