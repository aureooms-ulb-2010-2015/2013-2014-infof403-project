package cs.parser.utils;

import cs.parser.data.declaration.*;


/**
 *
 * Utility tool for image parsing.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Image{

	public static VariableDecl parse(String image){
		int imSize = 0;
		boolean signed = false;
		boolean floating = false;
		String nines = "";

		boolean inside = false;

		int i = 0;

		if(image.charAt(i) == 's'){
			++i;
			signed = true;
		}

		++i;
		if(i < image.length() && image.charAt(i) == '('){
			for(++i; i < image.length(); ++i){	
				if(image.charAt(i) == ')'){
					imSize += Integer.decode(nines);
					nines = "";
					break;
				}
				else nines += image.charAt(i);
			}
		}
		else ++imSize;


		++i;
		if(i < image.length()){
			floating = true;
			++i;
			if(i < image.length() && image.charAt(i) == '('){
				for(++i; i < image.length(); ++i){	
					if(image.charAt(i) == ')'){
						imSize += Integer.decode(nines);
						nines = "";
						break;
					}
					else nines += image.charAt(i);
				}
			}
			else ++imSize;
		}

		int imageBitSize = (int) Math.ceil( ( Math.log(Math.pow(10,imSize)) / Math.log(2) + (signed ? 1 : 0)) / 8);

		if(floating) return new RealDecl(Integer.toString(8 * imageBitSize), signed);
		else return new IntegerDecl(Integer.toString(8 * imageBitSize), signed);
	}
}