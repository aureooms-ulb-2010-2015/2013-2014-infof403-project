#!/usr/bin/python3

import subprocess


def main():
	mode = ['regex', 'class']
	pipe = subprocess.getoutput('ls test/in')
	test = pipe.split('\n')
	for t in test:
		for m in mode:
			diff = subprocess.getoutput('bash -c \'diff <(java -jar dist/s_cobol_lexical_analysis.jar test/in/' + t + ' --mode ' + m + ') test/out/' + t + '\'')
			print(diff)


if __name__ == '__main__':
	main()