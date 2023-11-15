
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
    public Swarm(int nbBoids){
        //Si on ne précise que ces paramètres, on applique seulement les 3 règles de bases sur nos Boids (Cohésion, Alignement, Séparation) et on génère les points aléatoirements.
        this.nbBoids = nbBoids;
        this.rulesApplied = new Rules[]{new Rule1(100), new Rule2(8), new Rule3(1, 100)};
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = new Boid(Math.random() * length, Math.random() * height);
            this.boidsInit[i] = (Boid) this.boids[i].copieBoid();
        }
    }

    public Swarm(int nbBoids, Rules[] rules){
        //Constructeurs où l'ensemble des Boids sont générés aléatoirement encore, mais l'ensemble des règles sont spécifiés.
        this.nbBoids = nbBoids;
        this.rulesApplied = new Rules[rules.length];
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= rules.length; i++){
            this.rulesApplied[i] = (Rules) rules[i];
        }
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = new Boid(Math.random() * length, Math.random() * height);
            this.boidsInit[i] = (Boid) this.boids[i].copieBoid();
        }
    }


    public Swarm(Rules[] rules, Boid[] boids){
        //Constructeurs où l'ensemble des Boids sont générés aléatoirement encore, mais l'ensemble des règles sont spécifiés.
        this.nbBoids = boids.length;
        this.rulesApplied = new Rules[rules.length];
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= rules.length; i++){
            this.rulesApplied[i] = (Rules) rules[i];
        }
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = (Boid) boids[i].copieBoid();
            this.boidsInit[i] = (Boid) boids[i].copieBoid();
        }
    }

    public Swarm(Boid[] boids){
        //Constructeurs où l'ensemble des Boids sont générés aléatoirement encore, mais l'ensemble des règles sont spécifiés.
        this.nbBoids = boids.length;
        this.rulesApplied = new Rules[]{new Rule1(100), new Rule2(8), new Rule3(1, 100)};
        this.boids = new Boid[nbBoids];
        this.boidsInit = new Boid[nbBoids];
        for(int i = 0; i <= nbBoids; i++){
            this.boids[i] = (Boid) boids[i].copieBoid();
            this.boidsInit[i] = (Boid) boids[i].copieBoid();
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
        Boid[] nouveauTableau = new Boid[this.nbBoids];//On va rentrer tous nos résultats dans nôtre nouveau tableau puis échanger ce tableau avec "this.boids" car sinon les calculs vont changer pendant la boucle faussant les résultats.
        for(int i = 0; i <= this.nbBoids; i++){
            double forceAppliqueX = 0.0d;
            double forceAppliqueY = 0.0d;
            double newVelocityX = 0.0d;
            double newVelocityY = 0.0d;
            double newX = 0.0d;
            double newY = 0.0d;
            for(int j = 0; j <= this.rulesApplied.length; j++){
                forceAppliqueX = forceAppliqueX + this.rulesApplied[j].calculForceX(this, i);
                forceAppliqueY = forceAppliqueY + this.rulesApplied[j].calculForceY(this, i);
            }
            newVelocityX = this.boids[i].getVelocityX() + forceAppliqueX;
            newVelocityY = this.boids[i].getVelocityY() + forceAppliqueY;
            newX = this.boids[i].getX() + newVelocityX;
            newY = this.boids[i].getY() + newVelocityY;
            nouveauTableau[i] = new Boid(newX, newY, newVelocityX, newVelocityY, this.boids[i].getDistanceVision(), this.boids[i].getAngleVision());
        }
        this.boids = nouveauTableau; 
    }

}
