public abstract class Rules{
    public abstract double calculForceX(Swarm swarm, int position);
    public abstract double calculForceY(Swarm swarm, int position);
}





class Rule1 extends Rules{
    //règle de Cohésion : un agent se dirige vers la position moyenne (centre de masse) des ses voisins.
    private int poid; //représente le poid de la règle, par exemple vaut 100 alors seulement 1% de la force est appliqué sur le boid.
    
    //Liste des constructeurs :
    public Rule1(int poid){
        this.poid = poid;
    }

    //Liste des méthodes de calcul de force :
    @Override
    public double calculForceX(Swarm swarm, int position) {
        double vecteurForceX = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
           if(i != position && swarm.getBoidByIndice(position).verifieVoisinage(swarm.getBoidByIndice(i)) == 1){
                vecteurForceX = vecteurForceX + swarm.getBoidByIndice(i).getX();
            }
        }
        vecteurForceX = vecteurForceX/(swarm.getNbBoid() - 1);
        return vecteurForceX/this.poid;
    }

    @Override
    public double calculForceY(Swarm swarm, int position) {
        double vecteurForceY = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
           if(i != position && swarm.getBoidByIndice(position).verifieVoisinage(swarm.getBoidByIndice(i)) == 1){
                vecteurForceY = vecteurForceY + swarm.getBoidByIndice(i).getY();
            }
        }
        vecteurForceY = vecteurForceY/(swarm.getNbBoid() - 1);
        return vecteurForceY/this.poid;
    }   
}






class Rule2 extends Rules{
    //Règle d'Alignement : un agent tend à se déplacer dans la même direction que ses voisins.
    private int poid; //généralement on doit le fixer à 8.

    //Liste des constructeurs :
    public Rule2(int poid){
        this.poid = poid;
    }

    //Liste des méthodes de calcul de forces :
    @Override
    public double calculForceX(Swarm swarm, int position) {
        double vecteurForceX = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
            if(i != position && swarm.getBoidByIndice(position).verifieVoisinage(swarm.getBoidByIndice(i)) == 1){
                vecteurForceX = vecteurForceX + swarm.getBoidByIndice(i).getVelocityX();
            }
        }
        vecteurForceX = vecteurForceX/(swarm.getNbBoid() - 1);
        return vecteurForceX/this.poid;
    }

    @Override
    public double calculForceY(Swarm swarm, int position){
        double vecteurForceY = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
            if(i != position && swarm.getBoidByIndice(position).verifieVoisinage(swarm.getBoidByIndice(i)) == 1){
                vecteurForceY = vecteurForceY + swarm.getBoidByIndice(i).getVelocityY();
            }
        }
        vecteurForceY = vecteurForceY/(swarm.getNbBoid() - 1);
        return vecteurForceY/this.poid;
    }
}





class Rule3 extends Rules{
    //Règle de Séparation : les agents trop proches se repoussent, pour éviter les collisions.
    private int poid;
    private int distanceMin; //distance à partir de laquelle les agents se repoussent.

    //Liste des constructeurs :
    public Rule3(int poid, int distanceMin){
        this.poid = poid;
        this.distanceMin = distanceMin;
    }

    //Liste des méthodes de calcul de forces :
    @Override
    public double calculForceX(Swarm swarm, int position) {
        double vecteurForceX = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
            if(i != position && swarm.getBoidByIndice(position).calculDistance(swarm.getBoidByIndice(i)) < distanceMin){
                vecteurForceX = vecteurForceX - (swarm.getBoidByIndice(i).getX() - swarm.getBoidByIndice(position).getX());
            }
        }
        return vecteurForceX/this.poid;
    }

    @Override
    public double calculForceY(Swarm swarm, int position){
        double vecteurForceY = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
            if(i != position && swarm.getBoidByIndice(position).calculDistance(swarm.getBoidByIndice(i)) < distanceMin){
                vecteurForceY = vecteurForceY - (swarm.getBoidByIndice(i).getY() - swarm.getBoidByIndice(position).getY());
            }
        }
        return vecteurForceY/this.poid;
    }
}