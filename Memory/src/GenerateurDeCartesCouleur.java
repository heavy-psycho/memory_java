import java.awt.Color;

public class GenerateurDeCartesCouleur extends GenerateurDeCartes{
	
	private Color[] couleur = new Color[]{Color.red,Color.yellow,Color.pink,Color.cyan,Color.orange,Color.green,Color.blue,Color.magenta};
	private Color[] couleurf = new Color[]{Color.red,Color.yellow,Color.pink,Color.cyan,Color.orange,Color.green,Color.blue,Color.magenta};

	public int nombreDeCartesDifferentes(){
		return couleur.length;
	}
	
	public Carte genereUneCarte(){
		int indice =(int) (Math.random()*(couleur.length-1));	
		Carte a = new CarteCouleur(false,couleur[indice]);//METTRE A FALSE !!!!! //TODO
		Color[] b = new Color[couleur.length-1];
		if(b.length == 0){ //si il n'y a plus de couleur non utilis�e, on remet toutes les couleurs possibles, nous aurons donc des couleurs en double.
			b = new Color[couleurf.length];
			couleur = new Color[couleurf.length];
			for(int k=0; k<b.length ;k++){
				b[k]=couleurf[k];
				couleur[k]=couleurf[k];
			}
		}
		else{ // si il reste encore au moins une couleur non utilis�e, on enl�ve la couleur utilis�e pr�c�demment
			for(int i=0; i<b.length ;i++){
				if(i>=indice){
					b[i]=couleur[i+1];
				}
				else { b[i]=couleur[i];
				}
			}
			couleur = new Color[b.length];
			for(int j=0; j<b.length ;j++){	
				couleur[j]=b[j];
			}
		}

		return a;
	}
}
