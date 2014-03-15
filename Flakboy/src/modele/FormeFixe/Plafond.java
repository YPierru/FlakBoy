/*
 * Plafond.java
 *
 * Created on 1 mars 2012, 12:59
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
public class Plafond extends FormeFixe{

        private int largeur;
        private int hauteur;
        private Rectangle recPlafond;

	public Plafond(Dimension te) {
            super(15,0.8, Bord1.haut, te);
            this.hauteur=te.getHauteur();
            this.largeur=te.getLargeur();

            // on ajoute 5 pour ne pas avoir de bug de collision
            this.recPlafond=new Rectangle(0,this.hauteur-1,this.largeur,Para.EPAISSEUR_MUR+5);

            //System.out.println("COD PLAFOND");
            //System.out.println(""+0+""+0+""+this.largeur+""+20);
	}

       

	public Rectangle getForme() {
		return this.recPlafond;
	}
}
