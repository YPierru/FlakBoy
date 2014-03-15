/*
 *
 * Created on 16 fevrier 2012, 12:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package vue.vueBasique;

import interfaces.Observateur;
import modele.jeu.Simulation;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JPanel;
import outils.Para;

/**
 *
 * @author mariannesimonot
 */
public class Dessin1 extends JPanel implements Observateur {

    private Simulation uneSimulation;

    public Dessin1(Simulation te) {
        this.uneSimulation = te;
        this.setPreferredSize(new Dimension(this.uneSimulation.getDimensionTerrain().getLargeur(), this.uneSimulation.getDimensionTerrain().getHauteur()));
    
        this.uneSimulation.ajouterObs(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        // couleur de fond pour le rectangle qui est affiche pour
        // ne pas avoir de trainee mais un objet qui bouge
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        //on dessine flakboy
        g.setColor(Color.RED);
        g.fillOval((int)this.uneSimulation.getFlackBoy().getX(), (int)(this.uneSimulation.getDimensionTerrain().getHauteur() - this.uneSimulation.getFlackBoy().getY()), this.uneSimulation.getFlackBoy().getLargeur(), this.uneSimulation.getFlackBoy().getHauteur());

        // coloration du mur gauche
        g.setColor(Color.BLUE);
        g.fillRect(0,0, 5,this.uneSimulation.getDimensionTerrain().getLargeur());
        //System.out.println("COO DESSIN MUR GAUCHE");
        //System.out.println(""+0+""+0+""+20+""+this.uneSimulation.getDimensionTerrain().getLargeur());

        // coloration du mur droit
        g.setColor(Color.BLUE);
        g.fillRect(this.uneSimulation.getDimensionTerrain().getLargeur()-Para.EPAISSEUR_MUR,0,Para.EPAISSEUR_MUR,this.uneSimulation.getDimensionTerrain().getHauteur());
        //System.out.println("COO DESSIN MUR DROIT");
        //System.out.println(""+(this.uneSimulation.getDimensionTerrain().getLargeur()-20)+""+0+""+20+""+this.uneSimulation.getDimensionTerrain().getHauteur());

        // coloration du plafond
        g.setColor(Color.BLUE);
        g.fillRect(0,0, this.uneSimulation.getDimensionTerrain().getLargeur(),Para.EPAISSEUR_MUR);
        //System.out.println("COO DESSIN PLAFOND");
        //System.out.println(""+0+""+0+""+this.uneSimulation.getDimensionTerrain().getLargeur()+""+20);


        // coloration du sol
        g.setColor(Color.BLUE);
        g.fillRect(0,this.uneSimulation.getDimensionTerrain().getHauteur()-Para.MYSTERE_GRAPH-Para.EPAISSEUR_MUR,this.uneSimulation.getDimensionTerrain().getLargeur(),Para.EPAISSEUR_MUR);
        //System.out.println("COO DESSIN SOL");
        //System.out.println(""+0+""+(this.uneSimulation.getDimensionTerrain().getHauteur()-50)+""+this.uneSimulation.getDimensionTerrain().getLargeur()+""+20);

//        x = super.getTerrain().getLargeur() - super.getEpaisseur() - 5;
//        y = super.getDebut()+132;
//        largeur = super.getEpaisseur();
//        hauteur = super.getLongueurCoteBord();
//        
//        x = (int)this.getForme().getX()-100;
//        y = (int)this.getForme().getY()+100;
//        largeur = (int)this.getForme().getWidth()+100;
//        hauteur = (int)this.getForme().getHeight()+100;
        g.setColor(Color.MAGENTA);
        g.drawRect(this.uneSimulation.getDimensionTerrain().getLargeur()-110-Para.EPAISSEUR_MUR, this.uneSimulation.getDimensionTerrain().getHauteur()-450-Para.MYSTERE_MOTEUR, 110, 200);
        g.drawRect(Para.EPAISSEUR_MUR+110, this.uneSimulation.getDimensionTerrain().getHauteur()-450-Para.MYSTERE_MOTEUR, 110, 200);
        //System.out.println("\n$$$$$$$$$$$$$$$X = "+(this.uneSimulation.getDimensionTerrain().getLargeur()-110-5)+" Y = "+(this.uneSimulation.getDimensionTerrain().getHauteur()-450-Para.MYSTERE_GRAPH)+" LARGEUR = "+110+" EPAISSEUR = "+200);
        
        // boucle qui va dessiner les armes dynamiquement
        for (int i=0 ; i<this.uneSimulation.getListeArmes().size() ; i++) {


            //Couleur differente selon arme
            if(this.uneSimulation.getListeArmes().get(i).getNom().equals("Mine")) {
                g.setColor(Color.BLACK);
            } else if(this.uneSimulation.getListeArmes().get(i).getNom().equals("Eksasaute")){
                g.setColor(Color.PINK);
            } else if(this.uneSimulation.getListeArmes().get(i).getNom().equals("Pique")){
                g.setColor(Color.GREEN);
            }

            // pour savoir sur quel mur est posée l'amre
            switch (this.uneSimulation.getListeArmes().get(i).getBord()) {
                case haut:
                    g.fillRect(this.uneSimulation.getListeArmes().get(i).getDebut(),Para.EPAISSEUR_MUR,this.uneSimulation.getListeArmes().get(i).getLongueurCoteBord(),this.uneSimulation.getListeArmes().get(i).getEpaisseur());
                break;
                case bas:;
                    g.fillRect(this.uneSimulation.getListeArmes().get(i).getDebut(),(this.uneSimulation.getDimensionTerrain().getHauteur()-Para.MYSTERE_GRAPH-this.uneSimulation.getListeArmes().get(i).getEpaisseur()-Para.EPAISSEUR_MUR),this.uneSimulation.getListeArmes().get(i).getLongueurCoteBord(),this.uneSimulation.getListeArmes().get(i).getEpaisseur());
                break;
                case droit:
                    g.fillRect((this.uneSimulation.getDimensionTerrain().getLargeur()-this.uneSimulation.getListeArmes().get(i).getEpaisseur()-Para.EPAISSEUR_MUR),this.uneSimulation.getDimensionTerrain().getHauteur()-this.uneSimulation.getListeArmes().get(i).getDebut()-Para.MYSTERE_MOTEUR,this.uneSimulation.getListeArmes().get(i).getEpaisseur(),this.uneSimulation.getListeArmes().get(i).getLongueurCoteBord());
                break;
                case gauche:
                    g.fillRect(Para.EPAISSEUR_MUR,this.uneSimulation.getDimensionTerrain().getHauteur()-this.uneSimulation.getListeArmes().get(i).getDebut()-Para.MYSTERE_MOTEUR,this.uneSimulation.getListeArmes().get(i).getEpaisseur(),this.uneSimulation.getListeArmes().get(i).getLongueurCoteBord());
                break;
                default:
                    System.out.println("BUG OMG !");
            }
        }



    }

    public void actualiser() {

        this.repaint();
    }
}