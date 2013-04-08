public class JeuMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nbPairesDeCartes = 0;
		int nbRangees = 0;
		int delaiAffichageInitial = 0;
		int delaiAffichageMauvaisePaire = 0;
		int nbColonnes = 0;
		int nbArgumentsCorrect=0;
		int theme=0;

		try {
			nbPairesDeCartes = Integer.parseInt(args[0]);
			nbArgumentsCorrect++;
		} catch (NumberFormatException nfe) {
			System.out.println("Veuillez rentrer un nombre correct de paires de cartes." );

		}

		try {
			nbRangees = Integer.parseInt(args[1]);
			nbArgumentsCorrect++;
		} catch (NumberFormatException nfe) {
			System.out.println("Veuillez rentrer un nombre de rangées correct." );

		}
		try {
			nbColonnes = Integer.parseInt(args[2]);
			nbArgumentsCorrect++;
		} catch (NumberFormatException nfe) {
			System.out.println("Veuillez rentrer un nombre correct de colonnes" );

		}
		try {
			delaiAffichageInitial = Integer.parseInt(args[3]);
			nbArgumentsCorrect++;
		} catch (NumberFormatException nfe) {
			System.out.println("Veuillez rentrer un delai d'Affichage initial correct." );

		}
		try {
			delaiAffichageMauvaisePaire = Integer.parseInt(args[4]);
			nbArgumentsCorrect++;
		} catch (NumberFormatException nfe) {
			System.out.println("Veuillez rentrer un délai d'Affichage de mauvaise paire correct." );

		}
		
		try{
			try{
				theme = Integer.parseInt(args[5]);
				nbArgumentsCorrect++;
			}catch(NumberFormatException nfe){
				System.out.println("Veuillez choisir votre thème:\n0Cartes Couleurs\n1: Lettres A ... Z\n2: Noms d'émotions\n3: Images d'animaux\n4: Images de galaxies\n5: Melange des themes 0 à 4");
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Veuillez choisir votre thème:\n0: Cartes Couleurs\n1: Lettres A ... Z\n2: Noms d'émotions\n3: Images d'animaux\n4: Images de galaxies\n5: Melange des themes 0 à 4");

		}
		switch(theme){
			
		}


		if(nbArgumentsCorrect==6){
			GenerateurDeCartesCouleur gen = new GenerateurDeCartesCouleur();
			Carte[] a=gen.generePairesDeCartesMelangees(nbPairesDeCartes);
			PanneauDeCartes b = new PanneauDeCartes(nbRangees,nbColonnes,a,delaiAffichageInitial,delaiAffichageMauvaisePaire);
		}
	}

}
