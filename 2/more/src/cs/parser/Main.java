package cs.parser;

import cs.lexer.*;


public class Main{
	public static void main(String args[])throws Exception{
		Scanner cobolScanner = new Scanner(System.in);
		Compiler cobolCompiler = new Compiler(cobolScanner);
		cobolCompiler.compile();
	}
}
