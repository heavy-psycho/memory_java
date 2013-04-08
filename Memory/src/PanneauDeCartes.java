import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanneauDeCartes extends JPanel implements MouseListener, ActionListener{


	private static final long serialVersionUID = 5191665466430373194L;

	JFrame myFrame= new JFrame();
	private Carte[] tabCartes;
	private Carte[] tabCarteNonTrouve;
	private int nbCarteRetourne=0;
	Timer b;
	Timer c;
	public int[] i=new int[]{-1,-1};
	public int compteur = 0;
	private int nbCoup = 0;

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			tabCartes[i[1]].cache();
			tabCartes[i[0]].cache();
			reiniNbCarteRetourne();
			b.stop();
		}
	};

	ActionListener taskPerformer2 = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			for(int i=0; i<tabCartes.length; i++){
				if(tabCartes[i].estMontree()){
					tabCartes[i].cache();
				}

			}
		}
	};

	private void victoryPanel(){
		myFrame.setVisible(false);
		JFrame victory=new JFrame();
		JLabel victoire=new JLabel("Bravo ! Vous avez réussi en "+nbCoup+" coups !");
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(victoire);
		victory.add(panel,BorderLayout.CENTER);
		victory.setSize(300,200);
		victory.setTitle("Victoire !");
		victoire.setSize(200,20);
		victory.setVisible(true);

		victory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// constructeur de PanneauDeCartes
	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes,int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		
		
		JPanel MyPanel=new JPanel();
		MyPanel.setLayout(layout);
		myFrame.setTitle("Memory par JUBERT Alexandre et COSTANTINI Maël");


		tabCartes=cartes;
		tabCarteNonTrouve = new Carte[tabCartes.length];

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		myFrame.setSize(width,height);

		b = new Timer(delaiAffichageMauvaisePaire, taskPerformer);
		c = new Timer(delaiAffichageInitial, taskPerformer2);


		for(int i=0;i<cartes.length;i++){
			MyPanel.add(cartes[i]);
			cartes[i].addMouseListener(this);
		}


		myFrame.add(MyPanel);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private int nbCarteRetourne(){
		return nbCarteRetourne++;
	}
	private int reiniNbCarteRetourne(){
		return nbCarteRetourne=0;
	}

	private int[] indiceCarteRetourne(){
		i = new int[]{-1,-1};//tableau qui contiendra les deux référence des deux dernières cartes retournées
		for(int u=0;u<i.length;u++){
			for(int o=0; o<tabCartes.length;o++){
				if(tabCartes[o].estMontree()&&tabCarteNonTrouve[o]==null){
					if(o==i[0]){
						tabCarteNonTrouve[o]=tabCartes[o];
						continue;
					}
					else{i[u]=o;
					tabCarteNonTrouve[o]=tabCartes[o];
					break;
					}
				}
			}

		}
		return i;
	}
	private Carte[] reiniTableau(){
		tabCarteNonTrouve[i[0]]=null;
		tabCarteNonTrouve[i[1]]=null;
		return tabCarteNonTrouve;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		nbCarteRetourne();
		nbCoup++;

		if(nbCarteRetourne<=2){
			Carte a = (Carte)e.getSource();
			if(!a.estMontree()){
				a.montre();//Montre la carte
			}
			else{
				nbCarteRetourne=1;
			}
		}
		else if(nbCarteRetourne>2){
			reiniNbCarteRetourne();
		}

		System.out.println(nbCarteRetourne);
		if(nbCarteRetourne==2){// Si le nombre de cartes retournée est paire
			indiceCarteRetourne();//On cherche les indices des deux dernières cartes retournées !!AFIXER!! NE MARCHE PAS

			if(tabCartes[i[1]].equals(tabCartes[i[0]])){//si les deux cartes sont pareilles

				System.out.println("Paire trouvée !");// on a trouvé la paire
				reiniNbCarteRetourne();//on réinitialise le nombre de cartes retournées
				//EnlevePaireTrouvee();//AFIXER/AREVOIR
				compteur++;// on incrémente le compteur
			}
			else{
				System.out.println("Pas la bonne paire !");//sinon, les deux cartes sont différentes
				b.start();// on met le timer en route, voir actionPerformed

				// on réinitialise le nombre de cartes retournées
				reiniTableau();

			}
			

		}

		if(compteur==tabCartes.length/2){//si le compteur est égal au nombre de paire (on a trouvé toutes les paires)
			victoryPanel();
			System.out.println("Vous avez trouvé les "+compteur+" paires !");
			System.out.println("Nombre de coup total : "+nbCoup);
			System.out.println("Vous avez gagné !");
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
	public void actionPerformed(ActionEvent  e) {// le timer va, après 1000ms cacher les deux dernières cartes retournées

	}

}