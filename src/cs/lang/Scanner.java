package cs.lang;

import cs.lang.LexicalAnalyzer;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.lang.Character;

import java.io.IOException;

import cs.lang.LexicalToken;

public class Scanner<T, S> implements LexicalAnalyzer<T>{

	private InputStream stream;
	private Map<S, Map<Character, S>> transition;
	private Map<S, T> token_m;
	private List<T> sep_l;

	private int total = 0;
	private int line = 1;
	private int col = 1;

	private S last;
	private S current;
	private String[] buffer = new String[2];
	private LinkedList<Character> streamBuffer;

	public Scanner(InputStream stream, Map<S, Map<Character, S>> transition, Map<S, T> token_m, List<T> sep_l){
		this.stream = stream;
		this.transition = transition;
		this.token_m = token_m;
		this.sep_l = sep_l;
	}

	public LexicalToken<T> nextToken() throws IOException{
		T unit = null;
		String match = "";
		Character c;
		while(true){
			c = streamBuffer.poll();
			if(c == null) c = (char)stream.read();
			if(c == -1) return null;

			S next = transition.get(last).get(c);
			if(next != null){
				current = next;
				if(token_m.get(next) == null){
					buffer[1] += c;
				}
				else{
					buffer[0] += buffer[1] + c;
					buffer[1] = "";
					last = next;
				}
			}
			else{
				LexicalToken<T> token = new LexicalToken<T>(token_m.get(last), buffer[0]);
				for(int i = 0; i < buffer[1].length(); ++i){
					streamBuffer.push(buffer[1].charAt(i));
				}
				buffer[0] = buffer[1] = "";
				current = last;
				return token;
			}
		}
	}

	public int getLine(){
		return line;
	}

	public int getCol(){
		return col;
	}
}