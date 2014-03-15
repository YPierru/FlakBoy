/*
 * Sol.java
 *
 * Created on 1 mars 2012, 12:54
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
public class Sol extends FormeFixe{

        private int largeur;
        private int hauteur;
        private Rectangle recSol;
        private double coeffVitesse=0.8;

	/** Creates a new instance of Sol */
	public Sol(Dimension te) {
            super(15,0.8,Bord1.bas, te);
            this.hauteur=te.getHauteur();
            this.largeur=te.getLargeur();

            //115 pour ne pas avoir a replacer FB
            // on ajoute 5 pour ne pas avoir de bug de collision
            this.recSol=new Rectangle(0,115, this.largeur,Para.EPAISSEUR_MUR+5);

            //System.out.println("COD SOL");
            //System.out.println(" "+0+" "+5+" "+this.largeur+" "+5);
	}

	public Rectangle getForme() {
		// toDo
		return  this.recSol;
	}

//       
}
