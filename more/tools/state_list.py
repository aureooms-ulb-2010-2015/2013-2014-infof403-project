#!/usr/bin/python

import fileinput


kws = []
for line in fileinput.input():
	if line.strip():
		kws.append(line.strip())

states_m = {}

for kw in kws:
	for i in range(len(kw)):
		states_m[kw[:i+1].upper().replace('-','_')] = True

states = []
for state in states_m:
	states.append(state)

states.sort()

for state in states:
	print(state+',')

print("")

for state in states:
	print('put(DFAState.'+state+', new '+state+'());')
	