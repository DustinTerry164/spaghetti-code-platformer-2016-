package level;

import java.awt.Image;

import javax.swing.ImageIcon;
import app.data;
import app.object;

public class background extends object {
	
	Image I = new ImageIcon(getClass().getResource("background_sky.png")).getImage();
	
	public background(){

		
		set_up(I,(int)x, (int)y);
	}
	
	
	public background(String background){
		
		I = new ImageIcon(getClass().getResource(background + ".png")).getImage();
		
		set_up(I,(int)x, (int)y);
	}
	
	public void update(){
		double x = 0, y = 0;
		x = (this.x - 5) + data.x_scroll;
		y = (this.y + 5) - data.y_scroll;
		
		render( id, x,  y,I);
	}

}
