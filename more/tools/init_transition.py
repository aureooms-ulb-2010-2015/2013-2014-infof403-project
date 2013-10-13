import sys

states_m = {}

for kw in sys.argv[1:]:
	states_m[kw[0].upper()] = True

states = []
for state in states_m:
	states.append(state)

states.sort()

for state in states:
	print("transition.put('"+state.lower()+"', SCobol.DFAState."+state+")")
	