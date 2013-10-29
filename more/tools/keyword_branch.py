#!/usr/bin/python

import fileinput

def state_text(current, transition, next, token, max_l):
	head = \
"""\
package cs.lang.scobol.dfa;

import cs.lang.scobol.Language;
import cs.lang.DFAState;

import cs.lang.scobol.Alphabet;
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
		DFATools.fill(transition, Alphabet.IDENTIFIER, SCobol.DFAState.IDENTIFIER_"""+str(len(current))+""");
	}
}
"""
	return head + body + foot



kws = []
for line in fileinput.input():
	if line.strip():
		kws.append(line.strip())

print(kws)


states_m = {}
identifier_max_length = 16

for kw in kws:
	for i in range(len(kw)):
		current = kw[:i+1].upper().replace('-','_')
		states_m[current] = [[], [], "SCobol.LexicalUnit.IDENTIFIER"]
		if i >= identifier_max_length:
			states_m[current][2] = "null"

for kw in kws:
	for i in range(len(kw)-1):
		current = kw[:i+1].upper().replace('-','_')
		transition = kw[i+1]
		next = kw[:i+2].upper().replace('-','_')
		if transition not in states_m[current][0]:
			states_m[current][0].append(transition)
			states_m[current][1].append(next)

	current = kw.upper().replace('-','_')
	states_m[current][2] = "SCobol.LexicalUnit."+current+"_KEYWORD"


for state in states_m:

	states_m[state][0].sort()
	states_m[state][1].sort()
	text = state_text(state, states_m[state][0], states_m[state][1], states_m[state][2], identifier_max_length)
	fd = open('o/'+state+'.java', 'w')
	fd.write(text)
	fd.close()