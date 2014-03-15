/*
 * vueJeu.java
 *
 * Created on 6 mars 2012, 17:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package vue.vueBasique;

import interfaces.Observateur;
import java.awt.BorderLayout;
import modele.jeu.Jeu;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mariannesimonot
 */
public class vueJeu {

    private Jeu jeu;
    private JFrame fenetre = new JFrame("FlakBoy");
    private JPanel panelMain;
    private Dessin1 panelGaucheDessin; // panel de droite
    private PanelMenu panelDroiteMenu; // panel de gauche
    
    // TODO : Extends en JFrame
    public vueJeu(Jeu j) {

        this.jeu = j;

        // panel qui contient les 2 panels
        this.panelMain = new JPanel(new BorderLayout());

        // panel de gauche
        this.panelGaucheDessin = new Dessin1(this.jeu.getUneSimulation());

        // panel de droite
        this.panelDroiteMenu = new PanelMenu(j,panelGaucheDessin);

        //this.panelMenu.setSize(400, 800);

        fenetre.setSize(new Dimension(jeu.getDimensionTerrain().getLargeur() + 400, jeu.getDimensionTerrain().getHauteur()));
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null);

        fenetre.setContentPane(this.panelMain);

        this.panelMain.add(BorderLayout.WEST, panelGaucheDessin);
        this.panelMain.add(BorderLayout.EAST, panelDroiteMenu);

        fenetre.setBackground(Color.WHITE);
        fenetre.setVisible(true);
    }
    
     /*
     * cette methode devra dispara�tre quand vous aurez mis en place les observateurs.
     * En particulier, le while n'aura plus rien � faire dans la vue.
     */
    
  }