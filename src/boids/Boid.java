
public class Boid{
    private double x;
    private double y;
    private double velocityX;
    private double velocityY;
    private double distanceVision; //défini la distance jusqu'à laquelle le Boid voit les autres Boids.
    private double angleVision; //compris entre 0 et 180 il définit à cb de degrès le boid voit devant lui (180 il voit tout, 0 il voit rien).


    //Liste des accesseurs.
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getVelocityX(){
        return this.velocityX;
    }

    public double getVelocityY(){
        return this.velocityY;
    }

    public double getDistanceVision(){
        return this.distanceVision;
    }

    public double getAngleVision(){
        return this.angleVision;
    }

    //Liste des constructeurs :
    public Boid(){
        //Constructeur sans argument : toutes les valeurs sont les valeurs par défaut.
        this.x = 0.0d;
        this.y = 0.0d;
        this.velocityX = 0.0d;
        this.velocityY = 0.0d;
        this.distanceVision = 400.0d;
        this.angleVision = 160.0d;
    }

    public Boid(double x, double y){
        //Constructeur où l'on spécifie seulement la position de départ du Boid : le reste est par défaut.
        this.x = x;
        this.y = y;
        this.velocityX = 0.0d;
        this.velocityY = 0.0d;
        this.distanceVision = 400.0d;
        this.angleVision = 160.0d;
    }

    public Boid(double x, double y, double velocityX, double velocityY){
        //Constructeur où l'on spécifie la position et la vistesse initiale du Boid : la distanceVision et angleVision sont par défaut.
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.distanceVision = 400.0d;
        this.angleVision = 160.0d;
    }

    public Boid(double x, double y, double velocityX, double velocityY, double distanceVision, double angleVision){
        //Constructeur où l'on spécifie tous les attributs.
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.distanceVision = distanceVision;
        this.angleVision = angleVision;
    }

    //Listes des méthodes particulières :
    public double calculDistance(Boid b){
        //On calcul la distance entre le Boid "this" et le Boid "b" donné en argument.
        double distanceX = this.x - b.x;
        double distanceY = this.y - b.y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        return distance;
    }
    public int verifieDistance(Boid b){
        //On vérifie si la distance entre 2 Boids en norme 2 (choix de la norme 2 car on est en 2D) est inférieur à la distanceVision du boid "this". Si oui on renvoi 1 sinon 0.
        double distance = this.calculDistance(b);
        if (distance > this.distanceVision){
            return 0;
        }
        else{
            return 1;
        }
    }

    public int verifieAngle(Boid b){
        //On vérifie si l'angle entre la direction du boid "this" et le vecteur allant de la position du boid "this" au boid "b" donné en argument est inférieur à l'anggleVision du boid "this". Renvoie 1 si dans le champ de vision, et 0 sinon.
        double angle1 = Math.toDegrees(Math.atan2(b.y - this.y, b.x - this.x)); //angle entre le vecteur allant du Boid "this" au Boid "b" et l'axe des abscisses.
        double angle2 = Math.toDegrees(Math.atan2(this.velocityY, this.velocityX)); //angle entre le vecteur vitesse du Boid "this" et l'axe des abscisses.
        double angleDifference = Math.abs(angle2 - angle1);
        if (angleDifference > 180) {
            angleDifference = 360 - angleDifference;
        }
        if(angleDifference > this.angleVision){
            return 0;
        }
        else{
            return 1;
        }
    }


    public int verifieVoisinage(Boid b){
        //On vérifie si le Boid "b" appartient au voisinage du Boid "this", si oui renvoi 1, sinon renvoie 0.
        if(this.verifieDistance(b) == 1 && this.verifieAngle(b) == 1){
            return 1;
        }
        else{
            return 0;
        }
    
    }

    public Boid copieBoid(){
        return new Boid(this.x, this.y, this.velocityX, this.velocityY, this.distanceVision, this.angleVision );
    }


    @Override
    public String toString(){
        return "Boid de position (" + this.x + ", " + this.y + ") a un vecteur vitesse suivant : (" + this.velocityX + ", " + this.velocityY + ") et une distance de vision de " + this.distanceVision + "et un angle de vision de " + this.angleVision + "°.";
    }

}
