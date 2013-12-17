package cs.parser.io;

import java.util.Map;
import java.util.HashMap;

import cs.parser.variable.*;

public class Display{

	private static Map<String, Integer> required = new HashMap<String, Integer>();

	private static String function_integer(String type, Integer size){
		return "define void @display_" + type + "(" + type + " %it) nounwind uwtable {\n"
		+ "  %tmp_1 = alloca " + type + ", align 8\n"
		+ "  %tmp_c = alloca i32, align 4\n"
		+ "  store " + type + " %it, " + type + "* %tmp_1, align 8\n"
		+ "  %tmp_2 = load " + type + "* %tmp_1, align 8\n"
		+ "  %tmp_3 = urem " + type + " %tmp_2, 10\n"
		+ "  %tmp_4 = add " + type + " 48, %tmp_3\n"
		+ (size == 32 ? "" : 
			(size > 32 ?
				"%tmp_5 = trunc " + type + " %tmp_4 to i32\n"
				: "%tmp_5 = zext " + type + " %tmp_4 to i32\n"
			)
		)
		+ "  store i32 " + (type.equals("i32") ? "%tmp_4" : "%tmp_5") + ", i32* %tmp_c, align 4\n"
		+ "  %tmp_6 = load " + type + "* %tmp_1, align 8\n"
		+ "  %tmp_7 = udiv " + type + " %tmp_6, 10\n"
		+ "  store " + type + " %tmp_7, " + type + "* %tmp_1, align 8\n"
		+ "  %tmp_8 = load " + type + "* %tmp_1, align 8\n"
		+ "  %tmp_9 = icmp ugt " + type + " %tmp_8, 0\n"
		+ "  br i1 %tmp_9, label %tmp_10, label %tmp_12\n"
		+ "\n"
		+ "tmp_10:                                      ; preds = %tmp_0\n"
		+ "  %tmp_11 = load " + type + "* %tmp_1, align 8\n"
		+ "  call void @display_" + type + "(" + type + " %tmp_11)\n"
		+ "  br label %tmp_12\n"
		+ "\n"
		+ "tmp_12:                                      ; preds = %tmp_10, %tmp_0\n"
		+ "  %tmp_13 = load i32* %tmp_c, align 4\n"
		+ "  %tmp_14 = call i32 @putchar(i32 %tmp_13)\n"
		+ "  ret void\n"
		+ "}";
	}

	private static String function_string(){
		return "define void @display_string(i8* %string) nounwind uwtable {\n"
		+ "  %1 = alloca i8*, align 8\n"
		+ "  store i8* %string, i8** %1, align 8\n"
		+ "  br label %2\n"
		+ "\n"
		+ "; <label>:2                                       ; preds = %7, %0\n"
		+ "  %3 = load i8** %1, align 8\n"
		+ "  %4 = load i8* %3, align 1\n"
		+ "  %5 = sext i8 %4 to i32\n"
		+ "  %6 = icmp ne i32 %5, 0\n"
		+ "  br i1 %6, label %7, label %14\n"
		+ "\n"
		+ "; <label>:7                                       ; preds = %2\n"
		+ "  %8 = load i8** %1, align 8\n"
		+ "  %9 = load i8* %8, align 1\n"
		+ "  %10 = sext i8 %9 to i32\n"
		+ "  %11 = call i32 @putchar(i32 %10)\n"
		+ "  %12 = load i8** %1, align 8\n"
		+ "  %13 = getelementptr inbounds i8* %12, i32 1\n"
		+ "  store i8* %13, i8** %1, align 8\n"
		+ "  br label %2\n"
		+ "\n"
		+ "; <label>:14                                      ; preds = %2\n"
		+ "  %15 = call i32 @putchar(i32 10)\n"
		+ "  ret void\n"
		+ "}";
	}

	public static void genLibCode(){
		for(Map.Entry<String, Integer> entry : required.entrySet()){
			if(entry.getKey().equals(StringVariable.TYPE)) System.out.println(Display.function_string());
			else System.out.println(Display.function_integer(entry.getKey(), entry.getValue()));
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
		else System.out.printf("call void @display_%s(%s %s)\n", this.variable.getType(), this.variable.getType(), this.variable.getName());
	}

}