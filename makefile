
# A simple makefile for compiling three java classes
#

# define a makefile variable for the java compiler
#
JCC = javac
JVM = java

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile
# (the default one in this case)
#
default: LinkedListStack.class SparseInterface.class SparseMatrix.class

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
LinkedListStack.class: LinkedListStack.java
	$(JCC) $(JFLAGS) LinkedListStack.java

SparseInterface.class: SparseInterface.java
	$(JCC) $(JFLAGS) SparseInterface.java

SparseMatrix.class: SparseMatrix.java
	$(JCC) $(JFLAGS) SparseMatrix.java

MAIN = LinkedListStack
# To start over from scratch, type 'make clean'.
# Removes all .class files, so that the next make rebuilds them
#
clean:
	$(RM) *.class
run: default
	$(JVM) $(MAIN)
