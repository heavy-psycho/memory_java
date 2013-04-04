import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanneauDeCartes extends JPanel implements MouseListener{


	private static final long serialVersionUID = 5191665466430373194L;

	JFrame myFrame= new JFrame();
	private Carte[] tabCartes;
	private int delaiMauvaisePaire;

	// constructeur de PanneauDeCartes
	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes,int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		myFrame.setLayout(layout);
		myFrame.setTitle("yeah");



		tabCartes=cartes;

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		myFrame.setSize(width,height);



		for(int i=0;i<cartes.length;i++){
			myFrame.add(cartes[i]);
			cartes[i].addMouseListener(this);
		}



		System.out.println(nbCarteRetourne());
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private int nbCarteRetourne(){
		int nb=0;
		for(int i=0;i<tabCartes.length;i++){
			if(tabCartes[i].estMontree()){
				nb++;
			}
		}
		return nb;
	}

	private int indiceCarteRetourne(){
		for(int i=0;i<tabCartes.length;i++){
			if(tabCartes[i].estMontree()){
				return i;
			}
		}
		return -1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Carte a = (Carte)e.getSource();
		if(nbCarteRetourne()==1){
			a.montre();
			if(a.equals(tabCartes[indiceCarteRetourne()])){
				a.montre();
				tabCartes[indiceCarteRetourne()].montre();
			}else{
				//TODO

			}

		}else if(nbCarteRetourne()==0){
			System.out.println("on retourne la carte. 0 retourner");
			a.retourne();
		}


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

