import java.awt.*;
import javax.swing.*;

public abstract class Carte extends JComponent{
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

	}
	
	protected void paintComponent(Graphics g){
		
	}
	
	

	public abstract void paintRecto();
	public abstract void rectoIdentique();



	public class CarteCouleur extends Carte{
		private static final long serialVersionUID = 1L;
		private Color couleur;
		
		public CarteCouleur(boolean sens,Color couleur){
			super(sens);
			this.couleur=couleur;
		}

		public CarteCouleur(CarteCouleur s){
			super(s);
			this.couleur=s.couleur;
		}


		public void paintRecto(){

		}

		public void rectoIdentique(){

		}
		
		public String toString(){
			return "CarteCouleur: "+this.couleur;
		}
	}
	
	public class CarteMot extends Carte{
		private static final long serialVersionUID = 1L;

		public CarteMot(boolean sens){
			super(sens);
		}

		public CarteMot(Carte s){
			super(s);
		}


		public void paintRecto(){

		}

		public void rectoIdentique(){

		}
	}
	
	public class CarteImage extends Carte{
		private static final long serialVersionUID = 1L;

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
	}

}
