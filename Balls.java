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
            throw new IllegalArgumentException("L'indice dépasse la taille du tableau listBalls.");
        }
        else{
            return listeBalls[i];
        }
    }

    public Point getBallInitByIndice(int i){
        //renvoie la balle se trouvant dans listBallsInit à l'indice i.
        if(i >= this.listeBalls.length){
            throw new IllegalArgumentException("L'indice dépasse la taille du tableau listBallsInit.");
        }
        else{
            return listeBallsInit[i];
        }
    }

    public void initiePoint(Point p, int i){
        //fonction qui initie le Point d'indice i la classe (modifie listeBalls ET listeBallsInit).
        if(i >= this.nbBalls){
            throw new IllegalArgumentException("L'indice dépasse la taille du tableau listeBalls");
        }
        else{
        this.listeBalls[i] = p;
        this.listeBallsInit[i] = p;
        }
    }

    public Balls(int nbBalls){
        //Constructeur de la classe qui crée un objet Balls dont tous les éléments de listeBalls et listeBallsInit sont à (0, 0).
        this.nbBalls = nbBalls;
        this.listeBalls = new Point[nbBalls];
        this.listeBallsInit = new Point[nbBalls];
        for(int i = 0; i < nbBalls; i ++){
            listeBalls[i] = new Point();
            listeBallsInit[i] = new Point();
        }
    }

    public Balls(Point[] listePoints){
        //Constructeur de la classe qui crée un objet Balls dont la liste de Points est la liste donnée en argument.
        this.nbBalls = listePoints.length;
        this.listeBalls = new Point[listePoints.length];
        this.listeBallsInit = new Point[listePoints.length];

        // Copie des éléments de listePoints dans listeBalls et listeBallsInit, évite que la modification de listeBalls entraine celle de listeBallsInit.
        for (int i = 0; i < listePoints.length; i++) {
            this.listeBalls[i] = (Point) listePoints[i].clone();//l'utilisation de .clone() ici permet de faire des points dans listeBalls et listeBallsInit des objets distincs.
            this.listeBallsInit[i] = (Point) listePoints[i].clone();
        }
    }

<<<<<<< HEAD
    @Override
=======
    
>>>>>>> ccd3ee38a0cc49f3f6366c60e9c3f96425e887a9
    void translate(int dx, int dy){
        //fonction qui translate toutes les balles de dx en x et dy en y.
        for(int i = 0; i < this.listeBalls.length; i++){
            this.listeBalls[i].translate(dx, dy);
        }
    }

<<<<<<< HEAD
    @Override
    void reInit(){
        // fonction qui remet toutes les balles à leur position initiale.
        for(int i = 0; i < this.listeBalls.length; i++){
            this.listeBalls[i] = this.listeBallsInit[i];
        }
    }

}
=======
    void reInit(){
        // fonction qui remet toutes les balles à leur position initiale.
        for(int i = 0; i < this.listeBalls.length; i++){
            this.listeBalls[i] =(Point) this.listeBallsInit[i].clone();//l'utilisation de .clone() ici permet d'éviter de lier les points des 2 listes.
        }
    }

    @Override
    public String toString(){
        String retour = new String();
        for(int i = 0; i <nbBalls; i++){
            retour = retour + "balle numéro " + i + " : (" + this.listeBalls[i].x + ", " + this.listeBalls[i].y + ")" + "\n";
        }
        return retour;
    }
}
>>>>>>> ccd3ee38a0cc49f3f6366c60e9c3f96425e887a9
