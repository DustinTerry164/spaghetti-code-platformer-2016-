package enemy;

import javax.swing.ImageIcon;

import app.data;
import level.level;

public class turrent extends enemy {
	double time_current = -.5, time_end = 1;
	public turrent(int x, int y){
		
		set_up(I,x, y);
		this.y = getY(y);
		
		this.has_gravity = false;
		apply_settings("turrent_left_down");
		height = I.getHeight(null);
		width = I.getWidth(null);
		basic = false;
		speed = 0;
		
		hp = 4;
		max_hp = 4;
		EID = data.get_enemy_number();
		
		original_x = (int)this.x;
		original_y = (int)this.y;


	}
	

	
	public void update(){
		
		
		//must Implement test_dead and the !dying if statement
		test_dead();
		
		if(!(dying) && (!(off_screen))){
			level.test_collision_enemy((int)x, (int)y, EID);
			locate();

		}
		
		
		render(id, x, y, I);
		
		if(been_damaged)invisible();
		if(time_current >= .2)been_damaged = false;
	}
	
	
	public void locate(){
		double F_X = level.player_1.x;
		double F_Y = level.player_1.i((int)level.player_1.y);
		
		int x_s = 0;
		int y_s = 0;
		int speed = 7;
		
		
		//up
		if(F_Y < level.player_1.i((int)y)) y_s = -speed/2;
		
		//down
		if(F_Y > level.player_1.i((int)y) + height) y_s = speed/2;
		
		//left
		if(F_X < x - width/2) x_s = -speed;
			I = new ImageIcon(getClass().getResource("turrent_left.png")).getImage();
			if(F_Y > level.player_1.i((int)y) + height) I = new ImageIcon(getClass().getResource("turrent_left_down.png")).getImage();
			if(F_Y < level.player_1.i((int)y)) I = new ImageIcon(getClass().getResource("turrent_left_up.png")).getImage();

		//right
		if(F_X > x + width + width/2){ x_s = speed;

			I = new ImageIcon(getClass().getResource("turrent_right.png")).getImage();
			if(F_Y > level.player_1.i((int)y) + height)I = new ImageIcon(getClass().getResource("turrent_right_down.png")).getImage();
			if(F_Y < level.player_1.i((int)y))	I = new ImageIcon(getClass().getResource("turrent_right_up.png")).getImage();
		}
		
		
		
		shoot((int)x_s,(int)y_s);
		
	}
	public void shoot(int x_speed, int y_speed){
		
		
		time_current += .01;
		if(time_current >= time_end){
			time_current = -.1;
			level.sound.play("cannon", false);
			int w = level.get_projectile_id();
	
			level.EP[w].x = x + width/2 - level.EP[w].width/2;
			level.EP[w].y = this.y - height/2;
			level.EP[w].dir = dir;
			level.EP[w].type = "bullet";
			level.EP[w].x_speed = x_speed;
			level.EP[w].y_speed = y_speed;
			


		}
		
	}

}
