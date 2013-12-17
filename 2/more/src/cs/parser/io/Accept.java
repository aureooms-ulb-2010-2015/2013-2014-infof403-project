package cs.parser.io;

import java.util.Set;
import java.util.HashSet;

public class Accept{

	private static Set<String> required = new HashSet<String>();

	private static String function(String type){
		return "define void @accept_" + type + "(" + type + "* %it) nounwind uwtable {\n"
		+ "  %tmp_1 = alloca " + type + "*, align 8\n"
		+ "  %tmp_c = alloca i32, align 4\n"
		+ "  store " + type + "* %it, " + type + "** %tmp_1, align 8\n"
		+ "  %tmp_2 = load " + type + "** %tmp_1, align 8\n"
		+ "  store " + type + " 0, " + type + "* %tmp_2, align 8\n"
		+ "  br label %tmp_3\n"
		+ "\n"
		+ "tmp_3:                                       ; preds = %tmp_0, %tmp_12\n"
		+ "  %tmp_4 = call i32 @getchar()\n"
		+ "  store i32 %tmp_4, i32* %tmp_c, align 4\n"
		+ "  %tmp_5 = load i32* %tmp_c, align 4\n"
		+ "  %tmp_6 = icmp slt i32 %tmp_5, 48\n"
		+ "  br i1 %tmp_6, label %tmp_7, label %tmp_8\n"
		+ "\n"
		+ "tmp_7:                                       ; preds = %tmp_3\n"
		+ "  br label %tmp_22\n"
		+ "\n"
		+ "tmp_8:                                       ; preds = %tmp_3\n"
		+ "  %tmp_9 = load i32* %tmp_c, align 4\n"
		+ "  %tmp_10 = icmp sgt i32 %tmp_9, 57\n"
		+ "  br i1 %tmp_10, label %tmp_11, label %tmp_12\n"
		+ "\n"
		+ "tmp_11:                                      ; preds = %tmp_8\n"
		+ "  br label %tmp_22\n"
		+ "\n"
		+ "tmp_12:                                      ; preds = %tmp_8\n"
		+ "  %tmp_13 = load " + type + "** %tmp_1, align 8\n"
		+ "  %tmp_14 = load " + type + "* %tmp_13, align 8\n"
		+ "  %tmp_15 = mul " + type + " %tmp_14, 10\n"
		+ "  store " + type + " %tmp_15, " + type + "* %tmp_13, align 8\n"
		+ "  %tmp_16 = load i32* %tmp_c, align 4\n"
		+ "  %tmp_17 = sub nsw i32 %tmp_16, 48\n"
		+ (type.equals("i32") ? "" : "  %tmp_18 = sext i32 %tmp_17 to " + type + "\n")
		+ "  %tmp_19 = load " + type + "** %tmp_1, align 8\n"
		+ "  %tmp_20 = load " + type + "* %tmp_19, align 8\n"
		+ "  %tmp_21 = add " + type + " %tmp_20, " + (type.equals("i32") ? "%tmp_17" : "%tmp_18") + "\n"
		+ "  store " + type + " %tmp_21, " + type + "* %tmp_19, align 8\n"
		+ "  br label %tmp_3\n"
		+ "\n"
		+ "tmp_22:                                      ; preds = %tmp_11, %tmp_7\n"
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