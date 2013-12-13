import sys, json

# rules = {	
# 	'<PROGRAM>' : [
# 		['<IDENT>', '<ENV>', '<DATA>', '<PROC>']
# 	],
# 	'<VAR_LIST>': [
# 		['<VAR_DECL>', '<VAR_LIST>']
# 	],
# 	'<VAR_DECL>': [
# 		['INTEGER', 'IDENTIFIER', 'PIC', 'IMAGE', '<VAR_DECL_TAIL>']
# 	],
# 	'<VAR_DECL_TAIL>': [
# 		['END_OF_INSTRUCTION'],
# 		['VALUE', 'INTEGER', 'END_OF_INSTRUCTION']
# 	],
# 	'<VAR_LIST>': [
# 		['<VAR_DECL>', '<VAR_LIST>'],
# 		[]
# 	]
# }

# first = {
# 	'<PROGRAM>' : ['IDENTIFICATION'],
# 	'<IDENT>' : ['IDENTIFICATION'],
# 	'<ENV>' : ['ENVIRONMENT'],
# 	'<DATA>' : ['DATA'],
# 	'<PROC>' : [],
# 	'<VAR_LIST>' : ['INTEGER', ''],
# 	'<VAR_DECL>' : ['INTEGER'],
# 	'<VAR_DECL_TAIL>' : ['VALUE', 'PROCEDURE', 'END_OF_INSTRUCTION']
# }

# follow = {
# 	'<PROGRAM>' : [],
# 	'<IDENT>' : ['ENVIRONMENT'],
# 	'<ENV>' : ['DATA'],
# 	'<DATA>' : ['PROCEDURE'],
# 	'<PROC>' : [],
# 	'<VAR_LIST>' : ['PROCEDURE'],
# 	'<VAR_DECL>' : ['INTEGER', 'PROCEDURE'],
# 	'<VAR_DECL_TAIL>' : ['INTEGER', 'PROCEDURE']
# }

rules = None
first = {}
follow = {}
rules_sorted = []

# def grammar_to_tail_graph(rules):
# 	graph = {}
# 	for node in rules.keys():
# 		graph[node] = set([])
# 		for rule in rules[node]:
# 			if len(rule) > 0:
# 				adj = rule[-1]
# 				if adj in rules and adj != node: graph[node] |= set([adj])

# 	return graph

# def topological_sort(graph):
# 	prev  = {}
# 	sort  = []
# 	queue = []

# 	for node in graph.keys():
# 		prev[node] = 0

# 	for node in graph.keys():
# 		for adj in graph[node]:
# 			prev[adj] += 1

# 	for node in graph.keys():
# 		if prev[node] == 0: queue.append(node)
	

# 	while len(queue) > 0:
# 		node = queue[0]
# 		del queue[0]
# 		sort.append(node)
# 		for adj in graph[node]:
# 			prev[adj] -= 1
# 			if prev[adj] == 0: queue.append(adj)

# 	return sort

def line(identation = 0, text = ''):
	print('\t' * (identation + 1), text, sep = '')

def is_non_terminal(element):
	return element[0] == '<'

def get_first(element):
	if is_non_terminal(element):
		if element not in first:
			first[element] = []
			for rule in rules[element]:
				if len(rule) > 0:
					first[element] += get_first(rule[0])
		return first[element]
	else: return [element]

def rule_text(rule):
	return rule[1:-1]

def compute_first():
	for unit in rules_sorted:
		if unit not in first:
			first[unit] = []
			for rule in rules[unit]:
				if len(rule) > 0:
					first[unit] += get_first(rule[0])

def compute_follow():
	for unit in rules_sorted:
		follow[unit] = []

	for unit in rules_sorted:
		for rule in rules[unit]:
			if len(rule) > 1:
				for current, next in zip(rule[:-1], rule[1:]):
					if is_non_terminal(current) and get_first(next) not in follow[current]:
						follow[current] += get_first(next)


	end = False

	while not end:
		end = True
		for unit in rules_sorted:
			for rule in rules[unit]:
				if len(rule) > 0:
					i = -1
					while len(rule) + i + 1 > 0 and (i == -1 or [] in rules[rule[i + 1]]):
						if is_non_terminal(rule[i]):
							tmp = set(follow[rule[i]])
							follow[rule[i]] = list(set(follow[rule[i]]) | set(follow[unit]))
							if tmp != set(follow[rule[i]]): end = False
						else:
							break
						i -= 1

def main():
	global rules, rules_sorted, first, follow

	with open(sys.argv[2], 'r') as fp:
		print(fp.read())

	with open(sys.argv[1], 'r') as fp:
		rules = json.load(fp)

	rules_sorted = sorted(rules.keys())

	compute_first()
	compute_follow()

	for unit in rules_sorted:
		line(0, 'public void handle_' + rule_text(unit) + '() throws Exception{')
		if len(rules[unit]) > 1:
			line(1, 'this.read();')
			line(1, 'switch(this.token.unit){')
			terminals = []
			for rule in rules[unit]:
				if len(rule) > 0:
					element = rule[0]
					for terminal in get_first(element):
						terminals.append('LexicalUnit.' + terminal)
						line(2, 'case ' + terminal + ':')
					if is_non_terminal(element):
						line(3, 'this.unread();')
						line(3, 'this.handle_' + rule_text(element) + '();')
					for element in rule[1:]:
						if is_non_terminal(element):
							line(3, 'this.handle_' + rule_text(element) + '();')
						else:
							line(3, 'this.read();')
							line(3, 'this.check_token_unit(LexicalUnit.' + element + ');')
					line(3, 'break;')

				elif len(follow[unit]) > 0:
					for terminal in follow[unit]:
						terminals.append('LexicalUnit.' + terminal)
						line(2, 'case ' + terminal + ':')
					line(3, 'this.unread();')
					line(3, 'break;')

			line(2, 'default:')
			line(3, 'this.handle_bad_token(new LexicalUnit[]{' + ', '.join(terminals) + '});')
			line(3, 'break;')
			line(1, '}')

		else:
			for element in rules[unit][0]:
				if is_non_terminal(element):
					line(1, 'this.handle_' + rule_text(element) + '();')
				else:
					line(1, 'this.read();')
					line(1, 'this.check_token_unit(LexicalUnit.' + element + ');')
		line(0, '}')
		line()

	line(-1, '}')	


if __name__ == '__main__':
	main()