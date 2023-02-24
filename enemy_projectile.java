package enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

import app.data;
import app.object;

public class enemy_projectile extends object {
	
	Image I = new ImageIcon(getClass().getResource("laser.png")).getImage();
	public int x_speed = 0, y_speed = 0;
	public String type, dir = "?";
	boolean can_move = false;
	public enemy_projectile(int x, int y){
		this.y = y;
		this.x = x;
		set_up(I,x,y);
		speed = 8;
		type = "laser";
		
	}
	public enemy_projectile(int x, int y, String type){
		this.y = y;
		this.x = x;
		set_up(I,x,y);
		speed = 8;
		this.type = type;
	}
//	public enemy_projectile(int x, int y, int x_speed, int y_speed, String type){
//		this.y = y;
//		this.x = x;
//		set_up(I,x,y);
//		speed = 8;
//		this.type = type;
//		this.x_speed = x_speed;
//		this.y_speed = y_speed;
//	}
	
	public void move_all_directions(int xs, int ys){
		
		if(x < -100 + data.x_scroll || x > data.window_width + 100 + data.x_scroll){
			dir = "?";
			x = 0;
			y = getY(-400);
		}
		
		this.x += xs;
		this.y -= ys;
		
		
	}
	
	
	public void move_LR(){
		

			
		if(dir == "right") x+= speed;
		if(dir == "left") x-= speed;
		
		
	}
	
	public void update(){
		if(type == "laser"){
			move_LR();
			I = new ImageIcon(getClass().getResource("laser.png")).getImage();
		}
		if(type == "tracker"){
			move_all_directions(x_speed,y_speed);
			I = new ImageIcon(getClass().getResource("ball_projectile.png")).getImage();
		}
		if(type == "bullet"){
			move_all_directions(x_speed,y_speed);
			I = new ImageIcon(getClass().getResource("bullet.png")).getImage();
		}
		
		if(x < -100 + data.x_scroll || x > data.window_width + 100 + data.x_scroll){
			dir = "?";
			x = 0;
			y = getY(-400);
			type = null;
		}

//		if(dir == "right" || dir == "left")System.out.println(dir + "!" + x);

		
		render(id,x,y,I);
	}


}
