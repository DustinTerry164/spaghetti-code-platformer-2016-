package block;

import java.awt.Image;

import javax.swing.ImageIcon;

public class door extends block{
	
	Image I = new ImageIcon(getClass().getResource("End_level_door.png")).getImage();
	
	

	public door(int x, int y, boolean is_locked) {
		
		super(x, y);
		is_level_end_door = true;
		
		is_locked_door = is_locked;
		// TODO Auto-generated constructor stub
		width = I.getWidth(null);
		height = I.getHeight(null);
		apply_settings(I);
	}
	
	@Override
	public void update(){
		//add code for locked door
		if(is_locked_door)I = new ImageIcon(getClass().getResource("End_level_door_locked.png")).getImage();
		if(!(is_locked_door))I = new ImageIcon(getClass().getResource("End_level_door.png")).getImage();
		if(!(level.level.locked_door_excist))is_locked_door = false;

		render(id, x, y, I);
	}


}
