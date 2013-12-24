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

			elif len(set(grammar.follow[unit]) - set(grammar.first[unit])) > 0:
				for terminal in set(grammar.follow[unit]) - set(grammar.first[unit]):
					action_table[unit][grammar.alphabet.index(terminal)] = i

			i += 1


	dont = []
	
	
	for i in range(len(grammar.alphabet)):
		take = False
		for key in action_table:
			if (action_table[key][i]!= None):
				take = True
				break
		if(not take):
			dont.append(i)

	
	"""
	print("\\\\ \hline")
	
	print(u(key), end=""),
	for i in range(len(grammar.alphabet)):
		if (i not in dont):
			if(action_table[key][i]!=None):
				print(at(action_table[key][i]),a(), end="" )
			else:
				print(e(),a(), end="" )
	print("\\\\ \hline")
	"""
	
	

	print("\\begin{longtable}{|l|l|l|}")
	print("\\hline")
	print(u(b("Rules")),a(),u(b("terminal")),a(),u(b("go to")), "\\\\")
	print("\\hline")


	for key in grammar.rules_sorted:
		i = 0
		print(u(key.replace("_","\\_")),end="")
		for go in action_table[key]:
			if(go!=None):
				print(u(" "), a(),u(grammar.alphabet[i].replace("_","\\_")) ,a(), go, "\\\\ \\hline")
			i+=1
			
	print("\\end{longtable}")
	
def b(s):
	return '\\textbf{' + s + '}'

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