package cs.parser.comp;

import cs.parser.variable.*;
import cs.parser.declaration.*;

public class Comp {

	public enum Op{
		GE,
		LE,
		GT,
		LT,
		EQ
	}

	protected IntegerVariable l;
	protected IntegerVariable r;
	protected Op op;
	protected String sop;

	protected String temp;

	public Comp (IntegerVariable l, IntegerVariable r, Op op, String temp){
		this.l = l;
		this.r = r;
		this.op = op;
		this.temp = temp;
		
		boolean signed = l.isSigned() || r.isSigned();

		switch(this.op){
			case GE:
				this.sop = signed ? "sge" : "uge";
				break;
			case LE:
				this.sop = signed ? "sle" : "ule";
				break;
			case GT:
				this.sop = signed ? "sgt" : "ugt";
				break;
			case LT:
				this.sop = signed ? "slt" : "ult";
				break;
			case EQ:
				this.sop = "eq";
				break;
		}

		this.genCode();
	}

	/*
	%2 = load i32* %a, align 4
  	%3 = load i32* %b, align 4
  	%4 = icmp slt i32 %2, %3
  	*/


	public void genCode(){
		String greater = (l.getSize() >= r.getSize() ) ? l.getType() :  r.getType();
		System.out.printf("%s = icmp %s %s %s, %s\n", this.temp, this.sop, greater, l.getName(), r.getName());
	}


}