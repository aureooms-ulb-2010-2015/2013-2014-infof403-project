import sys, json

from ll1 import *

def main():

	with open(sys.argv[1], 'r') as fp:
		rules = json.load(fp)

	grammar = LL1Grammar(rules)

	max_s = 0
	i = 0

	for unit in grammar.rules_sorted:
		if(len(unit) > max_s):
			max_s = len(unit)
		for rule in rules[unit]:
			i += 1

	format = '[%' + str(len(str(i-1))) + 'd] %' + str(max_s) +'s -> %s'


	i = 0

	for unit in grammar.rules_sorted:
		if len(rules[unit]) > 0:
			rule = rules[unit][0]
			print(format % (i, unit, 'ε' if rule == [] else ' '.join(rule)))
			i += 1
			for j in range(1, len(rules[unit])):
				rule = rules[unit][j]
				print(format % (i, '', 'ε' if rule == [] else ' '.join(rule)))
				i += 1



if __name__ == '__main__':
	main()