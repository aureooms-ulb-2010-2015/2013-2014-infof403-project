# -*- coding: utf-8 -*-


def is_non_terminal(element):
	return element[0] == '<'

def rule_text(rule):
	return rule[1:-1]

class LL1Grammar:

	def __init__(self, rules):
		self.rules = rules
		self.first = {}
		self.follow = {}
		self.rules_sorted = sorted(rules.keys())
		self.alphabet = []

		self.compute_first()
		self.compute_follow()
		self.compute_alphabet()

	def compute_alphabet(self):	
		for unit in self.rules_sorted:
			for rule in self.rules[unit]:
				for element in rule:
					if not is_non_terminal(element) and element not in self.alphabet:
						self.alphabet.append(element)
				if rule == [] and 'ε' not in self.alphabet:
					self.alphabet.append('ε')

		self.alphabet = sorted(self.alphabet)

	def get_first(self, element):
		if is_non_terminal(element):
			if element not in self.first:
				self.first[element] = []
				for rule in self.rules[element]:
					if len(rule) > 0:
						self.first[element] += self.get_first(rule[0])
			return self.first[element]
		else: return [element]

	def compute_first(self):
		for unit in self.rules_sorted:
			if unit not in self.first:
				self.first[unit] = []
				for rule in self.rules[unit]:
					if len(rule) > 0:
						self.first[unit] += self.get_first(rule[0])

	def compute_follow(self):
		for unit in self.rules_sorted:
			self.follow[unit] = []

		for unit in self.rules_sorted:
			for rule in self.rules[unit]:
				if len(rule) > 1:
					for current, next in zip(rule[:-1], rule[1:]):
						if is_non_terminal(current) and self.get_first(next) not in self.follow[current]:
							self.follow[current] = list(set(self.follow[current]) | set(self.get_first(next)))


		end = False

		while not end:
			end = True
			for unit in self.rules_sorted:
				for rule in self.rules[unit]:
					if len(rule) > 0:
						i = -1
						while len(rule) + i + 1 > 0 and (i == -1 or [] in self.rules[rule[i + 1]]):
							if is_non_terminal(rule[i]):
								tmp = set(self.follow[rule[i]])
								self.follow[rule[i]] = list(set(self.follow[rule[i]]) | set(self.follow[unit]))
								if tmp != set(self.follow[rule[i]]): end = False
							else:
								break
							i -= 1