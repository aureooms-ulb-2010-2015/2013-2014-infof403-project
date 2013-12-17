package cs.parser.io;

import java.util.Set;
import java.util.HashSet;

public class Accept{

	private static Set<String> required = new HashSet<String>();

	private static String function(String type){
		return "define void @accept_" + type + "(" + type + "* %it) nounwind uwtable {\n"
		+ "  %1 = alloca " + type + "*, align 8\n"
		+ "  %c = alloca i32, align 4\n"
		+ "  store " + type + "* %it, " + type + "** %1, align 8\n"
		+ "  %2 = load " + type + "** %1, align 8\n"
		+ "  store " + type + " 0, " + type + "* %2, align 8\n"
		+ "  br label %3\n"
		+ "\n"
		+ "; <label>:3                                       ; preds = %0, %12\n"
		+ "  %4 = call i32 @getchar()\n"
		+ "  store i32 %4, i32* %c, align 4\n"
		+ "  %5 = load i32* %c, align 4\n"
		+ "  %6 = icmp slt i32 %5, 48\n"
		+ "  br i1 %6, label %7, label %8\n"
		+ "\n"
		+ "; <label>:7                                       ; preds = %3\n"
		+ "  br label %22\n"
		+ "\n"
		+ "; <label>:8                                       ; preds = %3\n"
		+ "  %9 = load i32* %c, align 4\n"
		+ "  %10 = icmp sgt i32 %9, 57\n"
		+ "  br i1 %10, label %11, label %12\n"
		+ "\n"
		+ "; <label>:11                                      ; preds = %8\n"
		+ "  br label %22\n"
		+ "\n"
		+ "; <label>:12                                      ; preds = %8\n"
		+ "  %13 = load " + type + "** %1, align 8\n"
		+ "  %14 = load " + type + "* %13, align 8\n"
		+ "  %15 = mul " + type + " %14, 10\n"
		+ "  store " + type + " %15, " + type + "* %13, align 8\n"
		+ "  %16 = load i32* %c, align 4\n"
		+ "  %17 = sub nsw i32 %16, 48\n"
		+ "  %18 = sext i32 %17 to " + type + "\n"
		+ "  %19 = load " + type + "** %1, align 8\n"
		+ "  %20 = load " + type + "* %19, align 8\n"
		+ "  %21 = add " + type + " %20, %18\n"
		+ "  store " + type + " %21, " + type + "* %19, align 8\n"
		+ "  br label %3\n"
		+ "\n"
		+ "; <label>:22                                      ; preds = %11, %7\n"
		+ "  ret void\n"
		+ "}";
	}

	public static void genLibCode(){
		for(String type : Accept.required){
			System.out.println(Accept.function(type)); 
		}

		if(!Accept.required.isEmpty()) System.out.println("declare i32 @getchar()");
	}

	private String type;
	private String variable;

	public Accept(String type, String variable){
		this.type = type;
		this.variable = variable;
		this.genCode();
  	}

	public void genCode(){
		Accept.required.add(this.type);
		System.out.printf("call void @accept_%s(%s* %s)\n", this.type, this.type, this.variable);
	}	
}