 

import modele.jeu.Jeu;
import outils.Para;
import vue.vueBasique.vueJeu;


/*
 * Lancement.java
 *
 * Created on 2 fevvrier 2012, 08:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 * Le main 
 * @author mariannesimonot
 */
public class Lancement {

	/** Creates a new instance of Lancement */
	public Lancement() {}

	public static void main(String[] args) {
		Jeu jeu = new Jeu(Para.TAILLE,Para.TAILLE,Para.ARGENT);

                jeu.initSimulation();
                vueJeu vue= new vueJeu(jeu);
                //jeu.go();
	}
}


