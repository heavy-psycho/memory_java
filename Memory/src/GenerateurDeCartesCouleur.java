import java.awt.Color;

public class GenerateurDeCartesCouleur extends GenerateurDeCartes{
	Color[] couleur = new Color[]{Color.red,Color.yellow,Color.pink,
			Color.cyan,Color.orange,Color.green,
			Color.blue,Color.magenta};
	//TODO
	/*public Carte genereUneCarte(){
Carte b;
//TODO b= new CarteCouleur(true,Color.BLACK);
return b;
}*/

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
