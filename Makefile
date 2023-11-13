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

# Define the source directories
SRC_DIR = src
BIN_DIR = bin
BALLS_DIR = $(SRC_DIR)/balls

# Define the classpath
# CLASSPATH = .:lib/gui.jar # Linux
CLASSPATH = .;lib/gui.jar # Windows

all: balls

balls: compileBalls runTestBallsSimulator

compileBalls:
	javac -d $(BIN_DIR) -classpath $(CLASSPATH) $(BALLS_DIR)/*.java

runTestBallsSimulator:
	java -classpath $(CLASSPATH) TestBallsSimulator

clean:
	rm -rf $(SRC_DIR)/*.class


###############################################Partie Test Balls Simulator#############################################################""
