package block;

import java.awt.Image;

import javax.swing.ImageIcon;

public class wood_plank extends block{
	Image I = new ImageIcon(getClass().getResource("wood_plank.png")).getImage();

	public wood_plank(int x, int y) {
		super(x, y);
		
		apply_settings(I);
		// TODO Auto-generated constructor stub
	}
	
}
