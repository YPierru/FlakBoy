/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.FormeFixe.armeDeclenchables;

import modele.FormeFixe.ArmeDeclenchable;
import modele.jeu.FB;
import outils.*;

/**
 *
 * @author ypierru
 */
public class Pique extends ArmeDeclenchable {


    public Pique(Bord1 bord, int debut, Dimension te) {

        // longueur = 100
        // epaisseur = 10
        // coeffVitesse = 0.4
        // degat = 10
        // prix = 20
        // nb utilisation = 6
        super("Pique", bord, debut, 100, 10, 0.4, 10, 20, 1290*3, te);
    }

    @Override
    public Trajectoire creerTrajectoire(FB fb, Bord1 directionAInverser) {

        double abscisse = fb.getTrajectoire().abcisseActuelle();
        double ordonnee = fb.getTrajectoire().ordonneeActuelle();
        double angle = fb.getTrajectoire().angleActuelle();
        
        Trajectoire newTraj=null;
        if(directionAInverser==Bord1.droit || directionAInverser==Bord1.gauche){

            System.out.println("\n*** ARME PIQUE : DROIT ***");
            System.out.println("ANGLE = "+fb.getTrajectoire().angleActuelle());
            System.out.println("VITESSE = "+fb.getTrajectoire().vitesseActuelle());
            System.out.println("X = "+fb.getX());
            System.out.println("Y = "+fb.getY());

            angle=90;
            newTraj = new Trajectoire(abscisse, ordonnee-0.1, 1.2, angle);
        }

        if(directionAInverser==Bord1.haut){
            angle=90;
            newTraj = new Trajectoire (abscisse,ordonnee-0.1,1.2,angle);
        }
        
        
        return newTraj;

    }
}
