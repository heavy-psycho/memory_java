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
	 * @param s Carte � copier
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
	 * M�thode qui retourne si la carte est cach�e ou non
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
		super.paintComponent(g);
		this.paint((Graphics) g);



	}

	public void paint(Graphics g){
		g.drawString("Hello World !", 50, 50);
		if(this.estCachee() == true){
			this.paintVerso((Graphics2D) g);
		}else{
			this.paintRecto((Graphics2D) g);
		}
	}


	public abstract Object duplique();
	public abstract void paintRecto(Graphics2D g);
	public abstract boolean rectoIdentique(Carte s);
	public abstract Object getCaract();


}
