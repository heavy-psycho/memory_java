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

	// constructeur de PanneauDeCartes
	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes,int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		this.setLayout(layout);
		this.setTitle("GRILLES");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

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
		private Color caract;

		public carte(Carte carte){
			super("");
			this.name="";
			this.caract=(Color) carte.getCaract();
			this.setBackground(caract);
		}
		
	}


}
