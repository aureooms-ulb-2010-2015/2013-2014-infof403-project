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

	protected String temp1;
	protected String temp2;
	protected String temp3;

	public Comp (IntegerVariable l, IntegerVariable r, Op op, String temp1, String temp2, String temp3){
		this.l = l;
		this.r = r;
		this.op = op;

		this.temp1 = temp1;
		this.temp2 = temp2;
		this.temp3 = temp3;
		

		boolean signed = false;

		if(l.signed || r.signed){signed = true;}

		switch(this.op){
			case GE:
				if(signed){
					this.sop = "sge";
				} 
				else{
					this.sop = "uge";
				}
				break;
			case LE:
				if(signed){
					this.sop = "sle";
				}
				else{
					this.sop = "ule";
				} 
				break;
			case GT:
				if(signed){
					this.sop = "sgt";
				}
				else{
					this.sop = "ugt";
				} 
				break;
			case LT:
				if(signed){
					this.sop = "slt";
				}
				else{
					this.sop = "ult";
				} 
				break;
			case EQ:
				this.sop = "eq";
				break;
		}
	}

	/*
	%2 = load i32* %a, align 4
  	%3 = load i32* %b, align 4
  	%4 = icmp slt i32 %2, %3
  	*/


	public void genCode(){

		String greater = (l.getSize() >= r.getSize() ) ? l.getType() :  r.getType();

		System.out.printf("%s = load %s* %s\n", this.temp1, l.getType(), l.getName());
		System.out.printf("%s = load %s* %s\n", this.temp2, r.getType(), r.getName());
		System.out.printf("%s = icmp %s %s %s, %s\n", this.temp3, this.sop, greater, this.temp1, this.temp2);
		
	}


}