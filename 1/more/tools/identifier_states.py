#!/usr/bin/python

import sys

def state(i):
	return \
"""\
package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFIER_"""+str(i)+""" extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IDENTIFIER_"""+str(i)+"""(){
		super(SCobol.LexicalUnit.IDENTIFIER);
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_"""+str(i+1)+""");
	}
}
"""

def laststate(i):
	return \
"""\
package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
import cs.lang.DFATools;

public class IDENTIFIER_"""+str(i)+""" extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public IDENTIFIER_"""+str(i)+"""(){
		super(SCobol.LexicalUnit.IDENTIFIER);
	}
}
"""

n = 0
if(len(sys.argv) > 1):
	n = int(sys.argv[1])

if n > 0:

	for i in range(n-1):

		text = state(i)
		fd = open('o/IDENTIFIER_'+str(i)+'.java', 'w')
		fd.write(text)
		fd.close()

	text = laststate(n-1)
	fd = open('o/IDENTIFIER_'+str(n-1)+'.java', 'w')
	fd.write(text)
	fd.close()