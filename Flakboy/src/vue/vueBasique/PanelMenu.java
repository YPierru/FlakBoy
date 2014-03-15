/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.vueBasique;

import interfaces.Observateur;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.FormeFixe.armesConcretes.Eksasaute;
import modele.jeu.Jeu;
import outils.Bord1;
import outils.Para;

/**
 *
 * @author Fraktur
 */
public class PanelMenu extends JPanel implements Observateur {

    private Jeu jeu;
    private Dessin1 panelDessin;
    private JPanel panelArgent;
    private JLabel affichageArgent;

    private JPanel panelArmes;
    private JLabel affichageArmes;

    private JButton boutonArmeEksasaute;
    private JButton boutonArmeMine;

    private JPanel panelScore;
    private JLabel affichageScore;

    private JButton boutonGo;


    public PanelMenu(Jeu j, Dessin1 panelGauche) {

        this.jeu = j;
        this.panelDessin = panelGauche;

        this.setLayout(new GridLayout(3, 1));

        // Menu Argent
        this.panelArgent = new JPanel(new GridLayout(2, 1));

        this.add(this.panelArgent);

        this.affichageArgent = new JLabel("" + this.jeu.getArgent());

        this.panelArgent.add(new JLabel("Argent :"));
        this.panelArgent.add(affichageArgent);

        // Menu Armes
        this.panelArmes = new JPanel(new GridLayout(3, 1));

        this.add(this.panelArmes);

        this.boutonArmeEksasaute = new JButton("Eksasaute");
        this.boutonArmeEksasaute.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                panelDessin.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseMoved(MouseEvent e) {
                        System.out.println("mouse moved");
                    }

                    /**
                     * Méthode appelée lors du clic de souris
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        int x = e.getX();
                        int y = e.getY();

                        Eksasaute eksasaute = null;

                        // ajoute les armes dans la listes des armes pour le sol
                        if (y >= jeu.getDimensionTerrain().getHauteur() - Para.EPAISSEUR_MUR - Para.MYSTERE_GRAPH && y <= jeu.getDimensionTerrain().getHauteur()) {
                            eksasaute = new Eksasaute(Bord1.bas, x, jeu.getDimensionTerrain());
                        } else if (y >= 0 && y <= Para.EPAISSEUR_MUR) { // pour le plafond
                            eksasaute = new Eksasaute(Bord1.haut, x, jeu.getDimensionTerrain());
                        } else if (x >= 0 && x <= Para.EPAISSEUR_MUR) { // pour le mur gauche
                            eksasaute = new Eksasaute(Bord1.gauche, jeu.getDimensionTerrain().getHauteur() - Para.MYSTERE_GRAPH - y, jeu.getDimensionTerrain());
                        } else if (x >= jeu.getDimensionTerrain().getLargeur() - Para.EPAISSEUR_MUR && x <= jeu.getDimensionTerrain().getLargeur()) { // pour le mur droit
                            eksasaute = new Eksasaute(Bord1.droit, jeu.getDimensionTerrain().getHauteur() - Para.MYSTERE_GRAPH - y, jeu.getDimensionTerrain());
                        }

                        // si l'utilisateur a cliqué à un endroit correcte
                        if (eksasaute != null) {
                            if (eksasaute.getPrix() < jeu.getArgent()) {
                                jeu.payeArme(eksasaute.getPrix());
                                jeu.getUneSimulation().getListeArmes().add(eksasaute);
                            } else {
                                System.out.println("NON");
                            }
                        }
                    }

                    @Override
                    public void mouseDragged(MouseEvent e) {
                        System.out.println("mouse Dragged");
                    }

                    /**
                     * Méthode appelée lors du survol de la souris
                     */
                    public void mouseEntered(MouseEvent event) {
                    }

                    /**
                     * Méthode appelée lorsque la souris sort de la zone du bouton
                     */
                    public void mouseExited(MouseEvent event) {
                    }

                    /**
                     * Méthode appelée lorsque l'on presse le clic gauche de la souris
                     */
                    public void mousePressed(MouseEvent event) {
                    }

                    /**
                     * Méthode appelée lorsque l'on relâche le clic de souris
                     */
                    public void mouseReleased(MouseEvent event) {
                    }
                });
            }
        });

        this.boutonArmeMine = new JButton("Mine");

        this.panelArmes.add(new JLabel("Armes :"));
        this.panelArmes.add(this.boutonArmeEksasaute);
        this.panelArmes.add(this.boutonArmeMine);

        // Menu Score
        this.panelScore = new JPanel(new GridLayout(2, 1));

        this.add(this.panelScore);

        this.affichageScore = new JLabel(this.jeu.getScoreCourant() + " / " + Para.SCORE_OBJECTIF);

        this.panelScore.add(new JLabel("Score :"));
        
        this.boutonGo = new JButton("GO");
        this.boutonGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new playAnimation());
                t.start();

            }
        });

        this.panelScore.add(affichageScore);
        this.panelScore.add(boutonGo);

        // ajoute cet affichage à la liste d'observateur
        this.jeu.getUneSimulation().ajouterObs(this);
    }

    // Observateur
    public void actualiser() {

        this.affichageArgent.setText("" + this.jeu.getArgent());

        this.affichageScore.setText(this.jeu.getScoreCourant() + " / " + Para.SCORE_OBJECTIF);
    }

    // TODO : Transformer bouton GO en STOP
    private class playAnimation implements Runnable {

        public void run()  {
            jeu.go();
        }

    }

}
