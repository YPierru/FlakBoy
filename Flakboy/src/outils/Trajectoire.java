package outils;

/*
 * Trajectoire.java
 *
 * Created on 2 fevrier 2012, 08:24
 *
 * Il faudra sans doute ajouter des methodes dans cette classe.
 */
public class Trajectoire {

        private double abscisse;
        private double ordonnee;
        private double vitesse;
        private double angle;
        private double temps;
        private double GRAVITE=9.81;

    public void setGRAVITE(double GRAVITE) {
        this.GRAVITE = GRAVITE;
    }

        public Trajectoire(double abscisse, double ordonnee, double vitesse, double angle){
            this.abscisse=abscisse;
            this.ordonnee=ordonnee;
            this.vitesse=vitesse;
            this.angle=convertisseurDegRad(angle);
            this.temps=0;
        }

	public void avancer(){
		this.temps++;
	}

	public double abcisseActuelle(){
            return (this.vitesse*Math.cos(this.angle)*(this.temps/50)+this.abscisse);
	}


	public double ordonneeActuelle(){
                return (-GRAVITE/2*(this.temps/50)*(this.temps/50)+this.vitesse*Math.sin(this.angle)*(this.temps/50)+this.ordonnee);
	}

        public double vitesseActuelle(){

            double vitesseAbsc =this.vitesseAbscActuelle();
            double vitesseOrd = this.vitesseOrdActuelle();
            double vitesseFin=Math.sqrt((vitesseAbsc *vitesseAbsc)+(vitesseOrd*vitesseOrd));

            //Vitesse max = 300
            if (vitesseFin>300) {
                vitesseFin=300;
            }

            return vitesseFin;
        }

        public double vitesseAbscActuelle(){
            return this.vitesse * Math.cos(this.angle);
        }

        public double vitesseOrdActuelle(){
            return (-GRAVITE*(this.temps/50))+(this.vitesse * Math.sin(this.angle));
        }

        public double convertisseurDegRad(double angle){
            return (angle/180)*Math.PI;
        }

        public double convertisseurRadDeg(double angle){
            return (angle/Math.PI)*180;
        }

        public double angleActuelle(){
            double vitesseAbsc =this.vitesseAbscActuelle();
            double vitesseOrd = this.vitesseOrdActuelle();
            double a = Math.atan(vitesseOrd/vitesseAbsc);

            if(vitesseAbsc<0){
                if(vitesseOrd<0){
                    a = a-Math.PI;
                }
                else{
                    a = a+Math.PI;
                }
            }

            return convertisseurRadDeg(a);

        }


}
