import java.awt.Color;
import java.awt.Graphics2D;

	public class CarteCouleur extends Carte{

		/**
		 * 
		 */
		private static final long serialVersionUID = 3258550638779901058L;
		private Color couleur;

		public CarteCouleur(boolean sens,Color couleur){
			super(sens);
			this.couleur=couleur;
		}

		public CarteCouleur(CarteCouleur s){
			super(s);
			this.couleur=s.couleur;
		}


		public void paintRecto(Graphics2D g){
			int x = 0;
			int y = 0;
			g.fillRect(x,y,getWidth(),getHeight());
			
		}

		public Object getCaract(){
			return this.couleur;
		}


		/**
		 * Methode qui retourne la donnée caractéristique de l'élément
		 * @param s la carte en question
		 */
		public boolean rectoIdentique(Carte s){
			if(this.couleur==s.getCaract()){
				return true;
			}else{
				return false;
			}
		}

		public String toString(){
			return "CarteCouleur: "+this.couleur;
		}

		public Object duplique(){
			CarteCouleur a = new CarteCouleur(this);
			return a;
		}


	}

