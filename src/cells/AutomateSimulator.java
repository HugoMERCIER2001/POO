import gui.*;
import java.awt.Color;

public abstract class AutomateSimulator implements Simulable{
    private AutomateCellulaire automate;
    private GUISimulator gui;
    private int cellSize;
    
    public AutomateSimulator(GUISimulator gui, AutomateCellulaire automate, int cellSize){
        this.automate = automate;
        this.gui = gui;
        this.cellSize = cellSize;
        draw();
    }

    public void setAutomate(AutomateCellulaire automate){
        this.automate = automate;
    }

    public AutomateCellulaire getAutomate(){
        return this.automate;
    }

    public void setGui(GUISimulator gui){
        this.gui = gui;
    }

    public GUISimulator getGui(){
        return this.gui;
    }
    
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }
    
    public int getCellSize() {
        return this.cellSize;
    }

    public abstract void displayCell(int i, int j);

    @Override
    public void next() {
        this.automate.next();
        System.out.println(this.automate.toString());
        draw();
    }

    //partie affichage
    public void draw(){
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
        System.out.println(automate.getInit());        
        draw();
    }
}