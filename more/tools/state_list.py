import sys

states_m = {}

for kw in sys.argv[1:]:
	for i in range(len(kw)):
		states_m[kw[:i+1].upper()] = True

states = []
for state in states_m:
	states.append(state)

states.sort()

for state in states:
	print(state+',')

print("")

for state in states:
	print('put(DFAState.'+state+', new '+state+'());')
	