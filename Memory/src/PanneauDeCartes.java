import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanneauDeCartes extends JFrame{

	JFrame myFrame= new JFrame();
	JButton bouton;
	CarteCouleur a;

	private void fenetre(){
		this.setTitle("Carte");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//On définit le layout à utiliser sur le content pane
		//Trois lignes sur deux colonnes
		this.setLayout(new GridLayout(3, 2));
		//On ajoute le bouton au content pane de la JFrame
		this.getContentPane().add(new JButton("1"));
		this.getContentPane().add(new JButton("2"));
		this.getContentPane().add(new JButton("3"));
		this.getContentPane().add(new JButton("4"));
		this.getContentPane().add(new JButton("5"));
		this.setVisible(true);
	}      

	public static void main(String[] args){
		CarteCouleur[] cartes = new CarteCouleur[5];
		int nb = 0;
		String nom;
		CarteCouleur a1 = new CarteCouleur(false,Color.BLACK);
		CarteCouleur a2 = new CarteCouleur(false,Color.BLUE);
		CarteCouleur a3 = new CarteCouleur(false,Color.RED);
		CarteCouleur a4 = new CarteCouleur(false,Color.YELLOW);
		CarteCouleur a5 = new CarteCouleur(false,Color.WHITE);
		cartes[0]=a1;
		cartes[0]=a2;
		cartes[0]=a3;
		cartes[0]=a4;
		cartes[0]=a5;


		PanneauDeCartes a = new PanneauDeCartes(2,3,cartes,3,2);


	}

	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes, int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		this.setLayout(layout);

		carte[] compil= new carte[cartes.length];
		for(int i=0;i<cartes.length;i++){
			compil[i]=new carte(cartes[i]);
			this.add(compil[i]);
		}


		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class carte extends JButton{
		private String name;
		
		public carte(Carte carte){
			super("");
			this.name="";
		}
		private  
	}


}
