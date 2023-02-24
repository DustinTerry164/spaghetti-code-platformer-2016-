package block;

import java.awt.Image;

import javax.swing.ImageIcon;

public class spike extends block {
	
	
	Image I = new ImageIcon(getClass().getResource("spike.png")).getImage();
	public spike(int x, int y) {
		super(x, y);
		deadly = true;
		apply_settings(I);
	}

}
