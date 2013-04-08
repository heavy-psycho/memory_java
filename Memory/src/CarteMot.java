import java.awt.Color;
import java.awt.Font;
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
			int y = this.getHeight()/2;
			g.setBackground(Color.GREEN);
			g.setFont(new Font("Serif", Font.BOLD, 24));
			g.setColor(Color.BLACK);
			g.drawString(this.name,x,y);


			
		}

		public Object getCaract(){
			return this.name;
		}


		/**
		 * Methode qui retourne la donnée caractéristique de l'élément
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
			try{
			if(this.name==((CarteMot) obj).getCaract()){
				return true;
			}else{
				
			}
			}catch(ClassCastException evt){
				//nothing todo
			}
			return false;
		}

		public Object duplique(){
			CarteMot a = new CarteMot(this);
			return a;
		}

	}

