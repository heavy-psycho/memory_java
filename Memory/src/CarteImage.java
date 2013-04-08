import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CarteImage extends Carte{

	private BufferedImage img; 
	public String b;
	public int caract;

	protected CarteImage(String b, boolean sens) {
		super(sens);
		this.b = b;
	}

	@Override
	public Object duplique() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintRecto(Graphics2D g) {
		int x = 0;
		int y = 0;
		try {                
			
			img = ImageIO.read(getClass().getResourceAsStream(b));
		} catch (IOException ex) {
			// handle exception...
		}
		//g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), observer)
		g.fillRect(x,y,getWidth(),getHeight());

	}

	@Override
	public boolean rectoIdentique(Carte s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getCaract() {
		return this.caract;
	}

}
