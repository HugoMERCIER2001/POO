import java.awt.Point;

public class Balls{
    private int nbBalls;
    private Point[] listeBalls;
    private Point[] listeBallsInit;


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

    public void ajouterPoint(Point p){
        //fonction qui ajoute un Point dans la classe (modifie donc nbBalls, listeBalls et listeBallsInit), à la fin des tableaux.
        this.nbBalls = this.nbBalls + 1;
        

    }

    void translate(int dx, int dy){
        //fonction qui translate toutes les balles de dx en x et dy en y.
        for(int i = 0; i < this.listeBalls.length; i++){
            this.listeBalls[i].translate(dx, dy);
        }
    }

    void reInit(){
        // fonction qui remet toutes les balles à leur position initiale.
        for(int i = 0; i < this.listeBalls.length; i++){
            this.listeBalls[i] = this.listeBallsInit[i];
        }
    }
}