package block;


import java.awt.Image;
import javax.swing.ImageIcon;


public class brick extends block {
	//use this class for block constuction template
	Image I = new ImageIcon(getClass().getResource("brick.png")).getImage();
	public brick(int x, int y) {
		super(x, y);
		//args for function is the image and the boolean that determines if the block is harmful
		apply_settings(I);
	}
}
