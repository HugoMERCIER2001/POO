import gui.GUISimulator;
import java.awt.Color;

public class TestConway {


    public static void main(String[] args) {
        Conway conway = new Conway(10, 10);
        for (int i = 3; i < 10; i++) {
            conway.setCellState(i, 0, 1);
            conway.setCellState(i, 9, 1);
            conway.setCellState(0, i, 1);
            conway.setCellState(9, i, 1);
        }

        GUISimulator gui = new GUISimulator(1000, 1000, Color.BLACK);
        gui.setSimulable(new ConwaySimulator(gui, conway));
    }

}
