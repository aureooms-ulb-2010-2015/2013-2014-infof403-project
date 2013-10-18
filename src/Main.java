import java.util.List;
import java.util.ArrayList;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.io.IOException;
import java.io.FileNotFoundException;

import cs.lang.SCobol;
import cs.lang.LexicalRegex;
import cs.lang.LexicalAnalyzer;
import cs.lang.LexicalToken;

import cs.lang.LexicalAnalyzerFactory;
import cs.lang.SCobolLexicalAnalyzerFactory;

import cs.lang.SCobolParser;

import lib.Pinput;

/**
 * 'Main' class.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */


public class Main{
	
	public static void main(String[] args){

		try{

			List<String> params = new ArrayList<String>();
			Map<String,List<String>> options = new HashMap<String,List<String>>();
			Set<String> flags = new HashSet<String>();
			Set<String> flagSet = new HashSet<String>();
			Pinput.parse(args, params, options, flags, flagSet);


			InputStream stream;
			if(params.size() > 0){
				File file = new File(params.get(0));
				stream = new FileInputStream(file);
			}
			else{
				stream = System.in;
			}

			String mode = null;
			if(options.containsKey("--mode") && !options.get("--mode").isEmpty()){
				mode = options.get("--mode").get(0);
			}

			LexicalAnalyzerFactory<SCobol.LexicalUnit> factory = new SCobolLexicalAnalyzerFactory();
			LexicalAnalyzer<SCobol.LexicalUnit> analyzer = factory.get(mode, stream);

			if(analyzer == null) throw new Exception("--mode : " + mode + ", no such mode [regex|map|class]");


			SCobolParser parser = new SCobolParser();
			Map<String, String> variables = new TreeMap<String, String>();
			Map<String, String> labels = new TreeMap<String, String>();

			while(true){
				LexicalToken<SCobol.LexicalUnit> token = analyzer.nextToken();
				if(token == null) break;
				else if(token.getId() == SCobol.LexicalUnit.WHITE_SPACE) continue;
				else if(token.getId() == SCobol.LexicalUnit.BAD_TOKEN || token.getId() == null){
					System.out.printf("ERROR : BAD_TOKEN '%s' LINE %d COL %d\n", token.getValue(), analyzer.getLine(), analyzer.getCol());
					break;
				}
				else{
					String token_repr = token.getValue().replace("\n","\\n").replace("\t","\\t");
					System.out.printf("token : %-42s    lexical unit : %-15s\n", token_repr, token.getId());
					parser.feed(token, variables, labels, analyzer.getLine());
				}
			}

			stream.close();

			System.out.println("variables");
			for (Map.Entry<String, String> entry : variables.entrySet()){
				System.out.printf("%-20s    %-15s\n", entry.getKey(), entry.getValue());
			}
			System.out.println("labels");
			for (Map.Entry<String, String> entry : labels.entrySet()){
				System.out.printf("%-20s    %-15s\n", entry.getKey(), entry.getValue());
			}

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}