package fox;
import java.awt.Image;

import javax.swing.ImageIcon;

import app.data;
import app.object;

public class ninja_star extends object{
	
	String dir;
	boolean error_printed = false;
	Image frame = new ImageIcon(getClass().getResource("ninja_star_0.png")).getImage();
	
	double frame_number = 0, speed = 8;
	
	public ninja_star(int x , int y, String dir){
		
		this.x = x;
		this.y = y;
		this.dir = dir;
		set_up(frame, (int)this.x, (int)this.y);
		
		
	}
	public void teliport(){
		
		x = 0;
		y = getY(-400);
		dir = "?";
		
	}
	
	public void update(){
		
		if(dir == "right") x+= speed;
		if(dir == "left") x-= speed;
		frame_number += .1;
		if(frame_number >= 1.8) frame_number = 0;
		
		if( x > (data.window_width + data.x_scroll) || x < 0 + data.x_scroll - 60) teliport();

		try{
			

			
			
		frame = new ImageIcon(getClass().getResource("ninja_star_" + (int)frame_number +".png")).getImage();
				
		}catch (NullPointerException f){
			if(!(error_printed)){
				System.out.println("Error missing Image @fox.ninja_star.line 30 - 40, when type: ninja_star been created.");
				error_printed = true;
			}
		
		
		}
		render(id, this.x, this.y,frame);

	}
}
