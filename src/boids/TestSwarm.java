import gui.GUISimulator;
import java.awt.Color;

public class TestSwarm {

    public static void main(String[] args) {

        Swarm swarm = new Swarm(30);
        GUISimulator gui = new GUISimulator(1000, 1000, Color.WHITE);
        gui.setSimulable(new SwarmSimulator(gui, swarm));
    }
    
}
