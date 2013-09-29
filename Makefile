JFLAGS = -g
JC = javac

SRC = src
CLASSES = $(shell find $(SRC) | grep \\.java$$)

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class