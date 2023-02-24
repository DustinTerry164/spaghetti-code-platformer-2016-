package block;

import java.awt.Image;

import javax.swing.ImageIcon;

public class lava extends block {
	
	
	Image I = new ImageIcon(getClass().getResource("lava_above.png")).getImage();
	public lava(int x, int y) {
		super(x, y);
		deadly = true;
		apply_settings(I);
	}

}
