/*
 * Eksasaute.java
 *
 * Created on 16 f�vrier 2012, 17:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modele.FormeFixe.armesConcretes;

import modele.FormeFixe.Arme;
import modele.jeu.FB;
import outils.Bord1;
import outils.Dimension;
import outils.Trajectoire;

/**
 *
 * @author mariannesimonot
 */

// c'est un trampoline qui repousse FB vers le haut
// elle ne fait pas beaucoup de degat et ne pousse pas trop fort
public class Eksasaute extends Arme {

    public Eksasaute(Bord1 bord, int debut, Dimension te) {

        // longueur = 100
        // epaisseur = 10
        // coeffVitesse = 1.8
        // degat = 10
        // prix = 10
        // nb utilisation = 3
        super("Eksasaute", bord, debut, 100, 10, 1.8, 10, 10, 3, te);
    }


    @Override
    public Trajectoire faireRebondir(FB fb, Bord1 directionAInverser) {

        double abscisse = fb.getTrajectoire().abcisseActuelle();
        double ordonnee = fb.getTrajectoire().ordonneeActuelle();
        double vitesse = fb.getTrajectoire().vitesseActuelle();
        double angle = fb.getTrajectoire().angleActuelle();

        switch(directionAInverser){
            case haut:
                System.out.println("*** EKSASAUTE : HAUT ***");
                // TODO
                //angle=((angle+180)-90)/2;
                angle=-angle;
            break;

            case bas:
                System.out.println("*** EKSASAUTE : BAS ***");
                // TODO
                //angle=((angle+180)+90)/2;
                angle=-angle;
            break;

            case droit:
                System.out.println("*** EKSASAUTE : DROIT ***");
                // TODO
                //angle=(angle+180+180)/2;
                angle=180-angle;
            break;

            case gauche:
                System.out.println("*** EKSASAUTE : GAUCHE ***");
                // TODO
                //angle=(angle+180)/2;
                angle=180-angle;
            break;

        }

        return new Trajectoire(abscisse, ordonnee, vitesse * super.getCoeffVitesse(), angle);
    }

}
