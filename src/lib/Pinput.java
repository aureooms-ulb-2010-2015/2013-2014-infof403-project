package lib;

import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.ArrayList;


public class Pinput {
	public static void parse (String[] args, List<String> params, Map<String, List<String>> options, Set<String> flags, Set<String> flagSet){
		
		String optionalParameterKey = "";
		Boolean isOptionalParameter = false;

		for(int n = 0; n < args.length; ++n){
			String p = args[n];
			if (p.charAt(0) == '-'){
				isOptionalParameter = false;
				if(p.length() > 1){
					if(p.charAt(1) == '-' || p.length() == 2){

						if(flagSet.contains(p)){
							flags.add(p);
						}
						else{
							options.put(p, new ArrayList<String>());
							optionalParameterKey = p;
							isOptionalParameter = true;
						}
					}
					else{
						for(int i = 1; i < p.length(); ++i){
							flags.add("" + '-' + p.charAt(i));
						}
					}
				}
			}
			else if(isOptionalParameter){
				options.get(optionalParameterKey).add(p);
			}
			else{
				params.add(p);
			}
		}
	}
}