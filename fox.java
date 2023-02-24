package fox;
import java.awt.Image;

import javax.swing.ImageIcon;
import level.level;
import app.data;
import app.object;
import fox.healthmeter;
import fox.ninja_star;

public class fox extends object{
	Image frame = new ImageIcon(getClass().getResource("fox_sprite_right_0.png")).getImage();
	public String dir = "right";
	public healthmeter hp = new healthmeter(1,data.window_height -50);
	
	
	//set can_die to true when game is done
	
	public boolean on_ground = false, jump_enabled = false, moving = false, can_die = true;
	
	//collision tester
	public boolean left = true, right = true, up = true,fire_button = false, is_invisible = false, alive = true,g = true;
	
	//change to 140 height
	int current_height ,max_height = 15;
	
	
	short star_number = 0;
	
	public ninja_star star [] = new ninja_star[4];
	
	
	double speed = 4, fall_speed = 7,jump_speed = 20,frame_number = 0,throw_delay = 3, throw_delay_time = 0,
			damage_delay = 8, damage_delay_time = 7.8, death_time = 0;
	
	
	public fox(int x, int y){
		set_up(frame,x,y);
		width = frame.getWidth(null);
		height = frame.getHeight(null);
		star[0] = new ninja_star(0,-200,dir);
		star[1] = new ninja_star(0,-200,dir);
		star[2] = new ninja_star(0,-200,dir);
		star[3] = new ninja_star(0,-200,dir);
		
		
	} 
	public void update() {
		if(!(hp.test_dead()))update_movement();
		
		if((hp.test_dead())){
			frame = new ImageIcon(getClass().getResource("fox_dead.png")).getImage();

			if(g){
				current_height = 0;
				g = false;
			}
			if(current_height <= max_height + 20){
				this.y += jump_speed/2;
				current_height ++;
			}
			
			death_time += .01;

			if(death_time >= 2)alive = false;				
			this.y -= fall_speed/1.5;
			render(id,this.x,this.y,frame);
		}
		
		

	}
	
	void update_movement(){
		if(damage_delay_time <= damage_delay) damage_delay_time += .1;
		
		hp.update();
		frame_number += .2;
		if(frame_number > 2) frame_number = 0;
		if(moving == false) frame_number = 0;
		
		on_ground = level.test_collision((int)this.x + frame.getWidth(null)/2,(int)this.y - frame.getHeight(null));
		if(!(on_ground)){
			this.y -= fall_speed;
			level.tracker.direction = "?";
		}
		
		
		
		if(throw_delay_time < throw_delay) throw_delay_time += .08;
		if(fire_button){
			//star
			
			if(star_number > 3) star_number = 0;
			if(throw_delay_time > 2.9){				
				throw_star(star_number);
				throw_delay_time = 0;
//				System.out.println((int)x + ","+ (getY((int)y) + frame.getHeight(null)));
			}
		}
			//star
		
			for(short a = 0; a < 4; a++){
				if(star[a] != null)star[a].update();
			}
	
		scroll();
		
		
		//platform tracking
		if(level.tracker.is_being_used()){
			double s = level.tracker.get_speed();
			if(level.tracker.get_direction() == "right") this.x += s;
			if(level.tracker.get_direction() == "left") this.x -= s;
			if(level.tracker.get_direction() == "up") this.y += s;
			if(level.tracker.get_direction() == "down") this.y -= s;
			
		}

		
		frame = new ImageIcon(getClass().getResource("fox_sprite_"+dir+"_"+(int)frame_number+".png")).getImage();
		if(fire_button)frame = new ImageIcon(getClass().getResource("fox_throw_"+dir+".png")).getImage();
		if(damage_delay_time <= damage_delay){
				render(id,-40,0,frame);
			if(h_a()){
				
				render(id,this.x,this.y,frame);
			}
		}
		
		if(damage_delay_time >= damage_delay)render(id,this.x,this.y,frame);

		moving = false;
	}
	
	
	
	
	//e
	boolean h_a(){
		if(!(is_invisible)){
			is_invisible = true;
			return true;
		}else {
			is_invisible = false;
			return false;
		}
	}
	public void damage(){
		
		if(damage_delay_time >= damage_delay){
			level.sound.play("hit", false);
			hp.reduce();
			damage_delay_time = 0;
		}
	}
	public void kill(){
		hp.reduce();
	}
	public void throw_star(int a){
		level.sound.play("fox_shoot", false);
			star[a].x = x;
			star[a].y = y - height/3;
			star[a].dir = dir;
			
			star_number ++;
			
			
	}
	public int i(int y){
		double w = data.window_height - y;
		double s =  w * data.coordinate_scale;
		y = (int)s;
		
		return y;
	}
	public void scroll(){
		int f = (int)speed;
		if(this.x - data.x_scroll >= data.window_width/2 + 70 && this.x < level.level_length - data.window_width/2.45 ) data.x_scroll += f ;
		
		if(this.x - data.x_scroll <= data.window_width/2 - 70 && data.x_scroll > 20) data.x_scroll -= f;
//		if(this.y + data.y_scroll <= data.window_height/3) data.y_scroll += fall_speed;
		if(this.y + data.y_scroll <= data.window_height/3 && getY((int)this.y) < level.pit - (data.window_height/3 + 40)) data.y_scroll += fall_speed;
		if(this.y + data.y_scroll >= data.window_height - (data.window_height/3)) data.y_scroll -= f;
//		System.out.println(data.y_scroll);
		if(getY((int)this.y) > level.pit ) hp.reduce();
		if(this.x >= level.level_length) right = false;
		if(this.x < 3)left = false;
	}
	public void move(double a){
		moving = true;
		if(!(data.paused)){
			if(a > 0 && right){
				x += a;
				dir = "right";
			}
			if( a < 0 && left){
				x += a;
				dir = "left";
			}
		
		
			reset_collision();
		}
	}
	
	public void teliport(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	private void reset_collision(){
		left = true;
		right = true;
	}
	
	public double getSpeed(){
		return speed;
	}
	public void jump() {
		if(!(up) || data.paused) current_height = max_height;
		current_height ++;
		moving = true;
		if(current_height <= max_height && jump_enabled )this.y += jump_speed;
	
		
		if(on_ground){
			current_height = 0;
			jump_enabled = true;
			level.sound.play("jump", false);
			
		}
		frame_number = 1;
		up = true;
	}

}
