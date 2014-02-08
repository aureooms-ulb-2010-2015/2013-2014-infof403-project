#!/usr/bin/python
import sys, os
		
class LibraryBuilder:

	rules = "'canvas : texbuilder SRC_FOLDER OUTPUT_FILENAME'"
	
	def __init__(self,dir):
		self.dir = dir + "/"
		self.content = ""
		
	def assemble(self, out):
		self.content = self.concat()
		self.write_result(out)
			
	def concat(self):
		buffer = ""
		for f in sorted(os.listdir(self.dir)):
			if os.path.isdir(self.dir+"/"+f):
				sub = LibraryBuilder(self.dir+"/"+f)
				buffer += sub.concat()

			elif f[-4:] == '.tex':
				stream = open(self.dir+"/"+f,'r')
				for line in stream:
					buffer += line
				buffer += "\n"
				stream.close()
		
		return buffer
		
	def write_result(self, output):
		output.write(self.content)
			
	
	@staticmethod
	def displayRules():
		print(LibraryBuilder.rules)

def handle(path, output):

	if os.path.isdir(path):
		LibraryBuilder(path).assemble(output)

	elif os.path.isfile(path+'.tex'):
		with open(path+'.tex') as infile:
			for line in infile:
				output.write(line)
			output.write('\n')

	
if __name__ == '__main__':
	if (len(sys.argv) >= 3):
		dir = sys.argv[1]
		out = sys.argv[2]
		output = open(out,'w')

		handle(dir+'/preamble', output)
		output.write('\\begin{document}\n')
		handle(dir+'/title', output)
		handle(dir+'/before', output)
		handle(dir+'/main', output)
		output.write('\\appendix\n')
		handle(dir+'/appendix', output)
		handle(dir+'/after', output)
		output.write('\\end{document}\n')



		output.close()
		
	else:
		LibraryBuilder.displayRules()
