
import sys
import subprocess

def state_text(current, transition, next, token, max_l):
	head = \
"""\
package cs.lang.scobol;

import cs.lang.SCobol;
import cs.lang.DFAState;

import cs.lang.Alphabet;
import cs.lang.DFATools;

public class """+current+""" extends DFAState<SCobol.DFAState, SCobol.LexicalUnit, Character>{
	public """+current+"""(){
		super("""+token+""");
"""
	body = ""

	for i in range(len(transition)):
		body += "\t\ttransition.put('"+transition[i]+"', SCobol.DFAState."+next[i]+");\n"

	foot = \
"""\
	}
}
"""

	if len(current) < max_l:
		foot = \
"""\
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER);
	}
}
"""
	return head + body + foot

print(sys.argv[1:])


states_m = {}
identifier_max_length = 16

for kw in sys.argv[1:]:
	for i in range(len(kw)):
		current = kw[:i+1].upper()
		states_m[current] = [[], [], "SCobol.LexicalUnit.IDENTIFIER"]
		if i >= identifier_max_length:
			states_m[current][2] = "null"

for kw in sys.argv[1:]:
	for i in range(len(kw)-1):
		current = kw[:i+1].upper()
		transition = kw[i+1]
		next = kw[:i+2].upper()
		states_m[current][0].append(transition)
		states_m[current][1].append(next)

	current = kw.upper()
	states_m[current][2] = "SCobol.LexicalUnit."+current


for state in states_m:

	states_m[state][0].sort()
	states_m[state][1].sort()
	text = state_text(state, states_m[state][0], states_m[state][1], states_m[state][2], identifier_max_length)
	fd = open('o/'+state+'.java', 'w')
	fd.write(text)
	fd.close()