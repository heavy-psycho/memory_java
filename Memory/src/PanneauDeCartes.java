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

public class PanneauDeCartes extends JPanel implements MouseListener, ActionListener{


	private static final long serialVersionUID = 5191665466430373194L;

	JFrame myFrame= new JFrame();
	private Carte[] tabCartes;
	private Carte[] tabCarteNonTrouve;
	private int nbCarteRetourne=0;
	Timer b = new Timer(1000, this);	
	public int[] i;
	public int compteur = 0;
	

	// constructeur de PanneauDeCartes
	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes,int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		myFrame.setLayout(layout);
		myFrame.setTitle("JEUDECARTES");


		tabCartes=cartes;
		tabCarteNonTrouve = new Carte[tabCartes.length];
		for(int i = 0; i<tabCartes.length;i++){
			tabCarteNonTrouve[i]=tabCartes[i];
		}
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		myFrame.setSize(300,300);



		for(int i=0;i<cartes.length;i++){
			myFrame.add(cartes[i]);
			cartes[i].addMouseListener(this);
		}
		



		System.out.println(nbCarteRetourne());
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private int nbCarteRetourne(){
		for(int i=0;i<tabCartes.length;i++){
			if(tabCartes[i].estMontree()){
				nbCarteRetourne++;
			}
		}
		return nbCarteRetourne;
	}
	private int reiniNbCarteRetourne(){
		return nbCarteRetourne=0;
	}

	private int[] indiceCarteRetourne(){
		i = new int[]{-1,-1};//tableau qui contiendra les deux r�f�rence des deux derni�res cartes retourn�es
		for(int u=0;u<i.length;u++){
			for(int o=0; o<tabCartes.length;o++){
				if(tabCartes[o].estMontree()==true){
					if(o==i[0]) continue;
					i[u]=o;
					break;
				}
			}
			
		}
		return i;
	}
	private Carte[] EnlevePaireTrouvee(){// AREVOIR
		int u = 0;
		Carte[] interm = new Carte[tabCarteNonTrouve.length-2];
		for(int i=0; i<interm.length; i++){
			if(u==0){
				if(tabCarteNonTrouve[i].estCachee()){
					interm[i]=tabCarteNonTrouve[i];
				}
				else{u++;}
			}
			else if(u==1){
				if(tabCarteNonTrouve[i].estCachee()){
					interm[i]=tabCarteNonTrouve[i+1];
				}
				else{u++;}
			}
			else {
				interm[i]=tabCarteNonTrouve[i+2];
			}
		}
		tabCarteNonTrouve= new Carte[interm.length];
		for(int j=0; j<interm.length;j++){
			tabCarteNonTrouve[j]=interm[j];
		}
		return tabCarteNonTrouve;
	}
	
	/*private boolean[] indice(){
		
		for(int i=0;i<tabCartes.length;i++){
			if(tabCartes[i].estMontree()==true){
				c[i]=true;
			}else{c[i]=false;}
		}
			return c;
	}*/


	@Override
	public void mouseClicked(MouseEvent e) {
		Carte a = (Carte)e.getSource();
			a.montre();//Montre la carte
		if(nbCarteRetourne()%2==0){// Si le nombre de cartes retourn�e est paire
			indiceCarteRetourne();//On cherche les indices des deux derni�res cartes retourn�es !!AFIXER!! NE MARCHE PAS
			System.out.println(i[0]+"   "+i[1]);//test
			//b.start();
			//reiniNbCarteRetourne();
			if(tabCartes[i[1]].equals(tabCartes[i[0]])){//si les deux cartes sont pareilles
				System.out.println("Paire trouv�e !");// on a trouv� la paire
				reiniNbCarteRetourne();//on r�initialise le nombre de cartes retourn�es
				//EnlevePaireTrouvee();//AFIXER/AREVOIR
				compteur++;// on incr�mente le compteur
			}
			else{
				System.out.println("Pas la bonne paire !");//sinon, les deux cartes sont diff�rentes
				b.start();// on met le timer en route, voir actionPerformed
				reiniNbCarteRetourne();// on r�initialise le nombre de cartes retourn�es
			}
			
		}
		else{
			reiniNbCarteRetourne();
		}
		if(compteur==tabCartes.length/2){//si le compteur est �gal au nombre de paire (on a trouv� toutes les paires)
			System.out.println("Vous avez trouv� les "+compteur+" paires !");
			System.out.println("Vous avez gagn� !");
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
	public void actionPerformed(ActionEvent  e) {// le timer va, apr�s 1000ms cacher les deux derni�res cartes retourn�es
		tabCartes[i[1]].cache();
		tabCartes[i[0]].cache();
		/*for(int i=0; i<tabCartes.length; i++){
			if(tabCartes[i].estCachee() == false){
				tabCartes[i].cache();
			}
		}*/
		b.stop();
	}

	

	





}

