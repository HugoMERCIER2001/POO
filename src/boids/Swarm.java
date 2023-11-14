package boids;
public class Swarm {
    private int length;
    private int height;
    private int nbBoids;
    private Rules[] rulesApplied;
    private Boid[] boids;
    private Boid[] boidsInit;

    //Liste des accesseurs :
    public int getLength(){
        return this.length;
    }

    public int getHeight(){
        return this.height;
    }

    public int getNbBoid(){
        return this.nbBoids;
    }

    public Boid getBoidByIndice(int i){
        if(i >= nbBoids){
            throw new IllegalArgumentException("L'indice dépasse le nombre de Boid.");
        }
        else{
            return this.boids[i];
        }
    }
}
