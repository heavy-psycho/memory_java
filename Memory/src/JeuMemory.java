public class JeuMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Carte[] a = new CarteCouleur[8];
		GenerateurDeCartesCouleur gen = new GenerateurDeCartesCouleur();
		a=gen.generePairesDeCartesMelangees(4);
		PanneauDeCartes b = new PanneauDeCartes(4,4,a,1,1);
	}
}
