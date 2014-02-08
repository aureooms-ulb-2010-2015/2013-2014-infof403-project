#!/usr/bin/python
import sys, os
		
class LibraryBuilder:

	rules = "'canvas : stybuilder SRC_FOLDER OUTPUT_FILENAME'"
	
	def __init__(self,dir):
		self.dir = dir + "/"
		self.content = ""
		
	def assemble(self, out):
		self.content = self.concat()
		self.write_result(out)
			
	def concat(self):
		buffer = ""
		for f in sorted(os.listdir(self.dir)):
			if os.path.isdir(self.dir+'/'+f):
				sub = LibraryBuilder(self.dir+'/'+f)
				buffer += sub.concat()

			elif f[-4:] == '.sty':
				stream = open(self.dir+'/'+f,'r')
				for line in stream:
					buffer += line
				buffer += "\n"
				stream.close()
		
		return buffer
		
	def write_result(self, out):
		output = open(out,'w')
		output.write(self.content)
		output.close()
			
	
	@staticmethod
	def displayRules():
		print(LibraryBuilder.rules)
	
if __name__ == '__main__':
	if (len(sys.argv) >= 3):
		dir = sys.argv[1]
		out = sys.argv[2]
		LibraryBuilder(dir).assemble(out)
		
	else:
		LibraryBuilder.displayRules()
