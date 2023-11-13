import java.awt.Point;
import java.awt.Color;

import gui.GUISimulator;

public class BallsSimulator implements Simulable{
    private Balls balls;
    private int balls_speed_x;
    private int balls_speed_y;
    private GUISimulator gui;
    
    public BallsSimulator(GUISimulator gui){
        Point p0 = new Point(0, 100);
        Point p1 = new Point(100, 100);
        Point p2 = new Point(200, 100);
        Point[] listePoints = new Point[3];
        listePoints[0] = p0;
        listePoints[1] = p1;
        listePoints[2] = p2;

        this.balls = new Balls(listePoints);
        this.balls_speed_x = 10;
        this.balls_speed_y = 10;
        this.gui = gui;
    }

    @Override
    public void next() {
        if (this.balls.getBallByIndice(0).x -30 >= 500 || this.balls.getBallByIndice(0).x + 5 <= 0){
            this.balls_speed_x = -this.balls_speed_x;
        }
        if (this.balls.getBallByIndice(0).y  >= 500 || this.balls.getBallByIndice(0).y +5 <= 0){
            this.balls_speed_y = -this.balls_speed_y;
        }
        this.balls.translate(this.balls_speed_x, this.balls_speed_y);
        System.out.println(this.balls.toString());

        //partie affichage
        gui.reset();
        for (int i = 0; i < this.balls.getNbBalls(); i++) {
            gui.addGraphicalElement(new Oval(this.balls.getBallByIndice(i).x, this.balls.getBallByIndice(i).y,
                                                Color.WHITE, Color.WHITE, 10));
        }
    }

    @Override
    public void restart(){
        this.balls.reInit();
    }
}
