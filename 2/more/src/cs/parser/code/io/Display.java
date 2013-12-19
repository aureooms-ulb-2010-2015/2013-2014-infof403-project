package cs.parser.code.io;

import java.util.*;
import cs.parser.data.variable.*;

public class Display{

	private static Map<String, Integer> required = new HashMap<String, Integer>();

	private static void function_signed(String type, Integer size){
		System.out.println("define void @display_s" + type + "(" + type + " %it) nounwind {");
		System.out.println("  %1 = alloca " + type + ", align 4");
		System.out.println("  store " + type + " %it, " + type + "* %1, align 8");
		System.out.println("  %2 = load " + type + "* %1, align 8");
		System.out.println("  %3 = icmp slt " + type + " %2, 0");
		System.out.println("  br i1 %3, label %4, label %8");
		System.out.println("");
		System.out.println("; <label>:4                                       ; preds = %0");
		System.out.println("  %5 = call i32 @putchar(i32 45)");
		System.out.println("  %6 = load " + type + "* %1, align 8");
		System.out.println("  %7 = sub nsw " + type + " 0, %6");
		System.out.println("  store " + type + " %7, " + type + "* %1, align 8");
		System.out.println("  br label %8");
		System.out.println("");
		System.out.println("; <label>:8                                       ; preds = %4, %0");
		System.out.println("  %9 = load " + type + "* %1, align 8");
		System.out.println("  call void @display_" + type + "(" + type + " %9)");
		System.out.println("  ret void");
		System.out.println("}");
	}

	private static void function_unsigned(String type, Integer size){
		System.out.println("define void @display_" + type + "(" + type + " %it) nounwind {");
		System.out.println("  %tmp_1 = alloca " + type + ", align 8");
		System.out.println("  %tmp_c = alloca i32, align 4");
		System.out.println("  store " + type + " %it, " + type + "* %tmp_1, align 8");
		System.out.println("  %tmp_2 = load " + type + "* %tmp_1, align 8");
		System.out.println("  %tmp_3 = urem " + type + " %tmp_2, 10");
		System.out.println("  %tmp_4 = add " + type + " 48, %tmp_3");
		if(size > 32) System.out.println("%tmp_5 = trunc " + type + " %tmp_4 to i32");
		else if(size < 32) System.out.println("%tmp_5 = zext " + type + " %tmp_4 to i32");
		System.out.println("  store i32 " + (size == 32 ? "%tmp_4" : "%tmp_5") + ", i32* %tmp_c, align 4");
		System.out.println("  %tmp_6 = load " + type + "* %tmp_1, align 8");
		System.out.println("  %tmp_7 = udiv " + type + " %tmp_6, 10");
		System.out.println("  store " + type + " %tmp_7, " + type + "* %tmp_1, align 8");
		System.out.println("  %tmp_8 = load " + type + "* %tmp_1, align 8");
		System.out.println("  %tmp_9 = icmp ugt " + type + " %tmp_8, 0");
		System.out.println("  br i1 %tmp_9, label %tmp_10, label %tmp_12");
		System.out.println("");
		System.out.println("tmp_10:                                      ; preds = %tmp_0");
		System.out.println("  %tmp_11 = load " + type + "* %tmp_1, align 8");
		System.out.println("  call void @display_" + type + "(" + type + " %tmp_11)");
		System.out.println("  br label %tmp_12");
		System.out.println("");
		System.out.println("tmp_12:                                      ; preds = %tmp_10, %tmp_0");
		System.out.println("  %tmp_13 = load i32* %tmp_c, align 4");
		System.out.println("  %tmp_14 = call i32 @putchar(i32 %tmp_13)");
		System.out.println("  ret void");
		System.out.println("}");
	}

	private static void function_string(){
		System.out.println("define void @display_string(i8* %string) nounwind {");
		System.out.println("  %1 = alloca i8*, align 8");
		System.out.println("  store i8* %string, i8** %1, align 8");
		System.out.println("  br label %2");
		System.out.println("");
		System.out.println("; <label>:2                                       ; preds = %7, %0");
		System.out.println("  %3 = load i8** %1, align 8");
		System.out.println("  %4 = load i8* %3, align 1");
		System.out.println("  %5 = sext i8 %4 to i32");
		System.out.println("  %6 = icmp ne i32 %5, 0");
		System.out.println("  br i1 %6, label %7, label %14");
		System.out.println("");
		System.out.println("; <label>:7                                       ; preds = %2");
		System.out.println("  %8 = load i8** %1, align 8");
		System.out.println("  %9 = load i8* %8, align 1");
		System.out.println("  %10 = sext i8 %9 to i32");
		System.out.println("  %11 = call i32 @putchar(i32 %10)");
		System.out.println("  %12 = load i8** %1, align 8");
		System.out.println("  %13 = getelementptr inbounds i8* %12, i32 1");
		System.out.println("  store i8* %13, i8** %1, align 8");
		System.out.println("  br label %2");
		System.out.println("");
		System.out.println("; <label>:14                                      ; preds = %2");
		System.out.println("  %15 = call i32 @putchar(i32 10)");
		System.out.println("  ret void");
		System.out.println("}");
	}

	public static void genLibCode(){
		for(Map.Entry<String, Integer> entry : required.entrySet()){
			if(entry.getKey().equals(StringVariable.TYPE)) Display.function_string();
			else{
				Display.function_signed(entry.getKey(), entry.getValue());
				Display.function_unsigned(entry.getKey(), entry.getValue());
			}
		}

		if(!Display.required.isEmpty()) System.out.println("declare i32 @putchar(i32)");
	}

	private Variable variable;

	public Display(Variable variable){
		this.variable = variable;
		this.genCode();
	}
	
	public void genCode(){
		Display.required.put(this.variable.getType(), this.variable.getSize());
		if(this.variable.getType().equals(StringVariable.TYPE)) System.out.printf("call void @display_string(i8* getelementptr inbounds ([%d x i8]* %s, i32 0, i32 0))\n", this.variable.getSize(), this.variable.getName());
		else if(((IntegerVariable) this.variable).isSigned()) System.out.printf("call void @display_s%s(%s %s)\n", this.variable.getType(), this.variable.getType(), this.variable.getName());
		else System.out.printf("call void @display_%s(%s %s)\n", this.variable.getType(), this.variable.getType(), this.variable.getName());
	}

}