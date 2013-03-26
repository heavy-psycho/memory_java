import java.awt.Color;
import java.awt.Graphics2D;

public class JeuMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Carte[] a = new CarteCouleur[8];
		a[0]= new CarteCouleur(false,Color.cyan);
		a[1]= new CarteCouleur(false,Color.magenta);
		a[2]= new CarteCouleur(false,Color.pink);
		a[3]= new CarteCouleur(false,Color.yellow);
		a[4]= new CarteCouleur((CarteCouleur) a[0]);
		a[5]= new CarteCouleur((CarteCouleur) a[1]);
		a[6]= new CarteCouleur((CarteCouleur) a[2]);
		a[7]= new CarteCouleur((CarteCouleur) a[3]);
		PanneauDeCartes b = new PanneauDeCartes(2,3,a,3,2);
	}
	

}
