# POO
lien vers le sujet du projet : https://programmation-orientee-objet.pages.ensimag.fr/poo/resources/tpl/sujet.pdf

## Un premier simulateur : la balle.
Interface graphique disponible sous forme d'archive gui.jar. La docu de des API de cette IG est : GUISimulator et Simulable (sur la page chamilio du projet), et on peut tester avec TestInvader.

### Les balles :
On crée pas la classe Ball, on utilise la classe Point du package java.awt. Et on doit étudier les Api de cette classe sur sa docu dispo au lien : https://docs.oracle.com/javase/8/docs/api/java/awt/Point.html 

Elle est extend de Point2D et réalise l'interface Serializable (pas très intéréssant).
La classe point possède 2 attributs PUBLIC: - int x et int y;
Elle a 3 constructeurs : Point() -> construit un point en (0, 0).
                         Point(Point p) -> copie le point p.
                         Point(int x , int y) -> construit un point en (x, y).


Elle a des méthodes (get, set, move, translate, toString) et elle hérite certaines méthodes : (clone, distance, distance, distance, distanceSq, distanceSq, distanceSq, hashCode, setLocation) de sa classe mère Point2D.


