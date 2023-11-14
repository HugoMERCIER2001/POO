# POO
lien vers le sujet du projet : https://programmation-orientee-objet.pages.ensimag.fr/poo/resources/tpl/sujet.pdf

## 2. Un premier simulateur : la balle.
Interface graphique disponible sous forme d'archive gui.jar. La docu de des API de cette IG est : GUISimulator et Simulable (sur la page chamilio du projet), et on peut tester avec TestInvader.

### 2.1 Les balles :
On crée pas la classe Ball, on utilise la classe Point du package java.awt. Et on doit étudier les Api de cette classe sur sa docu dispo au lien : https://docs.oracle.com/javase/8/docs/api/java/awt/Point.html 

Elle est extend de Point2D et réalise l'interface Serializable (pas très intéréssant).
La classe point possède 2 attributs PUBLIC: - int x et int y;
Elle a 3 constructeurs : Point() -> construit un point en (0, 0).
                         Point(Point p) -> copie le point p.
                         Point(int x , int y) -> construit un point en (x, y).


Elle a des méthodes (get, set, move, translate, toString) et elle hérite certaines méthodes : (clone, distance, distance, distance, distanceSq, distanceSq, distanceSq, hashCode, setLocation) de sa classe mère Point2D.

### 2.2 Animons un peu tous cela :

Mathis, Hamza, voci le déscriptif (très complet voir trop) de ce que j'ai fais dans cette partie.

#### 3 Etapes dans cette partie : 
- Ajouter le package gui.jar.
- Coder BallsSimulator.java qui définie la classe BallsSimulator qui implémente l'interface Simulable (on lui donne un seul attribut de type Balls, un constructeur et les 2 méthodes : -next() qui est  de translate(10, 10) de 'atribut Balls  et -restart() qui reInit() l'atribut Balls globalement).
- Copier-Coller TestBallsSimulator.java du Sujet et adapter le makefile pour lancer ce test.

#### Points particuliers :

Partie 1 un peu galère car il faut ajouter les archives données (le gui.jar sa doc etc ...) pour utiliser des méthodes et classes définies dans gui.jar qui se trouve dans le dossier lib. Le dossier doc possède tous les fichier   html de documentation des classes contenues dans le gui.jar. Et le dossier bin et src servent seulement au TestInvader. (respectivement là où on stock ses .class et là ou on trouve son .java).

Ce qu'il faut retenir c'est que il faut utiliser le Makefile pour lancer les mains des Test (TestBallsSimulator et TestInvader en écrivant make dans le terminal). 

Pourquoi : parce que il faut ajouter des paramètres lors de la compilation et execution de nos test, (après le javac et java), notamment : -classpath lib/gui.jar:. qui permet de préciser que les classes utilisés se trouve dans le gui.jar (grâce au -classpath lib/gui.jar) et dans le fichier courant (grâce au :. à la fin). (Sinon il sort des erreurs du genre on a pas le package gui ou on connait pas la classe Balls). Ou encore le -d nom_du_dossier qui permet de rediriger les .class créés dans le dossier spécifié.(Seulement pour TestInvader, pas pour TestBallsSimulator). 

En réalité, on peut le faire directement dans le terminal mais devient pénible à la longue.

Ensuite je tiens à spécifier que la classe BallsSimulator possède un constructeur particulier que j'ai définie de la sorte pour avoir un prompte de sortie qui correspond presque exactement à l'exemple donné à la suite de la figure 3 de cette partie, mais que c'est un constructeur pas dutout général et que son implémentation importe peu je crois.

## 4

### 4.1 Programmation d'un systême de Boids :
Les valeurs par défault des attributs des Boids sont :
- x, y, velocityX, velocityY = 0.0d;
- distanceVision = 400.0d;
- angleVision = 160.0d;