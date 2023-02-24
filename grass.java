package block;
import java.awt.Image;

import javax.swing.ImageIcon;

import block.block;
public class grass extends block{
	
	Image I = new ImageIcon(getClass().getResource("Grass.png")).getImage();

	public grass(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	


}
