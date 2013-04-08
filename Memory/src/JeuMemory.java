public class JeuMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(args[0]);
		int nbPairesDeCartes = Integer.parseInt(args[0]);
		int nbRangees = Integer.parseInt(args[1]);
		int nbColonnes = Integer.parseInt(args[2]);
		int delaiAffichageInitial = Integer.parseInt(args[3]);
		int delaiAffichageMauvaisePaire = Integer.parseInt(args[4]);
		GenerateurDeCartesCouleur gen = new GenerateurDeCartesCouleur();
		Carte[] a=gen.generePairesDeCartesMelangees(nbPairesDeCartes);
		PanneauDeCartes b = new PanneauDeCartes(nbRangees,nbColonnes,a,delaiAffichageInitial,delaiAffichageMauvaisePaire);
	}
}
