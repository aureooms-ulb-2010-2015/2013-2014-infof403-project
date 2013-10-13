#!/usr/bin/python

import fileinput

kws = []
for line in fileinput.input():
	if line.strip():
		kws.append(line.strip())

states_m = {}

for kw in kws:
	states_m[kw[0].upper()] = True

states = []
for state in states_m:
	states.append(state)

states.sort()

for state in states:
	print("transition.put('"+state.lower()+"', SCobol.DFAState."+state+")")
	