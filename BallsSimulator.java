import java.awt.Point;

import gui.*;

public class BallsSimulator implements Simulable{
    private Balls balls;
    
    public BallsSimulator(){
        Point p0 = new Point(0, 100);
        Point p1 = new Point(100, 100);
        Point p2 = new Point(200, 100);
        Point[] listePoints = new Point[3];
        listePoints[0] = p0;
        listePoints[1] = p1;
        listePoints[2] = p2;
        this.balls = new Balls(listePoints);
    }

    @Override
    public void next() {
        this.balls.translate(10, 10);
        System.out.println(this.balls.toString());
    }

    @Override
    public void restart(){
        this.balls.reInit();
    }
}
