package cs.parser.string;

import java.util.Map;
import java.util.HashMap;


public class StringPool{

	private static String VAR_NAME_PREFIX = "@.str";
	private static String FORMAT = StringPool.VAR_NAME_PREFIX + "%d = private unnamed_addr constant [%d x i8] c\"%s\\00\"\n";

	private Map<String, Integer> pool = new HashMap<String, Integer>();
	private int next = -1;

	public String get(String value){
		if(!this.pool.containsKey(value)){
			this.pool.put(value, ++next);
		}
		return StringPool.VAR_NAME_PREFIX + this.pool.get(value).toString();
	}

	public void genCode(){
		for(Map.Entry<String, Integer> entry : this.pool.entrySet()){
			byte[] bytes = entry.getKey().getBytes();
			String data = "";
			for(byte b : bytes){
				data += "\\" + String.format("%2X", b);
			}
			System.out.printf(FORMAT, entry.getValue(), bytes.length + 1, data);
		}
	}
}