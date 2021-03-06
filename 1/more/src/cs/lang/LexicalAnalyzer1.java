package cs.lang;

import cs.lang.LexicalAnalyzer;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.lang.Character;

import java.io.IOException;

import cs.lang.LexicalToken;

/**
 * Implementation of LexicalAnalyzer using Maps.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 */

public class LexicalAnalyzer1<T, S> implements LexicalAnalyzer<T>{

	private InputStream stream;
	private Map<S, Map<Character, S>> transition;
	private Map<S, T> token_m;
	private List<T> sep_l;

	private int total = 0;
	private int line = 1;
	private int col = 1;

	private S init;
	private S last;
	private S current;
	private String[] buffer = {"", ""};
	private LinkedList<Character> streamBuffer = new LinkedList<Character>();

	public LexicalAnalyzer1(InputStream stream, Map<S, Map<Character, S>> transition, Map<S, T> token_m, List<T> sep_l, S init){
		this.stream = stream;
		this.transition = transition;
		this.token_m = token_m;
		this.sep_l = sep_l;
		this.init = init;
	}

	public LexicalToken<T> nextToken() throws IOException{
		last = null;
		current = init;
		Character c;
		int d = -1;
		while(true){
			c = streamBuffer.poll();
			if(c == null){
				d = stream.read();
				if(d == -1) return null;
				c = (char)d;
			}

			S next = transition.get(current).get(c);
			if(next != null){
				current = next;
				if(token_m.get(next) == null){
					if(last != null) buffer[1] += c;
					else buffer[0] += c;
				}
				else{
					buffer[0] += buffer[1] + c;
					buffer[1] = "";
					last = next;
				}
			}
			else{

				if(last == null && token_m.get(current) != null){
					last = current;
				}

				if(last != null){
					for(int i = 0; i < buffer[1].length(); ++i){
						streamBuffer.push(buffer[1].charAt(i));
					}
					streamBuffer.push(c);
				}
				else{
					buffer[0] += c;
					last = current;
				}
				LexicalToken<T> token = new LexicalToken<T>(token_m.get(last), buffer[0]);
				buffer[0] = buffer[1] = "";
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