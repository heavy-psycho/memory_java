import java.awt.*;


public abstract class GenerateurDeCartes {

	private String nom;

	public String getNom(){
		return this.nom;
	}

	public abstract Carte genereUneCarte();
	public abstract int nombreDeCartesDifferentes();

	public Carte[] genereCartes(int n){
		Carte[] a = new Carte[n];
		return a;

	}

	public Carte[] generePairesDeCartesMelangees(int n){
		Carte[] a = new Carte[n];
		return a;
	}


	public class GenerateurDeCartesCouleur extends GenerateurDeCartes{



		public Carte genereUneCarte(){
			Carte b;
			b= new CarteCouleur(true,Color.BLACK);
			return b;
		}

		public int nombreDeCartesDifferentes(){
			int a=0;
			return a;
		}


	}

}
