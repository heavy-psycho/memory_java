
public abstract class GenerateurDeCartes {

	private String nom;

	public String getNom(){
		return this.nom;
	}

	public abstract Carte genereUneCarte();
	public abstract int nombreDeCartesDifferentes();

	
	public Carte[] genereCartes(int n){
		Carte[] a = new Carte[n];
		for(int i=0; i<n; i++){
			a[i]= genereUneCarte();
		}
		return a;
	}

	public Carte[] generePairesDeCartesMelangees(int n){
		Carte[] cartes = new Carte[2*n];
		for(int i=0; i<n; i++){
			cartes[i]= genereUneCarte();
			Carte temp=(Carte) cartes[i].duplique();
			cartes[n+i] = temp;
		}
		Carte.melangeCartes(cartes);
		return cartes;
	}
}
