import gui.Simulable;

public class BallsSimulator implements Simulable {

    private Balls balls;
    
    @Override
    public void next() {
        this.balls.translate(10, 10);
    }

    @Override
    public void restart(){
        this.balls.reInit();
    }
}
