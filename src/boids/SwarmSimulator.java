import gui.*;
import java.awt.Color;

public class SwarmSimulator implements Simulable{
    private Swarm swarm;
    private GUISimulator gui;


    //Liste des constructeurs :
    public SwarmSimulator(GUISimulator gui, Swarm swarm){
        this.gui = gui;
        this.swarm = swarm;
    }

    @Override
    public void next(){
        //partie non-graphique :
        this.swarm.next();
        System.out.println(this.swarm.toString());

        //partie graphique :
        gui.reset();
        for (int i = 0; i < this.swarm.getNbBoid(); i++) {
            gui.addGraphicalElement(new Oval((int) this.swarm.getBoidByIndice(i).getX(),(int) this.swarm.getBoidByIndice(i).getY(), Color.GREEN, Color.GREEN, 50));
        }     
    }

    public void restart(){

    }
}