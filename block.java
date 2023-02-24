package block;

import java.awt.Image;

import javax.swing.ImageIcon;
import level.level;
import app.object;

public class block extends object {
	
	public boolean deadly = false;
	public Image I = new ImageIcon(getClass().getResource("Grass.png")).getImage();
	public boolean is_level_end_door = false,is_locked_door = false,is_the_key = false;

	
	public block(int x, int y){
		set_up(I,x, y);
		level.number_of_blocks++;
	}
	
	public void update(){
		
		
		render(id, x, y, I);
	}
	public void apply_settings(Image k){
		I = k;
	}

}
