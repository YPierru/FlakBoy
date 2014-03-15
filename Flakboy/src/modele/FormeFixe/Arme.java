/*
 * Arme.java
 *
 * Created on 6 f���vrier 2012, 10:47
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
public class Arme extends FormeFixe {

    private String nom;
    private int debut; // indice de debut de l'arme sur son bord.
    private int longueurCoteBord; // la longueur du cote de l'arme qui repose sur le bord.
    private int epaisseur;
    private int nbUtilisation; // le nombre d'utilisation possible
    private int prix;

    /** Creates a new instance of Arme */
    public Arme(String nom, Bord1 b, int d, int lb, int e, double coeffv, int degat, int prix, int nbu, Dimension te) {

        super(degat, coeffv, b, te);
        this.nom = nom;
        this.debut = d;
        this.longueurCoteBord = lb;
        this.epaisseur = e;
        this.nbUtilisation = nbu;
        this.prix=prix;

    }

    /*
    public Arme( int lb, int e, double coeffv, int degat, int nbu, Dimension te){
    // toDo
    }

    public Arme(){
    // toDo
    }
     */
    // on transforme les armes en rectangle pour g��rer les collisions
    public Rectangle getForme() {

        int x = 0;
        int y = 0;
        int hauteur = 0;
        int largeur = 0;

        switch (super.getBord()) {
            case haut:
                x =this.debut; //5 = ��paisseur du mur droit
                y =  super.getTerrain().getHauteur() - Para.EPAISSEUR_MUR; // = ajout sol
                largeur = this.longueurCoteBord;
                hauteur = this.epaisseur;
                break;
            case bas:
                x = this.debut;
                y = Para.MYSTERE_MOTEUR;
                largeur = this.longueurCoteBord;
                hauteur = this.epaisseur;
                break;

            case droit:
                x = super.getTerrain().getLargeur() - this.epaisseur - Para.EPAISSEUR_MUR;
                y = this.debut + Para.MYSTERE_MOTEUR;
                largeur = this.epaisseur;
                hauteur = this.longueurCoteBord;
                break;

            case gauche:
                x = this.epaisseur + Para.EPAISSEUR_MUR;
                y = this.debut + Para.MYSTERE_MOTEUR;
                largeur = this.epaisseur;
                hauteur = this.longueurCoteBord;
                break;

            default:
                System.out.println("BUG OMG !");
        }

        return new Rectangle(x, y, largeur, hauteur);
    }

    // d��cremente le nb d'utilisation de l'arme
    public void utiliser() {

        if (this.nbUtilisation > 0) {
            this.nbUtilisation--;
        }
    }

    // permet de savoir si l'on peut utiliser l'arme ou non
    public boolean utilisable() {
        return this.nbUtilisation > 0;
    }

    public int getnbUse(){
        return this.nbUtilisation;
    }
    
    public String getNom() {
        return this.nom;
    }

    public int getDebut() {
        return this.debut;
    }

    public int getEpaisseur() {
        return this.epaisseur;
    }

    public void setEpaisseur(int e) {
        this.epaisseur=e;
    }

    public int getLongueurCoteBord() {
        return this.longueurCoteBord;
    }

    public int getPrix() {
        return this.prix;
    }

}
