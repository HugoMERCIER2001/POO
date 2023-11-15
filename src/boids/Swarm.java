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

    //Liste des constructeurs :
    public Swarm(int length, int height, int nbBoids){
        //Si on ne précise que ces paramètres, on applique seulement les 3 règles de bases sur nos Boids (Cohésion, Alignement, Séparation) et on génère les points aléatoirements.
        this.length = length;
        this.height = height;
        this.nbBoids = nbBoids;
        this.rulesApplied = {new Rule1(100), new Rule2(8), new Rule3(1, 100)};
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = new Boid(Math.random() * length, Math.random() * height);
            this.boidsInit[i] = (Boid) this.boids[i].clone();
        }
    }

    public Swarm(int length, int height, int nbBoids, Rules[] rules){
        //Constructeurs où l'ensemble des Boids sont générés aléatoirement encore, mais l'ensemble des règles sont spécifiés.
        this.length = length;
        this.height = height;
        this.nbBoids = nbBoids;
        this.rulesApplied = new Rules[rules.length];
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= rules.length; i++){
            this.rulesApplied[i] = (Rules) rules[i].clone();
        }
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = new Boid(Math.random() * length, Math.random() * height);
            this.boidsInit[i] = (Boid) this.boids[i].clone();
        }
    }


    public Swarm(int length, int height, Rules[] rules, Boid[] boids){
        //Constructeurs où l'ensemble des Boids sont générés aléatoirement encore, mais l'ensemble des règles sont spécifiés.
        this.length = length;
        this.height = height;
        this.nbBoids = boids.length;
        this.rulesApplied = new Rules[rules.length];
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= rules.length; i++){
            this.rulesApplied[i] = (Rules) rules[i].clone();
        }
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = (Boid) boids[i].clone();
            this.boidsInit[i] = (Boid) boids[i].clone();
        }
    }

    public Swarm(int length, int height, Boid[] boids){
        //Constructeurs où l'ensemble des Boids sont générés aléatoirement encore, mais l'ensemble des règles sont spécifiés.
        this.length = length;
        this.height = height;
        this.nbBoids = boids.length;
        this.rulesApplied = {new Rule1(100), new Rule2(8), new Rule3(1, 100)};
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = (Boid) boids[i].clone();
            this.boidsInit[i] = (Boid) boids[i].clone();
        }
    }


    //Liste des méthodes particulières :
    @Override
    public String toString(){
        String retour = "";
        for(int i = 0; i <= this.nbBoids; i++){
            retour = retour + this.boids[i].toString();
        }
        return retour;
    }

    public void next(){

    }

}
