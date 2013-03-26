import java.awt.Color;

public class GenerateurDeCartesCouleur extends GenerateurDeCartes{
		Color[] couleur = new Color[]{Color.red,Color.yellow,Color.pink,
									  Color.cyan,Color.orange,Color.green,
									  Color.blue,Color.magenta};

		public int nombreDeCartesDifferentes(){
			int a=8;
			return a;
		}
		public Carte genereUneCarte(){
			int indice =(int) Math.random()+(couleur.length-1);
			Carte a = new CarteCouleur(false,couleur[indice]);
			return a;
		}
	}
