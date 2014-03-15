/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.FormeFixe.armesConcretes;

import modele.FormeFixe.Arme;
import outils.Dimension;
import modele.jeu.FB;
import outils.Bord1;
import outils.Trajectoire;

/**
 *
 * @author bmebarki
 */
public class Mine extends Arme {



    public Mine(Bord1 bord, int debut, Dimension te) {

        // longueur = 50
        // epaisseur = 10
        // coeffVitesse = 2.5
        // degat = 20
        // prix = 30
        // nb utilisation = 1
        super("Mine", bord, debut, 50, 10, 2.5, 20, 30, 1, te);
    }

    @Override
    public Trajectoire faireRebondir(FB fb, Bord1 directionAInverser) {

        double abscisse = fb.getTrajectoire().abcisseActuelle();
        double ordonnee = fb.getTrajectoire().ordonneeActuelle();
        double vitesse = fb.getTrajectoire().vitesseActuelle();
        double angle=fb.getTrajectoire().angleActuelle();


        // TODO : faire un rebon plus réaliste pour la mine
        switch(directionAInverser){
            case haut:
                System.out.println("*** MINE : HAUT ***");

                //ordonnee-=0.3;
                angle=-angle;

                // angle=-(90-(abscisse-(ordonnee/2)-abscisse+(ordonnee/2)));
            break;

            case bas:
                System.out.println("*** MINE : BAS ***");

                //ordonnee+=0.3; // permet de placer fb un peu au dessus
                angle=-angle;
            break;

            case droit:
                System.out.println("*** MINE : DROIT ***");

                //abscisse-=0.3;
                angle=180-angle;

                /*if(angle>0){
                    angle+=90;
                } else{
                    angle-=90;
                }*/
            break;

            case gauche:
                System.out.println("*** MINE : GAUCHE ***");
                
                //abscisse+=0.3;
                angle=180-angle;

                /*if(angle>0){
                    angle-=90;
                } else{
                    angle+=90;
                }*/

            break;

        }

        return new Trajectoire(abscisse, ordonnee, vitesse * super.getCoeffVitesse(), angle);
    }


}
