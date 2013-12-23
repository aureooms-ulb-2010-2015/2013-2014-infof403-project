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

	"""
	print("\\begin{tabular}{|l|l|l|}")
	print ("\\\\ \\hline")
	print(u("Rule"),a(),u("First"),a(),u("Follow"), "\\\\")
	print ("\\\\ \\hline")

	for unit in grammar.rules_sorted:
		sfollow=""
		sfirst =""
		fiKcount = 0;
		foKcount = 0;
		sfi= 0;
		sfo = 0;
		
		firstkeys = []
		followkeys = []
		for key in grammar.first:
			firstkeys.append(key)

		for key in grammar.follow:
			followkeys.append(key)
			
		
		line = ""
		limit = 25
		while ((fiKcount <  len(grammar.first[unit])) or (foKcount < len(grammar.follow[unit] ) ) ):
			line+=a()
			

			
			moreFirsts=(fiKcount < len(grammar.first[unit]) )
			if(moreFirsts):
				sizeNextFirst=len(grammar.first[unit][fiKcount])+2

			while ( sfi + sizeNextFirst < limit and moreFirsts ):
				newfirst = grammar.first[unit][fiKcount]+", "
				line+= newfirst
				sfi+=len(newfirst)

				fiKcount+=1
				

				moreFirsts=(fiKcount < len(grammar.first[unit]) )
				if(moreFirsts):
					sizeNextFirst=len(grammar.first[unit][fiKcount])+2
				

				

			
			sfi=0
			line+=a()+" "

			moreKeys = (foKcount < len(grammar.follow[unit] ) )
			if(moreKeys):
				sizeNextFollow = len(grammar.follow[unit][foKcount])+2
			while ( sfo + sizeNextFollow < limit and moreKeys ):
				newFollow = grammar.follow[unit][foKcount]+", "
				line+= newFollow
				sfo+=len(newFollow)
				foKcount+=1

				
				moreKeys = (foKcount < len(grammar.follow[unit] ) )
				if(moreKeys):
					sizeNextFollow = len(grammar.follow[unit][foKcount])+2
				
				

				
			sfo = 0
			
			line+="\\\\ \n  "
		line+="\hline"
		line=line.lower()
		line = unit +"  "+line
		line = line.replace("_","\\_")
		print(line)
			
		





		
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
	
	
	print(u("Rules"),a(),u("terminal"),a(),u("go to"))


	for key in grammar.rules_sorted:
		i = 0
		print(u(key),end="")
		for go in action_table[key]:
			if(go!=None):
				print(u(" "), a(),u(grammar.alphabet[i]) ,a(), go)
			i+=1
	

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