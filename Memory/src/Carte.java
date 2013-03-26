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
			int a = cartes.length+1;
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
		return this.face;
	}

	/**
	 * Méthode qui retourne si la carte est cachée ou non
	 * @return true si la carte est face verso
	 */
	public boolean estCachee(){
		return !this.face;
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
		g.fillRect(0,0,getWidth(),getHeight());
	}

	protected void paintComponent(Graphics2D g){
			if(estCachee() == true){
				paintVerso(g);
			}
			else paintRecto(g);
	}


	public abstract Object duplique();
	public abstract void paintRecto(Graphics2D g);
	public abstract boolean rectoIdentique(Carte s);
	public abstract Object getCaract();




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
