package cs.parser.code.io;

import java.util.*;
import cs.parser.data.variable.*;


/**
 *
 * Code generator for accept calls.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class Accept{

	private static Map<String, Integer> required = new HashMap<String, Integer>();

	private static void function_signed(String type, Integer size){
		System.out.println("define void @accept_s" + type + "(" + type + "* %it) nounwind {");
		System.out.println("  %tmp_1 = alloca " + type + "*, align 4");
		System.out.println("  %tmp_c = alloca i32, align 4");
		System.out.println("  %tmp_neg = alloca i8, align 1");
		System.out.println("  store " + type + "* %it, " + type + "** %tmp_1, align 4");
		System.out.println("  %tmp_2 = load " + type + "** %tmp_1, align 4");
		System.out.println("  store " + type + " 0, " + type + "* %tmp_2");
		System.out.println("  store i8 0, i8* %tmp_neg, align 1");
		System.out.println("  %tmp_3 = call i32 @getchar()");
		System.out.println("  store i32 %tmp_3, i32* %tmp_c, align 4");
		System.out.println("  %tmp_4 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_5 = icmp eq i32 %tmp_4, 45");
		System.out.println("  br i1 %tmp_5, label %tmp_6, label %tmp_8");
		System.out.println("");
		System.out.println("tmp_6:                                      ; preds = %tmp_0");
		System.out.println("  store i8 1, i8* %tmp_neg, align 1");
		System.out.println("  %tmp_7 = call i32 @getchar()");
		System.out.println("  store i32 %tmp_7, i32* %tmp_c, align 4");
		System.out.println("  br label %tmp_8");
		System.out.println("");
		System.out.println("tmp_8:                                      ; preds = %tmp_6, %tmp_0");
		System.out.println("  br label %tmp_9");
		System.out.println("");
		System.out.println("tmp_9:                                      ; preds = %tmp_8, %tmp_17");
		System.out.println("  %tmp_10 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_11 = icmp slt i32 %tmp_10, 48");
		System.out.println("  br i1 %tmp_11, label %tmp_12, label %tmp_13");
		System.out.println("");
		System.out.println("tmp_12:                                      ; preds = %tmp_9");
		System.out.println("  br label %tmp_28");
		System.out.println("");
		System.out.println("tmp_13:                                      ; preds = %tmp_9");
		System.out.println("  %tmp_14 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_15 = icmp sgt i32 %tmp_14, 57");
		System.out.println("  br i1 %tmp_15, label %tmp_16, label %tmp_17");
		System.out.println("");
		System.out.println("tmp_16:                                      ; preds = %tmp_13");
		System.out.println("  br label %tmp_28");
		System.out.println("");
		System.out.println("tmp_17:                                      ; preds = %tmp_13");
		System.out.println("  %tmp_18 = load " + type + "** %tmp_1, align 4");
		System.out.println("  %tmp_19 = load " + type + "* %tmp_18");
		System.out.println("  %tmp_20 = mul nsw " + type + " %tmp_19, 10");
		System.out.println("  store " + type + " %tmp_20, " + type + "* %tmp_18");
		System.out.println("  %tmp_21 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_22 = sub nsw i32 %tmp_21, 48");
		if(size > 32)		System.out.println("  %tmp_23 = sext i32 %tmp_22 to " + type);
		else if(size < 32)	System.out.println("  %tmp_23 = trunc i32 %tmp_22 to " + type);
		System.out.println("  %tmp_24 = load " + type + "** %tmp_1, align 4");
		System.out.println("  %tmp_25 = load " + type + "* %tmp_24");
		System.out.println("  %tmp_26 = add nsw " + type + " %tmp_25, " + (size == 32 ? "%tmp_22" : "%tmp_23"));
		System.out.println("  store " + type + " %tmp_26, " + type + "* %tmp_24");
		System.out.println("  %tmp_27 = call i32 @getchar()");
		System.out.println("  store i32 %tmp_27, i32* %tmp_c, align 4");
		System.out.println("  br label %tmp_9");
		System.out.println("");
		System.out.println("tmp_28:                                      ; preds = %tmp_16, %tmp_12");
		System.out.println("  %tmp_29 = load i8* %tmp_neg, align 1");
		System.out.println("  %tmp_30 = icmp ne i8 %tmp_29, 0");
		System.out.println("  br i1 %tmp_30, label %tmp_31, label %tmp_36");
		System.out.println("");
		System.out.println("tmp_31:                                      ; preds = %tmp_28");
		System.out.println("  %tmp_32 = load " + type + "** %tmp_1, align 4");
		System.out.println("  %tmp_33 = load " + type + "* %tmp_32");
		System.out.println("  %tmp_34 = sub nsw " + type + " 0, %tmp_33");
		System.out.println("  %tmp_35 = load " + type + "** %tmp_1, align 4");
		System.out.println("  store " + type + " %tmp_34, " + type + "* %tmp_35");
		System.out.println("  br label %tmp_36");
		System.out.println("");
		System.out.println("tmp_36:                                      ; preds = %tmp_31, %tmp_28");
		System.out.println("  ret void");
		System.out.println("}");
		System.out.println("");
	}

	private static void function_unsigned(String type, Integer size){
		System.out.println("define void @accept_" + type + "(" + type + "* %it) nounwind {");
		System.out.println("  %tmp_1 = alloca " + type + "*, align 8");
		System.out.println("  %tmp_c = alloca i32, align 4");
		System.out.println("  store " + type + "* %it, " + type + "** %tmp_1, align 8");
		System.out.println("  %tmp_2 = load " + type + "** %tmp_1, align 8");
		System.out.println("  store " + type + " 0, " + type + "* %tmp_2, align 8");
		System.out.println("  br label %tmp_3");
		System.out.println("");
		System.out.println("tmp_3:                                       ; preds = %tmp_0, %tmp_12");
		System.out.println("  %tmp_4 = call i32 @getchar()");
		System.out.println("  store i32 %tmp_4, i32* %tmp_c, align 4");
		System.out.println("  %tmp_5 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_6 = icmp slt i32 %tmp_5, 48");
		System.out.println("  br i1 %tmp_6, label %tmp_7, label %tmp_8");
		System.out.println("");
		System.out.println("tmp_7:                                       ; preds = %tmp_3");
		System.out.println("  br label %tmp_22");
		System.out.println("");
		System.out.println("tmp_8:                                       ; preds = %tmp_3");
		System.out.println("  %tmp_9 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_10 = icmp sgt i32 %tmp_9, 57");
		System.out.println("  br i1 %tmp_10, label %tmp_11, label %tmp_12");
		System.out.println("");
		System.out.println("tmp_11:                                      ; preds = %tmp_8");
		System.out.println("  br label %tmp_22");
		System.out.println("");
		System.out.println("tmp_12:                                      ; preds = %tmp_8");
		System.out.println("  %tmp_13 = load " + type + "** %tmp_1, align 8");
		System.out.println("  %tmp_14 = load " + type + "* %tmp_13, align 8");
		System.out.println("  %tmp_15 = mul " + type + " %tmp_14, 10");
		System.out.println("  store " + type + " %tmp_15, " + type + "* %tmp_13, align 8");
		System.out.println("  %tmp_16 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_17 = sub nsw i32 %tmp_16, 48");
		if(size > 32) System.out.println("  %tmp_18 = zext i32 %tmp_17 to " + type);
		else if(size < 32) System.out.println("  %tmp_18 = trunc i32 %tmp_17 to " + type);
		System.out.println("  %tmp_19 = load " + type + "** %tmp_1, align 8");
		System.out.println("  %tmp_20 = load " + type + "* %tmp_19, align 8");
		System.out.println("  %tmp_21 = add " + type + " %tmp_20, " + (size == 32 ? "%tmp_17" : "%tmp_18"));
		System.out.println("  store " + type + " %tmp_21, " + type + "* %tmp_19, align 8");
		System.out.println("  br label %tmp_3");
		System.out.println("");
		System.out.println("tmp_22:                                      ; preds = %tmp_11, %tmp_7");
		System.out.println("  ret void");
		System.out.println("}");
	}

	public static void genLibCode(){
		for(Map.Entry<String, Integer> entry : required.entrySet()){
			Accept.function_signed(entry.getKey(), entry.getValue());
			Accept.function_unsigned(entry.getKey(), entry.getValue());
		}

		if(!Accept.required.isEmpty()) System.out.println("declare i32 @getchar()");
	}

	private Variable variable;

	public Accept(Variable variable){
		this.variable = variable;
		this.genCode();
  	}

	public void genCode(){
		Accept.required.put(this.variable.getType(), this.variable.getSize());
		if(((IntegerVariable) this.variable).isSigned()) System.out.printf("call void @accept_s%s(%s* %s)\n", this.variable.getType(), this.variable.getType(), this.variable.getName());
		else System.out.printf("call void @accept_%s(%s* %s)\n", this.variable.getType(), this.variable.getType(), this.variable.getName());
	}	
}