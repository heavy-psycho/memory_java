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
		GenerateurDeCartes b;
		for(int i=0; i<=1; i++){
			//b.genereUneCarte();
			//a[i]=b;
		}
		return a;
	}

	public Carte[] generePairesDeCartesMelangees(int n){
		Carte[] a = new Carte[n*2];
		return a;
	}
}
