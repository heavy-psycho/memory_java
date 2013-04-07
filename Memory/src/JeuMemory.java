public class JeuMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateurDeCartesCouleur gen = new GenerateurDeCartesCouleur();
		Carte[] a=gen.generePairesDeCartesMelangees(4);
		PanneauDeCartes b = new PanneauDeCartes(4,4,a,1,1);
	}
}
