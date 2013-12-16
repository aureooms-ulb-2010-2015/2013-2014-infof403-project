package cs.parser;

import cs.lexer.*;


public class Main{
	public static void main(String args[])throws Exception{
		Scanner cobolScanner = new Scanner(System.in);
		Parser cobolParser = new Parser(cobolScanner);
		try{
			cobolParser.compile();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
