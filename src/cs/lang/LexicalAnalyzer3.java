package cs.lang;

import cs.lang.LexicalAnalyzer;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.lang.Character;

import java.io.IOException;

import cs.lang.LexicalToken;
import cs.lang.DFAState;

public class LexicalAnalyzer3<T, S> implements LexicalAnalyzer<T>{

	private InputStream stream;
	private Map<S, DFAState<S, T, Character>> state;
	private List<T> sep_l;

	private int cursor = 0;
	private int line = 1;
	private int col = 1;

	private S init;
	private S last;
	private S current;
	private String[] buffer = {"", ""};
	private LinkedList<Character> streamBuffer = new LinkedList<Character>();

	public LexicalAnalyzer3(InputStream stream, Map<S, DFAState<S, T, Character>> state, List<T> sep_l, S init){
		this.stream = stream;
		this.state = state;
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
				++cursor;
			}

			S next = state.get(current).next(c);
			if(next != null){
				current = next;
				if(state.get(next).token() == null){
					if(last != null) buffer[1] += c;
					else buffer[0] += c;
				}
				else{
					buffer[0] += buffer[1] + c;
					buffer[1] = "";
					last = next;
					col = cursor;
				}
			}
			else{


				if(last == null && state.get(current).token() != null){
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

				for(T sep : sep_l){
					if(state.get(last).token() == sep){
						++line;
						cursor = 1;
						break;
					}
				}

				LexicalToken<T> token = new LexicalToken<T>(state.get(last).token(), buffer[0]);
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