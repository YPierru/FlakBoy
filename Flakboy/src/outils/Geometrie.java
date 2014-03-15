/*
 * Geometrie.java
 *
 * Created on 14 f�vrier 2012, 17:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package outils;

import java.awt.Rectangle;

/**
 * Cette classe reproduit les methodes de Rectangle(java.awt) mais pour notre terrain que nous g�rons
 * avec l'axe des x "en bas" (comme en math). 
 * Il vous faudra sans doute ajouter des m�thodes.
 * @author mariannesimonot
 */
public class Geometrie {

	/** Creates a new instance of Geometrie */
	public Geometrie() {
	}

	/*
	 * retourne true ssi r1 et r2 aont au moins un point en commun.
	 */
	public static boolean intersects(Rectangle recFB, Rectangle recFixe){
            
            double i=recFB.getX();
            double j=recFB.getY();

            while (i<(recFB.getX()+recFB.getWidth()) && !contains(recFixe,i,j)){
                while (j<(recFB.getY()-recFB.getHeight()) && !contains (recFixe,i,j)){
                    j--;
                }
                i++;
            }
            
            return contains(recFixe,i,j);
	}

	/*
	 * retourne true ssi le point(x,y) est dans le rectangle r1
	 */
	public static boolean contains(Rectangle r1, double x, double y){

            // si le point x,y est compris dans le rectangle
            return (x>=r1.getX() && x<= r1.getX()+r1.getWidth() && y<=r1.getY() && y>= r1.getY()-r1.getHeight());
        }

}

