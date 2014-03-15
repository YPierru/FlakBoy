 /*
 * Jeu.java
 *
 * Created on 6 mars 2012, 15:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package modele.jeu;

import outils.Dimension;
import java.util.ArrayList;
import modele.FormeFixe.Arme;
import modele.FormeFixe.armeDeclenchables.Pique;
import modele.FormeFixe.armesConcretes.Eksasaute;
import modele.FormeFixe.armesConcretes.Mine;
import outils.Bord1;
import vue.vueBasique.vueJeu;

/**
 * C'est ici que l'on g�rera les differentes actions du jeu : acheter placer d�placer vendre des armes 
 * et lancement d'une simulation. 
 * @author mariannesimonot
 */
public class Jeu {

    private Dimension dimensionTerrain;
    private ArrayList<Arme> armesPlacees;
    private int scoreCourant;
    private int argent;
    private Simulation uneSimulation;
    private Eksasaute eksasauteBas;
    private Eksasaute eksasauteGauche;
    private Eksasaute eksasauteDroit;
    private Eksasaute eksasauteHaut;
    private Mine mineBas;
    private Pique piqueDroit;
    private Pique piqueGauche;

    /** Creates a new instance of Jeu */
    public Jeu(int hauteur, int largeur, int argent) {
        this.armesPlacees = new ArrayList<Arme>();
        this.dimensionTerrain = new Dimension(hauteur, largeur);
        this.argent = argent;

        this.piqueDroit = new Pique(Bord1.droit, 400, this.dimensionTerrain);
        this.piqueGauche = new Pique(Bord1.gauche, 400, this.dimensionTerrain);

        /// armes pour tester
        this.eksasauteBas = new Eksasaute(Bord1.bas, 100, this.dimensionTerrain);
        this.eksasauteDroit = new Eksasaute(Bord1.droit, 400, this.dimensionTerrain);
        this.eksasauteGauche = new Eksasaute(Bord1.gauche, 400, this.dimensionTerrain);
        this.eksasauteHaut = new Eksasaute(Bord1.haut, 5, this.dimensionTerrain);

        this.mineBas = new Mine(Bord1.bas, 500, this.dimensionTerrain);

        this.armesPlacees.add(this.piqueDroit);
        //this.armesPlacees.add(this.piqueGauche);

        this.armesPlacees.add(this.eksasauteBas);
        //this.armesPlacees.add(this.eksasauteDroit);
        //this.armesPlacees.add(this.eksasauteGauche);
        //this.armesPlacees.add(this.eksasauteHaut);

        this.armesPlacees.add(this.mineBas);
    }

    public void go() {

        while (!fini()) {
            this.getUneSimulation().unDeplacement();
            this.getUneSimulation().notifierObs();

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // cas permettant de finir la partie
    public boolean fini() {

        return (this.getUneSimulation().getFlackBoy().getY() == 116 && this.getUneSimulation().getFlackBoy().getTrajectoire().vitesseActuelle() < 4);
 
    }

    public Dimension getDimensionTerrain() {
        return dimensionTerrain;
    }

    public void initSimulation() {
        this.uneSimulation = new Simulation(this.armesPlacees, this.dimensionTerrain);
    }

    public Simulation getUneSimulation() {
        return uneSimulation;
    }

    public int getScoreCourant() {

        return this.scoreCourant;
    }

    public void scoreAugmente(int points) {
        this.scoreCourant += points;
    }

    public int getArgent() {

        return this.argent;
    }

    // le prix doit etre un int positif
    public void payeArme(int prix) {
        this.argent -= prix;
    }
}
