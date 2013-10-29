#!/usr/bin/python3

import subprocess


def main():

	HEADER = '\033[95m'
	OKBLUE = '\033[94m'
	OKGREEN = '\033[92m'
	WARNING = '\033[93m'
	FAIL = '\033[91m'
	ENDC = '\033[0m'

	mode = ['regex', 'class']
	pipe = subprocess.getoutput('ls test/in')
	test = pipe.split('\n')
	n = len(test) * len(mode)
	i = 1
	for t in test:
		for m in mode:
			print('[', i, '/', n, ']', t, '--mode ', m, end = ' ')
			diff = subprocess.getoutput('bash -c \'diff <(java -jar dist/s_cobol_lexical_analysis.jar test/in/' + t + ' --mode ' + m + ') test/out/' + t + '\'')
			if(diff == ''):
				print(OKGREEN + '✔' + ENDC)
			else:
				print(FAIL + '✖')
				print(diff + ENDC)

			i += 1


if __name__ == '__main__':
	main()