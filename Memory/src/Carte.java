import java.awt.*;
import java.util.Random;
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
		super();
		this.face=sens;

	}

	/**
	 * Methode static qui melange les Cartes d'un tableau de cartes
	 * @param cartes
	 */
	public static void melangeCartes(Carte[] cartes){

		Random random = new Random();
		random.nextInt();

		for (int i = 0; i < cartes.length; i++) {
			int change = i + random.nextInt(cartes.length - i);
			swap(cartes, i, change);
		}
	}

	private static void swap(Object[] a, int i, int change) {
		Object temp = a[i];
		a[i] = a[change];
		a[change] = temp;
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
		this.repaint();
	}

	public void cache(){
		this.face=false;
		this.repaint();
	}

	public void retourne(){
		this.face=!this.face;
		this.repaint();
	}

	public void paintVerso(Graphics2D g){
		g.fillRect(0,0,getWidth(),getWidth());
	}

	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g; 
		if(this.estCachee() == true){
			this.paintVerso(g2d);
		}else{
			this.paintRecto(g2d);
		}



	}


	public abstract Object duplique();
	public abstract void paintRecto(Graphics2D g);
	public abstract boolean rectoIdentique(Carte s);
	public abstract Object getCaract();


}
