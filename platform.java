package platform;

import java.awt.Image;

import app.data;
import app.object;
import javax.swing.ImageIcon;

public class platform extends object {

	
	Image platform_g = new ImageIcon(getClass().getResource("platform.png")).getImage();
	int range = 0,starting_point_x = 0, starting_point_y = 0;
	
	String mode = "static",direction = "?";
	
	
	public platform(int x, int y){
		set_starting_points(x,y);
		set_up(platform_g,x,y);
	}
	public platform(int x, int y, String g){
		platform_g = new ImageIcon(getClass().getResource(g + ".png")).getImage();
		set_starting_points(x,y);
		set_up(platform_g,x,y);
	}
	public platform(String mode,int x, int y){
		this.mode = mode;
		set_starting_points(x,y);
		set_up(platform_g,x,y);
	}
	public platform(String mode,int x, int y, int r){
		set_starting_points(x,y);
		this.mode = mode;
		range = r;
		set_up(platform_g,x,y);
	}
	
	public void set_starting_points(int x,int y){
		starting_point_x = x;
		starting_point_y = y;
		speed = 2;
		if(mode == "up&down") direction = "up";
	}
	public void update(){
		if(range == 0) range = 200;
		if(mode == "up&down"){
			move_updown();
			
		}else if(mode == "left&right"){
			move_leftright();
		}
		render(id, (int)x,y, platform_g);
		

	}
	public String get_direction(){
		
		return direction;
	}
	public double get_speed(){
		return speed;
	}
	public void move_updown(){
		if(direction == "up") y += speed;
		if(direction == "down") y -= speed;
		
		if(y <= i(starting_point_y)) direction = "up";
		if(y >= (i(starting_point_y) + range)) direction = "down";
		
	}
	private int i(int y){
		double w = data.window_height - y;
		double s =  w * data.coordinate_scale;
		y = (int)s;
		
		return y;
	}
	
	public void move_leftright(){
		
		if(direction == "right") x+= speed;
		if(direction == "left") x-= speed;
		if(x <= starting_point_x ) direction = "right";
		if(x >= starting_point_x + range) direction = "left";
	}

}
