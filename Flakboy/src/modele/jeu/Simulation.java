/*
 * Experience.java
 *
 * Created on 16 f�vrier 2012, 12:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modele.jeu;


import interfaces.Observateur;
import outils.Dimension;


import java.util.ArrayList;
import modele.FormeFixe.*;
import outils.Bord1;
import outils.Geometrie;
import outils.Trajectoire;


/**
 *
 * @author mariannesimonot
 */
public class Simulation {
	private Dimension dimensionTerrain;

	private ArrayList<Arme> listeArmes;

	private ArrayList<FormeFixe> limites;
	private FB flackBoy;

        private MurDroit murDroit;
        private Sol sol;
        private Plafond plafond;
        private MurGauche murGauche;

        private ArrayList<Observateur> listeObs;

	/**
	 * Creates a new instance of Experience
	 */

	public Simulation(ArrayList<Arme> armesPlacees,Dimension dim) {
            this.dimensionTerrain=dim;
            this.flackBoy=new FB(new Trajectoire(600, 600, 30, 0)); // vitesse = 300 max
            this.listeArmes=armesPlacees;
            
            this.murDroit=new MurDroit(dim);
            this.murGauche=new MurGauche(dim);
            this.plafond= new Plafond(dim);
            this.sol= new Sol(dim);

            this.limites=new ArrayList<FormeFixe>();
            this.limites.add(this.sol);
            this.limites.add(this.murDroit);
            this.limites.add(this.murGauche);
            this.limites.add(this.plafond);

            this.listeObs = new ArrayList<Observateur>();
	}


	public Dimension getDimensionTerrain() {
		return this.dimensionTerrain;
	}


	public FB getFlackBoy() {
		return this.flackBoy;
	}

        public ArrayList<Arme> getListeArmes() {
            return this.listeArmes;
        }

	/*
	 * Fait se d�placer ce qui se d�place dans le terrain puis g�re les cons�quences de ce d�placement.
	 */
	public void unDeplacement(){
            this.flackBoy.avancer();


            /*System.out.println("ANGLE = "+this.flackBoy.getTrajectoire().angleActuelle());
            System.out.println("VITESSE = "+this.flackBoy.getTrajectoire().vitesseActuelle());
            System.out.println("X = "+this.flackBoy.getX());
            System.out.println("Y = "+this.flackBoy.getY());*/

            // TODO : replacement de FB sur le terrain
            /*if (this.flackBoy.getX()<5) {
                this.flackBoy.setX(2);
            } else if(this.flackBoy.getX()+this.flackBoy.getLargeur()>this.dimensionTerrain.getLargeur()){
                this.flackBoy.setX(this.dimensionTerrain.getLargeur()-2);
            }

            if (this.flackBoy.getY()<5+32) {
                this.flackBoy.setY(2+32);
            } else if(this.flackBoy.getY()+this.flackBoy.getHauteur()>this.dimensionTerrain.getHauteur()){
                this.flackBoy.setY(this.dimensionTerrain.getHauteur()-2-32);
            }*/

            // test avec la liste les armes
            /*for (int j=0 ; j<this.listeArmes.size();j++) {
                  if (this.listeArmes.get(j).utilisable()) {
                    if (this.listeArmes.get(j).enCollision(this.flackBoy)) {
                        System.out.println("\nARME : BOUM !");
                        System.out.println("ANGLE ARME = "+this.flackBoy.getTrajectoire().angleActuelle());
                        System.out.println("VITESSE ARME = "+this.flackBoy.getTrajectoire().vitesseActuelle());
                        System.out.println("X ARME = "+this.flackBoy.getX());
                        System.out.println("Y ARME = "+this.flackBoy.getY());    
                        this.listeArmes.get(j).collision(this.flackBoy, this.listeArmes.get(j).getBord());
                    }
                    else {
                        if(this.listeArmes.get(j) instanceof ArmeDeclenchable){
                            ArmeDeclenchable armeD=(ArmeDeclenchable)this.listeArmes.get(j);
                            if(armeD.sousPortee(this.flackBoy)){
                                System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                                armeD.grossirForme();
                            }
                        }
                    }
                }
            }*/
            
            for (int j=0 ; j<this.listeArmes.size();j++) {
              if (this.listeArmes.get(j).utilisable()) {
                
                if(this.listeArmes.get(j) instanceof ArmeDeclenchable){
                    ArmeDeclenchable armeD=(ArmeDeclenchable)this.listeArmes.get(j);
                    if(armeD.sousPortee(this.flackBoy)){
                        armeD.grossirForme();
                        if(armeD.enCollision(this.flackBoy)){
                            armeD.collision(this.flackBoy, armeD.getBord());
                            armeD.utiliser();
                        }
                    }
                    else{
                        armeD.degrossirForme();
                    }

                }

                else{
                    if (this.listeArmes.get(j).enCollision(this.flackBoy)) {

                        System.out.println("\nARME : BOUM !");
                        System.out.println("ANGLE ARME = "+this.flackBoy.getTrajectoire().angleActuelle());
                        System.out.println("VITESSE ARME = "+this.flackBoy.getTrajectoire().vitesseActuelle());
                        System.out.println("X ARME = "+this.flackBoy.getX());
                        System.out.println("Y ARME = "+this.flackBoy.getY());  

                        this.listeArmes.get(j).collision(this.flackBoy, this.listeArmes.get(j).getBord());
                        this.listeArmes.get(j).utiliser();
                    }
                }
              }

              else{
                  this.listeArmes.remove(this.listeArmes.get(j));
              }

            }


            // test avec la liste des murs
            for (int i=0 ; i<this.limites.size();i++) {
                if (this.limites.get(i).enCollision(this.flackBoy)) {
                    System.out.println("\nMUR : BOUM !");
                    System.out.println("ANGLE = "+this.flackBoy.getTrajectoire().angleActuelle());
                    System.out.println("VITESSE = "+this.flackBoy.getTrajectoire().vitesseActuelle());
                    System.out.println("X = "+this.flackBoy.getX());
                    System.out.println("Y = "+this.flackBoy.getY());
                    this.limites.get(i).collision(this.flackBoy, this.limites.get(i).getBord());
                }
            }

	}

        public void ajouterObs(Observateur obs) {

            this.listeObs.add(obs);
        }

        public void notifierObs() {

            for (int i=0; i<this.listeObs.size();i++) {
                this.listeObs.get(i).actualiser();
            }
        }

        
        
}
