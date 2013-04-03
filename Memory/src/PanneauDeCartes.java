import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanneauDeCartes extends JPanel implements MouseListener{


	private static final long serialVersionUID = 5191665466430373194L;

	JFrame myFrame= new JFrame();
	private Carte[] tabCartes;

	// constructeur de PanneauDeCartes
	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes,int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		myFrame.setLayout(layout);
		myFrame.setTitle("OMG OMG");

		//this.addMouseListener(this);

		tabCartes=cartes;

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		myFrame.setSize(width,height);

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//this.setLocationRelativeTo(null);

		//CarteCouleur[] compil= new CarteCouleur[cartes.length];

		for(int i=0;i<cartes.length;i++){
			myFrame.add(cartes[i]);
			cartes[i].addMouseListener(this);
		}


		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static int nbCarteRetourner(Carte[] cartes){
		int nb=0;
		for(int i=0;i<cartes.length;i++){
			if(cartes[i].estMontree()){
				nb++;
			}
		}
		return nb;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Carte a = (Carte)e.getSource();
		a.retourne();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




}

