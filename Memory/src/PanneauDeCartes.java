import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanneauDeCartes extends JFrame{

	JFrame myFrame= new JFrame();
	JButton bouton;

	public static void main(String[] args){
		Carte[] cartes = new Carte[5];
		int nb = 0;
		String nom;
		
		for(int i=0;i<cartes.length;i++){
			nom="Carte"+nb;
			Carte a = new CarteCouleur(true,Color.BLACK);
			nb++;
		}
		
		
	}

	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes, int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		myFrame.setLayout(layout);
		JButton a = new JButton("ahaha");


		createButton();

		for(int i=0;i<cartes.length;i++){

		}


		layout.addLayoutComponent("ahaha",a);
		myFrame.setVisible(true);
		myFrame.add(bouton);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createButton(){
		bouton = new JButton("Test");

		class AddInterestListener implements ActionListener{

			public void actionPerformed(ActionEvent event){
				System.out.println("POINTLESS");
			}
		}
		ActionListener listener = new AddInterestListener();
		bouton.addActionListener(listener);
	}
}
