JFLAGS = -g
JC = javac
JDOC = javadoc
LINK = jar cvfm

OUTPUT_NAME = dist/s_cobol_lexical_analysis.jar
DOCDIR = doc/java
SRC = src
CLASS = class
DOCSOURCES = $(shell find $(SRC) | grep \\.java$$)
SOURCES = $(shell find $(SRC) | grep \\.java$$ | grep -v package-info\\.java$$)
CLASSES = $(patsubst $(SRC)/%,$(CLASS)/%,$(patsubst %.java,%.class,$(SOURCES)))
MANIFEST = MANIFEST.MF

REQUIRED_DIRS = $(CLASS) dist
_MKDIRS := $(shell for d in $(REQUIRED_DIRS); \
             do                               \
               [ -d $$d ] || mkdir -p $$d;  \
             done)

default: all

all: $(OUTPUT_NAME)

$(OUTPUT_NAME): $(CLASSES)
	$(LINK) $(OUTPUT_NAME) $(MANIFEST) -C $(CLASS) .

$(CLASS)/%.class: $(SRC)/%.java
	$(JC) $(JFLAGS) $(SOURCES) -d $(CLASS)

doc: $(DOCSOURCES)
	javadoc $(DOCSOURCES) -d $(DOCDIR)

clean:
	$(RM) -r $(REQUIRED_DIRS)