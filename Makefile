JFLAGS = -g
JC = javac

SRC = src
CLASSES = $(shell find $(SRC) | grep \\.java$$)

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java -d class

default: all

all: mkdir $(CLASSES:.java=.class)

clean:
	$(RM) -r class

mkdir:
	mkdir class