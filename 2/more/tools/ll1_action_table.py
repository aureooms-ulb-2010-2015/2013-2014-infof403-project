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

	#to LATEX
	

	dont = []
	
	
	for i in range(len(grammar.alphabet)):
		take = False
		for key in action_table:
			if (action_table[key][i]!= None):
				take = True
				break
		if(not take):
			dont.append(i)

	print(u("Rule"),a(),end=""),
	i=0
	for terminal in grammar.alphabet:
		if(i not in dont):
			print(u(terminal), end=""),
			if(i < len(grammar.alphabet)):
				print(a(), end=""),
		i+=1

	print("\\\\ \hline")
	for key in action_table:
		print(u(key), end=""),
		for i in range(len(grammar.alphabet)):
			if (i not in dont):
				if(action_table[key][i]!=None):
					print(at(action_table[key][i]),a(), end="" )
				else:
					print(e(),a(), end="" )
		print("\\\\ \hline")

def u(s):	
	return '{:<20}'.format(s)
def at(s):	
	return '{:<3}'.format(s)
def a():
	return '{:<3}'.format("&")
def e():
	return '{:<1}'.format(" ")

	

if __name__ == '__main__':
	main()