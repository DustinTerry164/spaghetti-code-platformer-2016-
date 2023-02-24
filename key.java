package block;

import java.awt.Image;

import javax.swing.ImageIcon;

import level.level;

public class key extends block{
	
	Image I = new ImageIcon(getClass().getResource("key.png")).getImage();
	
	

	public key(int x, int y) {
		
		super(x, y);

		// TODO Auto-generated constructor stub
		width = I.getWidth(null);
		height = I.getHeight(null);
		apply_settings(I);
		is_the_key = true;
	}
	
	@Override
	public void update(){
		//add code for locked door
		if(!(level.locked_door_excist)) I = null;

		
		render(id, x, y, I);
	}

}
