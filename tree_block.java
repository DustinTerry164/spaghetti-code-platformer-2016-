package block;

import java.awt.Image;

import javax.swing.ImageIcon;

public class tree_block extends block{
	Image I = new ImageIcon(getClass().getResource("wood.png")).getImage();
	public tree_block(int x, int y) {
		super(x, y);
		//args for function is the image and the boolean that determines if the block is harmful
		apply_settings(I);
	}


}
