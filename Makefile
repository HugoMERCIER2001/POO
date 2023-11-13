# Example de makefile pour compiler le squelette de code distribué
# Vous pouvez compléter ce makefile, mais étant donnée la taille du projet, 
# il est FORTEMENT recommandé d'utiliser un IDE!

# Organisation:
#  1) Les sources (*.java) se trouvent dans le répertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) sont générés dans le répertoire bin
#     La hiérarchie des sources (par package) est conservée.
#
#  3) Une librairie gui.jar est distribuée pour l'interface grapique. 
#     Elle se trouve dans le sous-répertoire lib.
#
# Compilation:
#  Options de javac:
#   -d : répertoire dans lequel sont générés les .class compilés
#   -sourcepath : répertoire dans lequel sont cherchés les .java
#   -classpath : répertoire dans lequel sont cherchées les classes compilées (.class et .jar)


###############################################Partie Test Invader#############################################################""
# all: runTestInvader 

# compileTestInvader:
# 	javac -d bin -classpath lib/gui.jar src/TestInvader.java

# runTestInvader: compileTestInvader
# 	java -classpath bin:lib/gui.jar TestInvader

# clean:
# 	rm -rf bin/

###############################################Partie Test Balls Simulator#############################################################""

# Definie les directories
SRC_DIR = src
BIN_DIR = bin
LIB_DIR = lib
BALLS_DIR = $(SRC_DIR)/balls

# Definie le separator
# SEP = : # pour linux
SEP = ;# pour windows


all: balls

balls: compileBalls runTestBallsSimulator

compileBalls:
	javac -d $(BIN_DIR) -classpath .$(SEP)./$(LIB_DIR)/gui.jar$(SEP)$(BIN_DIR)/*.class $(BALLS_DIR)/*.java

runTestBallsSimulator:
	java -classpath .$(SEP)$(LIB_DIR)/gui.jar$(SEP)$(BIN_DIR) TestBallsSimulator

clean:
	rm -rf $(BIN_DIR)/

###############################################Partie Test Balls Simulator#############################################################""
