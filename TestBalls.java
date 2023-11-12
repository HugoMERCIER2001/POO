import java.awt.Point;

public class TestBalls {
    public static void main(String args[]){
        int[] listeX = {4, 4, 1, 0, 7, 2}; //Liste des coordonnées X des Points du test.
        int[] listeY = {2, 1, 2, 3, 9, 7}; //Liste des coordonnées Y des Points du test.
        Point[] listePoints = new Point[listeX.length];
        for(int i = 0; i < listePoints.length; i++){
            listePoints[i] = new Point(listeX[i], listeY[i]);
        }
        Balls BallTest = new Balls(listePoints);
        System.out.println("BallTest a initialement pour coordonées : \n" + BallTest.toString());
        BallTest.translate(10, 10);
        System.out.println("Après translation de 10 toutes les coordonnées : \n" + BallTest.toString());
        BallTest.reInit();
        System.out.println("Après reinitialisation de toutes les coordonnées : \n" + BallTest.toString());
        BallTest.translate(10, 10);
        System.out.println("Après translation de 10 toutes les coordonnées : \n" + BallTest.toString());
        BallTest.reInit();
        System.out.println("Après reinitialisation de toutes les coordonnées : \n" + BallTest.toString());
    }
}

