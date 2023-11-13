import gui.*;
import java.awt.Color;

public class ConwaySimulator implements Simulable{
    private Conway conway;
    private GUISimulator gui;
    
    public ConwaySimulator(GUISimulator gui, Conway conway){
        this.conway = conway;
        this.gui = gui;
    }

    @Override
    public void next() {
        this.conway.next();
        System.out.println(this.conway.toString());

        //partie affichage
        gui.reset();
        for (int i = 0; i < this.conway.getLength(); i++) {
            for(int j = 0; j < this.conway.getHeight(); j++){
                if(this.conway.getCellByIndice(i, j).getState() == 1){
                    gui.addGraphicalElement(new Rectangle(i*50, j*50, Color.GREEN, Color.BLACK, 50));
                }
            }
        }
    }

    @Override
    public void restart(){
        this.conway.reInit();
    }
}
