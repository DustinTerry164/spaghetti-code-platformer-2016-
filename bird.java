package enemy;

import app.data;
import level.level;

public class bird extends enemy{
	
	double time_current = -.5, time_end = 1,range = 0;
	int ammo = 0;
	

	public bird(int x, int y){
		
		set_up(I,x, y);
		this.y = getY(y);
		
		this.has_gravity = false;
		apply_settings("bird_",(short)2);
		height = I.getHeight(null);
		width = I.getWidth(null);
		basic = false;
		speed = 2;
		
		hp = 2;
		max_hp = 2;
		EID = data.get_enemy_number();
		
		original_x = (int)this.x;
		original_y = (int)this.y;
		

	}
	

	
	public void update(){
		
		
		//must Implement test_dead and the !dying if statement
		test_dead();
		
		if(!(dying) && (!(off_screen))){
			level.test_collision_enemy((int)x, (int)y, EID);
			basic_movement();
		}
		if(range >= 300){

			switch(dir){
			case "left":
				dir = "right";
				range = 0;
				break;
			case "right":
				dir = "left";
				range = 0;
				break;
			}
		}
		range ++;
		render(id, x, y, I);
		
		if(been_damaged)invisible();
		if(time_current >= .2)been_damaged = false;
		time_current += .01;
		if(time_current >= time_end) time_current = -.1;
	}
	
	



}
