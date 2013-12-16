import sys, json

from ll1 import *

def line(identation = 0, text = ''):
	print('\t' * (identation + 1), text, sep = '')

def main():

	with open(sys.argv[2], 'r') as fp:
		print(fp.read())

	with open(sys.argv[1], 'r') as fp:
		rules = json.load(fp)

	grammar = LL1Grammar(rules)

	for unit in grammar.rules_sorted:
		line(0, 'public void handle_' + rule_text(unit) + '() throws Exception{')
		if len(rules[unit]) > 1:
			line(1, 'this.read();')
			line(1, 'switch(this.token.unit){')
			terminals = []
			for rule in rules[unit]:
				if len(rule) > 0:
					element = rule[0]
					for terminal in grammar.get_first(element):
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
							line(3, 'this.match(LexicalUnit.' + element + ');')
					line(3, 'break;')

				elif len(set(grammar.follow[unit]) - set(grammar.first[unit])) > 0:
					for terminal in set(grammar.follow[unit]) - set(grammar.first[unit]):
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
					line(1, 'this.match(LexicalUnit.' + element + ');')
		line(0, '}')
		line()

	line(-1, '}')	


if __name__ == '__main__':
	main()