package block;

import java.awt.Image;

import javax.swing.ImageIcon;

import app.data;
import app.object;

public class background_object extends object {
	
	Image I = new ImageIcon(getClass().getResource("dirt.png")).getImage();
	
	public background_object(int x, int y, String object){
		this.x = x;
		this.y = y;
		try{
		I = new ImageIcon(getClass().getResource(object + ".png")).getImage();
		}catch (Exception e){
			System.out.println(e);
		}
		
		set_up(I,(int)x, (int)y);
	}
	
	public void update(){

		
		render( id, x,  y,I);
	}

}
