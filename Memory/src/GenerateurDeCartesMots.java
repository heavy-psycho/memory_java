import java.awt.Color;

public class GenerateurDeCartesMots extends GenerateurDeCartes{
	
	private String[] emotionsf = new String[]{"Tristesse","Pitié","Défaite","Dépression","Accablement","Découragement","Négligence","Égarement","Mécontentement","Souffrance"};
	private String[] emotions = new String[]{"Tristesse","Pitié","Défaite","Dépression","Accablement","Découragement","Négligence","Égarement","Mécontentement","Souffrance"};

	public int nombreDeCartesDifferentes(){
		return emotions.length;
	}
	
	public Carte genereUneCarte(){
		int indice =(int) (Math.random()*(emotions.length-1));	
		Carte a = new CarteMot(false,emotions[indice]);//METTRE A FALSE !!!!! //TODO
		String[] b = new String[emotions.length-1];
		if(b.length == 0){ //si il n'y a plus de couleur non utilisée, on remet toutes les couleurs possibles, nous aurons donc des couleurs en double.
			b = new String[emotionsf.length];
			emotions = new String[emotionsf.length];
			for(int k=0; k<b.length ;k++){
				b[k]=emotionsf[k];
				emotions[k]=emotionsf[k];
			}
		}
		else{ // si il reste encore au moins une couleur non utilisée, on enlève la couleur utilisée précédemment
			for(int i=0; i<b.length ;i++){
				if(i>=indice){
					b[i]=emotions[i+1];
				}
				else { b[i]=emotions[i];
				}
			}
			emotions = new String[b.length];
			for(int j=0; j<b.length ;j++){	
				emotions[j]=b[j];
			}
		}

		return a;
	}
}
