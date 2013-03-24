import javax.swing.*;
import java.awt.*;
import java.awt.Component;

public class PanneauDeCartes {

	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes, int delaiAffichageInitial, int delaiAffichageMauvaisePaire){

		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		setLayout(layout);
	}
}