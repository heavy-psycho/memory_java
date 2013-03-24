import java.awt.*;
import javax.swing.*;

public abstract class Carte extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean face;//true si recto false si verso

	/**
	 * Constructeur de Carte
	 * @param sens => true si recto false si verso
	 */
	protected Carte(boolean sens){
		this.face=sens;
	}

	/**
	 * Methode static qui melange les Cartes d'un tableau de cartes
	 * @param cartes
	 */
	public static void melangeCartes(Carte[] cartes){

	}


	/**
	 * Constructeur qui copie une carte
	 * @param s Carte à copier
	 */
	protected Carte(Carte s){
		this.face=s.face;
	}

	/**
	 * Methode qui retourne si la carte est montree ou non
	 * @return true si la carte est face recto
	 */
	public boolean estMontree(){
		return face;
	}

	/**
	 * Méthode qui retourne si la carte est cachée ou non
	 * @return true si la carte est face verso
	 */
	public boolean estCachee(){
		return !face;
	}

	public void montre(){
		this.face=true;
	}

	public void cache(){
		this.face=false;
	}

	public void retourne(){
		this.face=!this.face;
	}

	public void paintVerso(Graphics2D g){
		getWidth();
		getHeight();
	}

	protected void paintComponent(Graphics g){

	}


	public abstract Object duplique();
	public abstract void paintRecto(Graphics2D g);
	public abstract boolean rectoIdentique(Carte s);
	public abstract Object getCaract();



	public class CarteCouleur extends Carte{

		/**
		 * 
		 */
		private static final long serialVersionUID = 3258550638779901058L;
		private Color couleur;

		public CarteCouleur(boolean sens,Color couleur){
			super(sens);
			this.couleur=couleur;
		}

		public CarteCouleur(CarteCouleur s){
			super(s);
			this.couleur=s.couleur;
		}


		public void paintRecto(Graphics2D g){
			
			
		}

		public Object getCaract(){
			return this.couleur;
		}


		/**
		 * Methode qui retourne la donnée caractéristique de l'élément
		 * @param s la carte en question
		 */
		public boolean rectoIdentique(Carte s){
			if(this.couleur==s.getCaract()){
				return true;
			}else{
				return false;
			}
		}

		public String toString(){
			return "CarteCouleur: "+this.couleur;
		}

		public Object duplique(){
			CarteCouleur a = new CarteCouleur(this);
			return a;
		}


	}

	/*public class CarteMot extends Carte{
		private static final long serialVersionUID = 1L;
		private String mot;

		public CarteMot(boolean sens,String mot){
			super(sens);
			this.mot=mot;
		}

		public CarteMot(Carte s){
			super(s);
		}


		public void paintRecto(){

		}

		public void rectoIdentique(){

		}

		public Object duplique(){
			CarteMot a = new CarteMot(this);
			return a;
		}

		public String toString(){
			return "CarteMot: "+this.mot;
		}
	}*/

	/*public class CarteImage extends Carte{
		private static final long serialVersionUID = 1L;
		private 

		public CarteImage(boolean sens){
			super(sens);
		}

		public CarteImage(Carte s){
			super(s);
		}


		public void paintRecto(){

		}

		public void rectoIdentique(){

		}

		public Object duplique(){
			CarteImage a = new CarteImage(this);
			return a;
		}
	}*/

}
