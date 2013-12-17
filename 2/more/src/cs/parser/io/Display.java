package cs.parser.io;

import java.util.Set;
import java.util.HashSet;

import cs.parser.variable.*;

public class Display{

	private static Set<String> required = new HashSet<String>();

	private static String function_integer(String type){
		return "define void @display_" + type + "(" + type + " %it) nounwind uwtable {\n"
		+ "  %1 = alloca " + type + ", align 8\n"
		+ "  %c = alloca i32, align 4\n"
		+ "  store " + type + " %it, " + type + "* %1, align 8\n"
		+ "  %2 = load " + type + "* %1, align 8\n"
		+ "  %3 = urem " + type + " %2, 10\n"
		+ "  %4 = add " + type + " 48, %3\n"
		+ "  %5 = trunc " + type + " %4 to i32\n"
		+ "  store i32 %5, i32* %c, align 4\n"
		+ "  %6 = load " + type + "* %1, align 8\n"
		+ "  %7 = udiv " + type + " %6, 10\n"
		+ "  store " + type + " %7, " + type + "* %1, align 8\n"
		+ "  %8 = load " + type + "* %1, align 8\n"
		+ "  %9 = icmp ugt " + type + " %8, 0\n"
		+ "  br i1 %9, label %10, label %12\n"
		+ "\n"
		+ "; <label>:10                                      ; preds = %0\n"
		+ "  %11 = load " + type + "* %1, align 8\n"
		+ "  call void @display_" + type + "(" + type + " %11)\n"
		+ "  br label %12\n"
		+ "\n"
		+ "; <label>:12                                      ; preds = %10, %0\n"
		+ "  %13 = load i32* %c, align 4\n"
		+ "  %14 = call i32 @putchar(i32 %13)\n"
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
		+ "  ret void\n"
		+ "}";
	}

	public static void genLibCode(){
		for(String type : required){
			if(type.equals(StringVariable.TYPE)) System.out.println(Display.function_string());
			else System.out.println(Display.function_integer(type));
		}

		if(!Display.required.isEmpty()) System.out.println("declare i32 @putchar()");
	}

	private Variable variable;

	public Display(Variable variable){
		this.variable = variable;
		this.genCode();
	}
	
	public void genCode(){
		Display.required.add(this.variable.getType());
		if(this.variable.getType().equals(StringVariable.TYPE)) System.out.printf("call void @display_string(i8* getelementptr inbounds ([%d x i8]* %s, i32 0, i32 0))\n", this.variable.getSize(), this.variable.getName());
		else System.out.printf("call void @display_%s(%s %s)\n", this.variable.getType(), this.variable.getType(), this.variable.getName());
	}

}