/*
 * MurGauche.java
 *
 * Created on 1 mars 2012, 13:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package modele.FormeFixe;

import java.awt.Rectangle;

import outils.Bord1;
import outils.Dimension;
import outils.Para;

/**
 *
 * @author mariannesimonot
 */
public class MurGauche extends FormeFixe {

    private int largeur;
    private int hauteur;
    private Rectangle recMurGauche;

    /** Creates a new instance of MurGauche */
    public MurGauche(Dimension te) {
        super(15, 0.8, Bord1.gauche, te);
        this.hauteur = te.getHauteur();
        this.largeur = te.getLargeur();

        // on ajoute 5 pour ne pas avoir de bug de collision
        this.recMurGauche = new Rectangle(0, this.hauteur, Para.EPAISSEUR_MUR+5, this.hauteur);
        
        //System.out.println("COD MUR GAUCHE");
        //System.out.println(""+0+""+0+""+20+""+this.largeur);
    }


    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Rectangle getForme() {
        // toDo
        return this.recMurGauche;
    }
}
