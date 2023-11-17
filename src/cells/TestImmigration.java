import gui.GUISimulator;
import java.awt.Color;

public class TestImmigration {
    public static void main(String[] args) {
        Immigration immigration = new Immigration(75, 50);
        int cellSize = 10;
        immigration.setNbStates(4);

        // remplissage aléatoire de l'automate
        for(int i = 0; i < immigration.getLength(); i++){
            for(int j = 0; j < immigration.getHeight(); j++){
                immigration.setCellState(i, j, (int) (Math.random() * immigration.getNbStates()));            }
        }

        // remplissage de l'automate en divisant dans la longueur par le nombre
        // d'etats, et en remplissant chaque partie avec l'etat correspondant
        // int nbParts = immigration.getNbStates();
        // int partLength = immigration.getLength() / nbParts;
        // for(int i = 0; i < nbParts; i++){
        //     for(int j = 0; j < immigration.getHeight(); j++){
        //         for(int k = i * partLength; k < (i + 1) * partLength; k++){
        //             immigration.setCellState(k, j, i);
        //         }
        //     }
        // }

        // redefinie cet etat de l'automate comme etat initial
        immigration.setInit();

        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);

        ImmigrationSimulator immigrationSimulator = new ImmigrationSimulator(gui, immigration, cellSize);
        gui.setSimulable(immigrationSimulator);        
    }

}
