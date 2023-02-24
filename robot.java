package enemy;

import app.data;
import level.level;

public class robot extends enemy {
	
	//use as template
	
	
	
	double time_current = -.5, time_end = 1;
	int ammo = 0;
	
	
	public robot(int x, int y){
		
		set_up(I,x, y);
		this.y = getY(y);
		
		this.has_gravity = true;
		apply_settings("enemy_robot_",(short)2);
		
		basic = true;
		speed = 2;
		
		hp = 2;
		max_hp = 2;
		EID = data.get_enemy_number();
		original_x = (int)this.x;
		original_y = (int)this.y;

		


	}
	@Override
	public void update(){
		
		
		//must Implement test_dead and the !dying if statement

		test_dead();
		

		
		if(!(dying) && (!(off_screen))){
			
			
			//don't have to implement shoot and basic movement
			shoot();
		
			basic_movement();
		}
		
		if(been_damaged)invisible();
		if(time_current >= .2)been_damaged = false;
	}
	public void shoot(){
		
		time_current += .01;
		if(time_current >= time_end){
			time_current = -.1;
			level.sound.play("laser", false);
			int w = level.get_projectile_id();
	
			level.EP[w].x = x ;
			level.EP[w].y = this.y - height/2;
			level.EP[w].dir = dir;
			level.EP[w].type = "laser";
			


		}
		
	}

}
