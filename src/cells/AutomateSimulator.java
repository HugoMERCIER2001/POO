import gui.*;
import java.awt.Color;

public abstract class AutomateSimulator implements Simulable{
    private AutomateCellulaire automate;
    private GUISimulator gui;
    
    public AutomateSimulator(GUISimulator gui, AutomateCellulaire automate){
        this.automate = automate;
        this.gui = gui;
    }

    public abstract void displayCell(int i, int j);

    @Override
    public void next() {
        this.automate.next();
        System.out.println(this.automate.toString());

        //partie affichage
        gui.reset();
        for (int i = 0; i < this.automate.getLength(); i++) {
            for(int j = 0; j < this.automate.getHeight(); j++){
                displayCell(i, j);
            }
        }
    }

    @Override
    public void restart(){
        this.automate.reInit();
    }
}