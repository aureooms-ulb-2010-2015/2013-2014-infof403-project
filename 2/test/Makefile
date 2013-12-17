.SECONDARY:

SRC = in
TMP = tmp
OUT = out

SOURCES = $(shell find $(SRC))
OUTPUTS = $(patsubst $(SRC)/%,$(OUT)/%,$(SOURCES))
TEMPORARIES = $(patsubst $(SRC)/%,$(TMP)/%,$(SOURCES))

REQUIRED_DIRS = $(OUT) $(TMP)
_MKDIRS := $(shell for d in $(REQUIRED_DIRS); \
             do                               \
               [ -d $$d ] || mkdir -p $$d;  \
             done)

all: $(OUTPUTS)

$(OUT)/%: $(TMP)/%
	llvm-as $^ -o=$@

$(TMP)/%: $(SRC)/%
	cat $^ | java -jar ../dist/scc.jar > $@

clean:
	rm -rf $(REQUIRED_DIRS)