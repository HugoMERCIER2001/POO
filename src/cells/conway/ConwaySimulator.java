import gui.GUISimulator;

public class ConwaySimulator implements Simulable{
    private Conway conway;
    private GUISimulator gui;
    
    public ConwaySimulator(GUISimulator gui){
        this.conway = new Conway(10, 10);
        this.gui = gui;
    }

    @Override
    public void next() {
        this.conway.next();
        System.out.println(this.conway.toString());

        //partie affichage
        gui.reset();
        for (int i = 0; i < this.conway.getNbCells(); i++) {
            if (this.conway.getCellByIndice(i).getState() == 1){
                gui.addGraphicalElement(new Rectangle(this.conway.getCellByIndice(i).getX(), this.conway.getCellByIndice(i).getY(),
                                                    Color.WHITE, Color.WHITE, 10));
            }
        }
    }

    @Override
    public void restart(){
        this.conway.reInit();
    }
}
