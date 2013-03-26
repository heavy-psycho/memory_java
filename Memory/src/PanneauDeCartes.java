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
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes, int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		this.setLayout(layout);



	}

	public class cartePack extends JButton{


	}


}
