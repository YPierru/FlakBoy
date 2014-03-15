/*
 * FB.java
 *
 * Created on 2 f�vrier 2012, 11:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modele.jeu;

import java.awt.Rectangle;

import outils.Trajectoire;

/**
 *
 * @author mariannesimonot
 */
public class FB {
	private Trajectoire traj;
	private int largeur;
	private int hauteur;
	private double x;
	private double y;
	private int degatRecus;

	/** Creates a new instance of FB */
	public FB(Trajectoire tr) {
		this.traj=tr;
                this.largeur=80;
                this.hauteur=80;

                this.x=this.traj.abcisseActuelle();
                this.y=this.traj.ordonneeActuelle();
	}

	public void avancer(){
                this.traj.avancer();
		this.x=this.traj.abcisseActuelle();
                this.y=this.traj.ordonneeActuelle();
	}

	public Rectangle getForme(){
		return new Rectangle((int)this.x, (int)this.y, this.largeur, this.hauteur);
	}

        public Trajectoire getTrajectoire(){
		return this.traj;
	}

	public void setTrajectoire(Trajectoire tr){
		this.traj=tr;
	}

	public void recoitDegat(int d){
		// ToDo
	}	

	private void setDegatRecus(int degatRecus) {
		// ToDo
	}

	public int getLargeur() {
		return largeur;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x=x;
	}

	public void setY(int y) {
		this.y=y;
	}

	public int getHauteur() {
		return hauteur;
	}

}
