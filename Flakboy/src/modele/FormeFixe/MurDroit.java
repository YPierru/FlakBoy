/*
 * MurDroit.java
 *
 * Created on 1 mars 2012, 13:12
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
public class MurDroit extends FormeFixe {

        private int largeur;
        private int hauteur;
        private Rectangle recMurDroit;

	/** Creates a new instance of MurDroit */
	public MurDroit(Dimension te) {
           super(15,0.8, Bord1.droit, te);
           this.hauteur=te.getHauteur();
           this.largeur=te.getLargeur();

           // on ajoute 5 pour ne pas avoir de bug de collision
           this.recMurDroit= new Rectangle(this.largeur-1,this.hauteur,Para.EPAISSEUR_MUR+5,this.hauteur);

           //System.out.println("COD MUR DROIT");
           //System.out.println(""+(this.largeur-20)+""+0+""+20+""+this.hauteur);

	}


	public Rectangle getForme() {
		return  this.recMurDroit;
	}

}
