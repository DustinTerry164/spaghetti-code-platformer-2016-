package enemy;


import java.awt.Image;
import java.lang.NullPointerException;
import javax.swing.ImageIcon;
import level.*;
import app.data;
import app.object;

public class enemy extends object {
	
	
	public Image I = new ImageIcon(getClass().getResource("enemy_robot_left_0.png")).getImage();
	

	double speed = 2, fall_speed = 5,current_frame = 0, animation_speed = .1, animation_frame_number = 1.5;
	short hp = 1,max_hp = 1;
	int original_x,original_y;
	public boolean on_ground = false, has_gravity = false,left = true, right = true,error_printed = false,dying = false,been_damaged = false;
	public boolean basic = true, off_screen = false;
	
	
	//EID Stands for Enemy ID
	public int EID = 0;
	public String dir = "left",type = "enemy_robot_";

	
	public void update(){
		test_dead();
		if(!(dying) && (!(off_screen))){
			if(basic) basic_movement();
		
		}

	}
	
	public void test_dead(){
		if(x < -100 + data.x_scroll || x > data.window_width + 100 + data.x_scroll || i(y) < data.y_scroll || i(y) > data.window_height + data.y_scroll){				
					if(dying && !(off_screen)){
						x = original_x;
						y = original_y;
					}
					off_screen = true;
					dying = false;
					
					//edit for boss programming
					hp = max_hp;
		} else {
			off_screen = false;
		}
		
		
		
		
//		if(x > -100 + data.x_scroll || x < data.window_width + 100 - data.y_scroll)off_screen = false;
		
		
	}
	public void damage(){
		if(!(hp == 0) && !(off_screen)){
			hp--;
			level.sound.play("hit", false);
		}
		been_damaged = true;
		if(hp == 0) dying = true;
	}
	
	public double i(double y){
		double w = data.window_height - y;
		double s =  w * data.coordinate_scale;
		y = (int)s;
		
		return y;
	}
	
	public void basic_movement(){
		if(has_gravity){

			if(!(level.test_collision_enemy((int)x, (int)y, EID)))y -= fall_speed;
			
			
		}
		
		if(!(left)) dir = "right";
		if(!(right)) dir = "left";
		if(!(left) && !(right)) dir = "?";
		
		
		if(dir == "left") {
			x-= speed;
		}else if (dir == "right"){
			x+= speed;
		}
		
		animate();
		
		left = true;
		right = true;
	}
	public void animate(){
		if(current_frame > animation_frame_number) current_frame = 0;
		//edit

		try{
			
			I = new ImageIcon(getClass().getResource(type + dir +"_"+(int)current_frame+".png")).getImage();
			render(id, x, y, I);
			
			
		}catch (NullPointerException f){
			if(!(error_printed)){
				System.out.println("Error missing Image @ enemy.enemy.line66, when type: "+type+" been created.");
				error_printed = true;
			}
			
		}
		current_frame += animation_speed;
		
		
	}
//	public void make_invisible(){
//		I = null;
//		render(id, x, y, I);
//	}
	
	public void apply_settings(String type,short number_of_frames){
		
		
		this.type = type;
		animation_frame_number = number_of_frames;
		I = new ImageIcon(getClass().getResource(this.type + dir +"_"+(int)current_frame+".png")).getImage();
		
		height = I.getHeight(null);
		width = I.getWidth(null);
		
	}

	public void apply_settings(String type){
		
		
		this.type = type;
		I = new ImageIcon(getClass().getResource(this.type + ".png")).getImage();
		
		height = I.getHeight(null);
		width = I.getWidth(null);
		
	}
	
	

}
