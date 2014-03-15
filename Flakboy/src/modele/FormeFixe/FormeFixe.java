/*
 * FormeFixe.java
 *
 * Created on 16 f���vrier 2012, 19:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modele.FormeFixe;

import java.awt.Rectangle;

import modele.jeu.FB;
import outils.Bord1;
import outils.Dimension;
import outils.Geometrie;
import outils.Trajectoire;

/**
 *
 * @author mariannesimonot
 */

public abstract class FormeFixe {
	// le plus souvent, une collision fait rebondir en faisant varier la vitesse. On m���morise donc
	// pour chaque formeFixe le coefficient multiplicateur de la vitesse de FB en cas de collision.
	private double coeffVitesse;
	// les degats cr���es par une collision avec cette forme.
	private int degat;
	// Le bord ou est cette forme. Pour les bords, c'est bas pour le sol, haut pour le plafond etc...
	private Bord1 bord;
	private Dimension terrain;
        private Geometrie geo;

	public abstract Rectangle getForme() ;

	/** Creates a new instance of FormeFixe */
	public FormeFixe(int degat,double coefv, Bord1 b, Dimension te) {
		this.geo=new Geometrie();
                this.bord=b;
                this.coeffVitesse=coefv;
                this.terrain=te;
	}


	public FormeFixe() {
		this.geo=new Geometrie();
	}

	public boolean enCollision(FB fb){
		return this.geo.intersects(fb.getForme(), this.getForme());
	}

        /*
         * Comme la plupart des formes font rebondir fb lors d'une collision,
         * nous pla��ons cette m��thode dans FormeFixe afin que toutes les sous classes puissent en profiter.
         * Lorsque Fb est en collision avec quelque chose, il y a une direction qui est interdite.
         * C'est celle ci qu'il faut inverser lors d'un rebond (en jouant sur l'angle de la trajectoire)
         * Si fb rencontre le sol, il ne peut plus aller vers le bas, c'est donc la direction a inverser.
         * si fb rencontre une arme pos��e au sol "par le haut", il n'a plus le droit d'aller en bas.
         * Si fb rencontre une arme pos��e au sol mais "par la droite", il n'a plus le droit d'aller �� droite.
         * Selon votre code, vous n'aurez peut ��tre pas besoin du second argument.
         */
        public Trajectoire faireRebondir(FB fb, Bord1 directionAInverser){
            Trajectoire trajActuelle=fb.getTrajectoire();

            double abscisse=trajActuelle.abcisseActuelle();
            double ordonnee=trajActuelle.ordonneeActuelle();
            double vitesse=trajActuelle.vitesseActuelle();
            double angle=trajActuelle.angleActuelle();


            switch (directionAInverser){
                case haut : 
                    System.out.println("*** PLAFOND ***");
                    ordonnee-=0.3;
                    angle=-trajActuelle.angleActuelle();
                    break;
                    
                case bas :
                    System.out.println("*** SOL ***");
                    ordonnee+=0.3;
                    angle*=-1;
                    break;
                    
                case droit :
                    System.out.println("*** MUR DROIT ***");
                    abscisse -= 0.3;
                    angle=180-angle;

                    /*if(angle>0){
                        angle+=90;
                    } else{
                        angle-=90;
                    }*/
                    break;
               
                case gauche:
                    System.out.println("*** MUR GAUCHE ***");
                    abscisse += 0.3;
                    angle=180-angle;

                    /*if (angle > 0) {
                        angle -= 90;
                    } else {
                        angle += 90;
                    }*/
                    break;
            }

            return new Trajectoire(abscisse, ordonnee, vitesse*this.coeffVitesse, angle);
        }

	/*
	 *Par defaut une forme fixe fait rebondir FB.
	 *Pour changer ce comportement, les sous classes redefiniront creerTrajectoire.
	 */
	public Trajectoire creerTrajectoire(FB fb, Bord1 directionAInverser){

		return this.faireRebondir(fb, directionAInverser);
	}

	/*
	 * une collision == donner une nouvelle trajectoire a fb et faire des degats
	 **/
	public void collision(FB fb, Bord1 directionAInverser){
                fb.setTrajectoire(creerTrajectoire(fb, directionAInverser));
	}

        public Bord1 getBord() {
            return this.bord;
        }
        
        public double getCoeffVitesse() {
            
            return this.coeffVitesse;
        }

        public Dimension getTerrain() {

            return this.terrain;
        }

}
