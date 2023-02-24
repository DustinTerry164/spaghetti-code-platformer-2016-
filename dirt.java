package block;

import java.awt.Image;

import javax.swing.ImageIcon;

public class dirt extends block{
	
	//use this class for block constuction template
	Image I = new ImageIcon(getClass().getResource("dirt.png")).getImage();
	public dirt(int x, int y) {
		super(x, y);
		//args for function is the image and the boolean that determines if the block is harmful
		apply_settings(I);
	}

}
