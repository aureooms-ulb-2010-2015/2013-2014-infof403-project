import sys, json

from ll1 import *

def main():

	action_table = {}

	with open(sys.argv[1], 'r') as fp:
		rules = json.load(fp)

	grammar = LL1Grammar(rules)

	i = 0

	for unit in grammar.rules_sorted:
		action_table[unit] = [None] * len(grammar.alphabet)
		for rule in rules[unit]:
			if len(rule) > 0:
				for terminal in grammar.get_first(rule[0]):
					action_table[unit][grammar.alphabet.index(terminal)] = i

			elif len(grammar.follow[unit]) > 0:
				for terminal in grammar.follow[unit]:
					action_table[unit][grammar.alphabet.index(terminal)] = i

			i += 1

	print(action_table)


if __name__ == '__main__':
	main()