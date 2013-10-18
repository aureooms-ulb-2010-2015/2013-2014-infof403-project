import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

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
import cs.lang.LexicalAnalyzer1;
import cs.lang.LexicalAnalyzer2;
import cs.lang.LexicalAnalyzer3;
import cs.lang.LexicalToken;

import lib.Pinput;

/**
 * 'Main' class.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */


public class Main{

	public enum LocalState{
		NONE,
		IDENTIFIER,
		PROCEDURE,
		DATA
	}

	public enum State{
		HEADER,
		VARIABLES,
		LABELS
	}
	
	public static void main(String[] args){

		try{

			List<String> params = new ArrayList<String>();
			Map<String,List<String>> options = new HashMap<String,List<String>>();
			Set<String> flags = new HashSet<String>();
			Set<String> flagSet = new HashSet<String>();
			Pinput.parse(args, params, options, flags, flagSet);

			List<SCobol.LexicalUnit> units = Arrays.asList(SCobol.LexicalUnit.values());
			Iterator<SCobol.LexicalUnit> it = units.iterator();

			String regex = LexicalRegex.build(it, SCobol.PATTERNS);

			Pattern pattern = Pattern.compile(regex);

			InputStream stream;
			if(params.size() > 0){
				File file = new File(params.get(0));
				stream = new FileInputStream(file);
			}
			else{
				stream = System.in;
			}

			LexicalAnalyzer<SCobol.LexicalUnit> analyzer;

			String mode = null;
			if(options.containsKey("--mode") && !options.get("--mode").isEmpty()){
				mode = options.get("--mode").get(0);
			}

			if(mode != null){
				if(mode.equals("regex")){
					Scanner scanner = new Scanner(stream);
					analyzer = new LexicalAnalyzer2<SCobol.LexicalUnit>(scanner, units, pattern, SCobol.SEP_L);
				}
				else if(mode.equals("map")){
					analyzer = new LexicalAnalyzer1<SCobol.LexicalUnit, SCobol.DFAState>(stream, SCobol.TRANSITION, SCobol.TOKEN_M, SCobol.SEP_L, SCobol.DFAState.INIT);
				}
				else if(mode.equals("class")){
					analyzer = new LexicalAnalyzer3<SCobol.LexicalUnit, SCobol.DFAState>(stream, SCobol.STATE, SCobol.SEP_L, SCobol.DFAState.INIT);
				}
				else{
					throw new Exception("--mode : " + mode + ", no such mode [regex|map|class]");
				}
			}
			else{
				analyzer = new LexicalAnalyzer3<SCobol.LexicalUnit, SCobol.DFAState>(stream, SCobol.STATE, SCobol.SEP_L, SCobol.DFAState.INIT);
			}

			Map<String, String> variables = new TreeMap<String, String>();
			Map<String, String> labels = new TreeMap<String, String>();

			State state = State.HEADER;
			LocalState localState = LocalState.NONE;
			String variable = "";
			String label = "";

			while(true){
				LexicalToken<SCobol.LexicalUnit> token = analyzer.nextToken();
				if(token == null) break;
				else if(token.getId() == SCobol.LexicalUnit.WHITE_SPACE) continue;
				else if(token.getId() == SCobol.LexicalUnit.BAD_TOKEN || token.getId() == null){
					System.out.printf("ERROR : BAD_TOKEN '%s' LINE %d COL %d\n", token.getValue(), analyzer.getLine(), analyzer.getCol());
					break;
				}

				System.out.printf("token : %-42s    lexical unit : %-15s\n",token.getValue().replace("\n","\\n").replace("\t","\\t"), token.getId());

				if(token.getValue().equals("data")){
					localState = LocalState.DATA;
					continue;
				}
				else if(token.getValue().equals("procedure")){
					localState = LocalState.PROCEDURE;
					continue;
				}
				else if(state == State.VARIABLES && token.getId() == SCobol.LexicalUnit.IDENTIFIER){
					localState = LocalState.IDENTIFIER;
					variable = token.getValue();
					continue;
				}
				else if(state == State.LABELS && token.getId() == SCobol.LexicalUnit.IDENTIFIER){
					localState = LocalState.IDENTIFIER;
					label = token.getValue();
					continue;
				}

				if(localState == LocalState.DATA && token.getValue().equals("division")){
					state = State.VARIABLES;
				}
				else if(localState == LocalState.PROCEDURE && token.getValue().equals("division")){
					state = State.LABELS;
				}

				if(state == State.VARIABLES && localState == LocalState.IDENTIFIER){
					if(token.getId() == SCobol.LexicalUnit.IMAGE)
						variables.put(variable, token.getValue());
					localState = LocalState.NONE;
				}

				if(state == State.LABELS && localState == LocalState.IDENTIFIER){
					if(token.getId() != SCobol.LexicalUnit.SECTION_KEYWORD){
						if(!variables.containsKey(label) && !labels.containsKey(label))
							labels.put(label, String.valueOf(analyzer.getLine()));
					}
					localState = LocalState.NONE;
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