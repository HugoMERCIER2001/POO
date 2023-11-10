import java.awt.Point;

public class Balls{
    private int nbBalls;
    private Point[] listeBalls; //liste des points sur lesquels on fait des modifications (translater, déplacer etc ...).
    private Point[] listeBallsInit; //liste des positions initiales des points.


    public int getNbBalls(){
        return this.nbBalls;
    }

    public Point getBallByIndice(int i){
        //renvoie la balle se trouvant dans listBalls à l'indice i.
        if(i >= this.listeBalls.length){
            throw new IllegalArgumentException("L'indice dépasse la taille du tableau listBalls.")
        }
        else{
            return listeBalls[i];
        }
    }

    public Point getBallInitByIndice(int i){
        //renvoie la balle se trouvant dans listBallsInit à l'indice i.
        if(i >= this.listeBalls.length){
            throw new IllegalArgumentException("L'indice dépasse la taille du tableau listBallsInit.")
        }
        else{
            return listeBallsInit[i];
        }
    }

    public void initiePoint(Point p, int i){
        //fonction qui initie le Point d'indice i la classe (modifie listeBalls ET listeBallsInit).
        if(i >= this.nbBalls){
            throw new IllegalArgumentException("L'indice dépasse la taille du tableau listeBalls")
        }
        else{
        this.listeBalls[i] = p;
        this.listeBallsInit[i] = p;
        }
    }

    public Balls(int nbBalls){
        //Constructeur de la classe qui crée un objet Balls dont tous les éléments de listeBalls et listeBallsInit sont à (0, 0).
        this.nbBalls = nbBalls;
        this.listeBalls = Point[nbBalls];
        this.listeBallsInit = Point[nbBalls];
        for(int i = 0; i <= nbBalls; i ++){
            listeBalls[i] = new Point();
            listeBallsInit[i] = new Point();
        }
    }

    public Balls(Point[] listePoints){
        //Constructeur de la classe qui crée un objet Balls dont la liste de Points est la liste donnée en argument.
        this.nbBalls = listePoints.length;
        this.listeBalls = listePoints;
        this.listeBallsInit = listePoints;
    }
}