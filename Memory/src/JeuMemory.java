public class JeuMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Carte[] a = new CarteCouleur[8];
		GenerateurDeCartesCouleur gen = new GenerateurDeCartesCouleur();
		a=gen.generePairesDeCartesMelangees(32);
		PanneauDeCartes b = new PanneauDeCartes(4,5,a,5,5);
	}
}
