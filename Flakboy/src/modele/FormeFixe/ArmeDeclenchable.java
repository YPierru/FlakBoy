/*
 * ArmeDeclenchable.java
 *
 * Created on 28 f���vrier 2012, 12:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modele.FormeFixe;

import java.awt.Rectangle;

import modele.jeu.FB;
import outils.Bord1;
import outils.Dimension;
import outils.Geometrie;
import outils.Para;

/**
 *
 * @author mariannesimonot
 */
public class ArmeDeclenchable extends Arme {

    private int nbUtilisation; // le nombre d'utilisation possible
    private boolean surArme;



    public ArmeDeclenchable(String nom, Bord1 b, int d, int lb, int e, double coeffv, int degat, int prix, int nbu, Dimension te) {

        super(nom, b, d, lb, e, coeffv, d, prix, nbu, te);
        // longueur = 100
        // epaisseur = 10
        // coeffVitesse = 1.8
        // degat = 10
        // nb utilisation = 3

        surArme=true;

        /*this.debut = d;
        this.longueurCoteBord = lb;
        this.epaisseur = e;*/
        this.nbUtilisation = nbu;
        
    }

    @Override
    public Rectangle getForme(){
        int x = 0;
        int y = 0;
        int hauteur = 0;
        int largeur = 0;

        switch (super.getBord()) {
            case haut:
                x=super.getDebut();
                
                break;

            case bas:
                x=super.getDebut();
                y=132+30;
                largeur=super.getLongueurCoteBord();
                hauteur=super.getEpaisseur();
                break;

            case droit:
                x = super.getTerrain().getLargeur() - super.getEpaisseur() - 5;//System.out.println("********* X FORME = "+(super.getTerrain().getLargeur() - super.getEpaisseur() - 5));
                y = super.getDebut()+Para.MYSTERE_MOTEUR; //System.out.println("********* Y FORME = "+(super.getDebut()+132));
                largeur = super.getEpaisseur(); //System.out.println("********* LARGEUR FORME = "+super.getEpaisseur());
                hauteur = super.getLongueurCoteBord(); //System.out.println("********* HAUTEUR FORME = "+super.getLongueurCoteBord());
                break;

            case gauche:
                x=Para.EPAISSEUR_MUR; //System.out.println("$$$$$$$$ X FORME = "+(super.getEpaisseur()+Para.EPAISSEUR_MUR));
                y=super.getDebut()+Para.MYSTERE_MOTEUR; //System.out.println("$$$$$$$$ Y FORME = "+(super.getDebut()+Para.MYSTERE_MOTEUR));
                largeur = super.getEpaisseur(); //System.out.println("$$$$$$$$ LARGEUR FORME = "+super.getEpaisseur());
                hauteur = super.getLongueurCoteBord(); //System.out.println("$$$$$$$$ HAUTEUR FORME = "+super.getLongueurCoteBord());
                break;

            default:
                System.out.println("BUG OMG !");
        }

        return new Rectangle(x, y, largeur, hauteur);
    }

    public Rectangle getPortee(){
        int x = 0;
        int y = 0;
        int hauteur = 0;
        int largeur = 0;

        switch (super.getBord()) {
            case haut:
                break;

            case bas:
                x=super.getDebut();
                y=132+30;
                largeur=super.getLongueurCoteBord();
                hauteur=super.getEpaisseur();
                break;

            case droit:
                x = (int)this.getForme().getX()-100; //System.out.println("********* X PORTEE = "+((int)this.getForme().getX()-100));
                y = (int)this.getForme().getY()+50; //System.out.println("********* Y PORTEE = "+((int)this.getForme().getY()+100));
                largeur = (int)this.getForme().getWidth()+100;//System.out.println("********* LARGEUR PORTEE = "+((int)this.getForme().getWidth()+100));
                hauteur = (int)this.getForme().getHeight()+100;//System.out.println("********* LARGEUR PORTEE = "+((int)this.getForme().getHeight()+100));
                break;

            case gauche:
                x = (int)this.getForme().getX()+100;
                y = (int)this.getForme().getY()+50;
                largeur = (int)this.getForme().getWidth()+100;
                hauteur = (int)this.getForme().getHeight()+100;
                break;

            default:
                System.out.println("BUG OMG !");
        }

        return new Rectangle(x, y, largeur, hauteur);
    }

    public Rectangle grossirForme(){
        if(super.getEpaisseur()<60){
            super.setEpaisseur(super.getEpaisseur()+1);
        }
        return this.getForme();
    }

    public Rectangle degrossirForme(){
        if(super.getEpaisseur()>11){
            super.setEpaisseur(super.getEpaisseur()-1);
        }
        return this.getForme();
    }
//
//    public boolean isDetecte() {
//        return detecte;
//    }
//
//    public void setDetecte(boolean detecte) {
//        this.detecte = detecte;
//    }

    public boolean sousPortee(FB fb){
        return (Geometrie.intersects(fb.getForme(),this.getPortee()));
    }


    @Override
    public Bord1 getBord(){
        return super.getBord();
    }
    
    
    public boolean isSurArme() {
        return surArme;
    }

    public void setSurArme(boolean surArme) {
        this.surArme = surArme;
    }

//
//    @Override
//    public void utiliser(){
//        super.utiliser();
//    }

//    @Override
//    public int getnbUse(){
//        return super.getnbUse();
//    }
	
}
