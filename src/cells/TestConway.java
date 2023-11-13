import gui.GUISimulator;
import java.awt.Color;

public class TestConway {


    public static void main(String[] args) {
        Conway conway = new Conway(75, 50);
        int cellSize = 10;

        // remplissage aléatoire de l'automate
        for(int i = 0; i < conway.getLength(); i++){
            for(int j = 0; j < conway.getHeight(); j++){
                conway.setCellState(i, j, (int) (Math.random() * 2));
            }
        }

        // redefinie cet etat de l'automate comme etat initial
        conway.setInit();

        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);

        ConwaySimulator conwaySimulator = new ConwaySimulator(gui, conway, cellSize);
        gui.setSimulable(conwaySimulator);        
    }

}
