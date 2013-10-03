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
import cs.lang.LexicalToken;

import lib.Pinput;

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
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		List<String> params = new ArrayList<String>();
		Map<String,List<String>> options = new HashMap<String,List<String>>();
		Set<String> flags = new HashSet<String>();
		Set<String> flagSet = new HashSet<String>();
		Pinput.parse(args, params, options, flags, flagSet);

		List<SCobol.LexicalUnit> units = Arrays.asList(SCobol.LexicalUnit.values());
		Iterator<SCobol.LexicalUnit> it = units.iterator();

		String regex = LexicalRegex.build(it, SCobol.PATTERNS);

		System.out.println(units);
		System.out.println(regex);

		Pattern pattern = Pattern.compile(regex);

		InputStream fis;
		if(params.size() > 0){
			File file = new File(params.get(0));
			fis = new FileInputStream(file);
		}
		else{
			fis = System.in;
		}
		Scanner scanner = new Scanner(fis);

		LexicalAnalyzer<SCobol.LexicalUnit> analyzer = new LexicalAnalyzer<SCobol.LexicalUnit>(scanner, units, pattern);

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
			else if(token.getId() == SCobol.LexicalUnit.BAD_TOKEN){
				System.out.printf("ERROR : BAD_TOKEN '%s' LINE %d COL %d]\n", token.getValue(), analyzer.getLine(), analyzer.getCol());
				break;
			}

			System.out.print("token : ");
			System.out.print(token.getValue().replace("\n","\\n"));
			System.out.print("\t");
			System.out.print("lexical unit : ");
			System.out.print(token.getId());
			System.out.print("\n");

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
					if(!variables.containsKey(label))
						labels.put(label, String.valueOf(analyzer.getLine()));
				}
				localState = LocalState.NONE;
			}
		}


		fis.close();

		System.out.println("variables");
		System.out.println(variables);
		System.out.println("labels");
		System.out.println(labels);
	}
}