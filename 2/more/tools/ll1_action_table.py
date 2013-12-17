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
	print("\\hspace{-1.0cm}\\begin{tabular}{|l|l|l|}")
	print(u("Rules"),a(),u("First"),a(),u("go to"))
	print ("\\\\ \\hline")

	for unit in grammar.rules_sorted:
		sfollow=""
		sfirst =""
		count = 0;
		firstkeys = grammar.first.keys()
		followkeys = grammar.follow.keys()

		


		for follow in grammar.follow[unit]:
			sfollow+=follow+", "
		for first in grammar.first[unit]:
			sfirst+=first+", "
		print(u(unit).replace("_","\\_"),a(),s(sfirst).replace("_","\\_").lower(),a(),s(sfollow).replace("_","\\_").lower()," \\\\ \hline")
	
	"""
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
	"""
	"""
	print(u("Rules"),a(),u("terminal"),a(),u("go to"))


	for key in action_table:
		i = 0
		print(u(key),end="")
		for go in action_table[key]:
			if(go!=None):
				print(u(" "), a(),u(grammar.alphabet[i]) ,a(), go)
			i+=1
	"""

def u(s):	
	return '{:<20}'.format(s)
def s(s):
	return '{:<50}'.format(s)
def at(s):	
	return '{:<3}'.format(s)
def a():
	return '{:<3}'.format("&")
def e():
	return '{:<1}'.format(" ")

	

if __name__ == '__main__':
	main()