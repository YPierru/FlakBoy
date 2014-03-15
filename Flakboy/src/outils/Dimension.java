 /*
 * Dimension.java
 *
 * Created on 3 f�vrier 2012, 13:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package outils;



/**
 * @author mariannesimonot
 */
public class Dimension {
	private int largeur ;
	private int hauteur ;


	/**
	 * Creates a new instance of Dimension
	 */
	public Dimension(int hauteur, int largeur) {
            this.hauteur=hauteur;
            this.largeur=largeur;
	}

	public int getHauteur() {
		return this.hauteur;
	}

	public int getLargeur() {
		return this.largeur;
	}


}

