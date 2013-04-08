import java.awt.Color;
import java.awt.Graphics2D;

	public class CarteMot extends Carte{

		/**
		 * 
		 */
		private static final long serialVersionUID = 3258550638779901058L;
		private String name;

		public CarteMot(boolean sens,String name){
			super(sens);
			this.name=name;
		}

		public CarteMot(CarteMot s){
			super(s.estMontree());
			this.name=s.name;
		}


		public void paintRecto(Graphics2D g){
			int x = 0;
			int y = 0;
			g.drawString(this.name,0,0);
			g.setColor(Color.white);
			g.fillRect(x,y,getWidth(),getHeight());
			
		}

		public Object getCaract(){
			return this.name;
		}


		/**
		 * Methode qui retourne la donn�e caract�ristique de l'�l�ment
		 * @param s la carte en question
		 */
		public boolean rectoIdentique(Carte s){
			if(this.name==s.getCaract()){
				return true;
			}else{
				return false;
			}
		}

		public String toString(){
			return "Cartename: "+this.name;
		}
		
		public boolean equals(Object obj){
			if(this.name==((CarteMot) obj).getCaract()){
				return true;
			}else{
				return false;
			}
		}

		public Object duplique(){
			CarteMot a = new CarteMot(this);
			return a;
		}

	}

