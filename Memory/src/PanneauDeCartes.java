import java.awt.Color;
import java.awt.Component;
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
		Carte a1 = new CarteCouleur(false,Color.BLACK);
		Carte a2 = new CarteCouleur(false,Color.BLUE);
		Carte a3 = new CarteCouleur(false,Color.RED);
		Carte a4 = new CarteCouleur(false,Color.YELLOW);
		Carte a5 = new CarteCouleur(false,Color.WHITE);
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
		myFrame.setLayout(layout);


		createButton();

		for(int i=0;i<cartes.length;i++){
			myFrame.add(cartes[i]);
			cartes[i].repaint();
		}
		
		
		//layout.addLayoutComponent("ahaha");
		
		
		myFrame.add(bouton);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createCarte(Carte carte){
		
		class switchColorListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				System.out.println("pffff");
			}
			
		}
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
