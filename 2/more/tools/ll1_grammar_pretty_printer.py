import sys, json

from ll1 import *

def main():

	with open(sys.argv[1], 'r') as fp:
		rules = json.load(fp)

	grammar = LL1Grammar(rules)

	i = 0

	for unit in grammar.rules_sorted:
		if len(rules[unit]) > 0:
			rule = rules[unit][0]
			print('[%d] %s -> %s' % (i, unit, 'ε' if rule == [] else ' '.join(rule)))
			i += 1
			for j in range(1, len(rules[unit])):
				rule = rules[unit][j]
				print('[%d] %s -> %s' % (i, " " * len(unit), 'ε' if rule == [] else ' '.join(rule)))
				i += 1



if __name__ == '__main__':
	main()