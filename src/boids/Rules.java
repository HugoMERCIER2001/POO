public abstract class Rules{
    public abstract double calculForceX(Swarm swarm, int position);
    public abstract double calculForceY(Swarm swarm, int position);
}

class Rule1 extends Rules{
    //règle de Cohésion : un agent se dirige vers la position moyenne (centre de masse) des ses voisins.
    private int poid; //représente le poid de la règle, par exemple vaut 1 alors seulement 1% de la force est appliqué sur le boid.
    
    @Override
    public double calculForceX(Swarm swarm, int position) {
        double vecteurForceX = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
           if(i != position && swarm.getBoidByIndice(position).verifieDistance(swarm.getBoidByIndice(i)) == 1){
            if(swarm.getBoidByIndice(position).verifieAngle(swarm.getBoidByIndice(i)) == 1){
                vecteurForceX = vecteurForceX + swarm.getBoidByIndice(i).getX();
            }
           }
        vecteurForceX = vecteurForceX/(swarm.getNbBoid() - 1);
        }
    return vecteurForceX/this.poid;
    }

    @Override
    public double calculForceY(Swarm swarm, int position) {
        double vecteurForceY = 0.0d;
        for(int i; i <= swarm.getNbBoid(); i++){
           if(i != position && swarm.getBoidByIndice(position).verifieDistance(swarm.getBoidByIndice(i)) == 1){
            if(swarm.getBoidByIndice(position).verifieAngle(swarm.getBoidByIndice(i)) == 1){
                vecteurForceY = vecteurForceY + swarm.getBoidByIndice(i).getY();
                }
            }
        vecteurForceY = vecteurForceY/(swarm.getNbBoid() - 1);
        }
    return vecteurForceY/this.poid;
    }
}

class Rule2 extends Rules{
}
