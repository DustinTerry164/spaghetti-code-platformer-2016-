package level;

import fox.fox;
import platform.platform;
import soundPlayer.sound_player;
import app.data;
import fox.tracker;
import block.*;
import enemy.*;

public class level {
	
	static short EP_number = 0;
	public static boolean enemy_respawn = true, locked_door_excist = false;
	public static background background;
	public static fox player_1 ;
	public static platform [] platforms;
	public static tracker tracker ;
	static int max_number_blocks = 7000;
	public static block [] blocks;
	public static enemy [] enemies ;
	public static background_object [] bg_object;
	
	public static int pit = 0,level_length = 0;
	public static boolean is_last;
	public int player_x = 50,player_y = 400;
	public static int number_of_blocks = 0,number_of_enemies = 0,number_of_bg_objects = 0,number_of_platforms = 0;
	public static String next_level = "?";
	public String level_name = "?";
	public static sound_player music= new sound_player(), sound = new sound_player();
	
	public dialog pause_display;
	
	
	public static enemy_projectile EP [] = new enemy_projectile[30];
	
	
	//warning note: start at 15 when creating enemies
	
	public void prepare(){
		pause_display = new dialog("blank",0,0);
		is_last = false;
		platforms = new platform[200];
		tracker = new tracker();
		blocks = new block[max_number_blocks];
		enemies = new enemy[600];
		bg_object = new background_object[800];
		pit = 4000;
		level_length = 40000;
	}
	public void add_underlayer(){
		background = new background();
		//things that belong underneath things go here
	}
	
	public void create_midlayer(){
		//things that belong in between layers goes here
		//but function may have to be overriden
		
	}
	
	
	public void add_overlayer(){
		//things that belong over things go here
		
		
	}
	
	public static int get_projectile_id(){
			EP_number ++;
			if(EP_number > 29)EP_number = 0;
		
		return EP_number ;
		
	}
	
	public level(){
		
		
		
		prepare();
		music.stop();
		add_underlayer();
		create_midlayer();
		for(short w = 0; w < 30; w++){
		EP [w] = new enemy_projectile(0,-400);
		}
		number_of_enemies = 0;
		number_of_blocks = 0;
		number_of_bg_objects = 0;
		number_of_platforms = 0;
	}
	
	public void spawn_enemy(int x, int y, String type){
		if(type == "robot")enemies[number_of_enemies] = new robot(x,y);
		if(type == "shooter")enemies[number_of_enemies] = new shooter(x,y);
		if(type == "slug_snake")enemies[number_of_enemies] = new slug_snake(x,y);
		if(type == "bird")enemies[number_of_enemies] = new bird(x,y);
		if(type == "turrent")enemies[number_of_enemies] = new turrent(x,y);
		
		number_of_enemies ++;
		
	}
	
	public void add_platform(int x, int y){
		platforms[number_of_platforms] = new platform(x,y);
		number_of_platforms ++;
	}
	
	public void add_platform(int x, int y,int r, String f){
		
		platforms[number_of_platforms] = new platform(f,x,y,r);
		number_of_platforms ++;
		
	}
	public void add_platform_mini(int x, int y){
		
		platforms[number_of_platforms] = new platform(x,y,"platform_mini");
		number_of_platforms ++;
		
	}
	
	public void add_background_object(int x, int y, String t){
		
		
		bg_object[number_of_bg_objects] = new background_object(x,y,t);
		number_of_bg_objects ++;
	}
	public void add_block(int x, int y, String type){
		if(type == "dirt")blocks[number_of_blocks] = new dirt(x,y);
		if(type == "grass")blocks[number_of_blocks] = new block(x,y);
		if(type == "brick")blocks[number_of_blocks] = new brick(x,y);
		if(type == "spike")blocks[number_of_blocks] = new spike(x,y);
	}
	
	public void make_rows(int x, int y,int collums , int number_of_rows,String type){
		int starting_x = x;
		for(int a = 0; a < number_of_rows; a ++){
			for(int w = 0; w < collums; w++){
				if(type == "dirt")blocks[number_of_blocks] = new dirt(x,y);
				if(type == "grass")blocks[number_of_blocks] = new block(x,y);
				if(type == "brick")blocks[number_of_blocks] = new brick(x,y);
				if(type == "spike")blocks[number_of_blocks] = new spike(x,y);
				x = x + 40;
			}
			x = starting_x;
			y = y + 40;
		}
	}
	public void make_block(int x , int y, String type){
		
		if(type == "dirt")blocks[number_of_blocks] = new dirt(x,y);
		if(type == "grass")blocks[number_of_blocks] = new block(x,y);
		if(type == "brick")blocks[number_of_blocks] = new brick(x,y);
		if(type == "spike")blocks[number_of_blocks] = new spike(x,y);
		if(type == "key")blocks[number_of_blocks] = new key(x,y);
		if(type == "tree_block")blocks[number_of_blocks] = new tree_block(x,y);
		if(type == "lava")blocks[number_of_blocks] = new lava(x,y);
		if(type == "door")blocks[number_of_blocks] = new door(x,y,locked_door_excist);
		if(type == "wood_plank")blocks[number_of_blocks] = new wood_plank(x,y);
		if(type == "red_block")blocks[number_of_blocks] = new red_block(x,y);
	}
	
	
	public static void destroy_enemy( int EID){
		//add more here !
		if(enemies[EID] != null){
			int id = enemies[EID].id;
			enemies[EID] = null;
			data.graphics[id] = null;
		}
	}
	
	
	
	//enemy collision
	public static boolean test_collision_enemy(int x, int y, int id){
		boolean f = false;
		

		//this is for the blocks

		
		int yy = y - ((enemies[id].height - (enemies[id].height/2)));
		x = x + 15;
		for(int a = 0; a < max_number_blocks; a++){
			int null_count = 0;
			if( blocks[a] != null ){
				if(x + 12 >= blocks[a].x && x - 12 <= blocks[a].x + blocks[a].width &&
						y - enemies[id].height < blocks[a].y && y - enemies[id].height > blocks[a].y - ((blocks[a].height * data.scaled_size))){
							f = true;
							
				}
				if(x + 15 >= blocks[a].x && x - 15 <= blocks[a].x + blocks[a].width && yy + 10 - enemies[id].height/2< blocks[a].y && yy - 10 + enemies[id].height/2> blocks[a].y - ((blocks[a].height * data.scaled_size))){
					if(enemies[id].dir == "left")enemies[id].left = false;
						if(enemies[id].dir == "right")enemies[id].right = false;
				}
				
			}
			 if(blocks[a] == null) null_count++;
			 if(null_count == 15) a = max_number_blocks;
			
		}
		for(short a = 0; a < 4; a++){
			try{
				if(x + 15 >= player_1.star[a].x && x - 15 <= player_1.star[a].x + player_1.star[a].width && yy - 10 - enemies[id].height/2< player_1.star[a].y && yy + 10 + enemies[id].height/2> player_1.star[a].y - ((player_1.star[a].height * data.scaled_size))){
					
					
					player_1.star[a].teliport();
					enemies[id].damage();
					
				}
			}catch (NullPointerException e){
				System.out.println(e);
				
			}
		}
		//add more here
		return f;
	}
	
	
	
	//player collision
	public static boolean test_collision(int x, int y){
		boolean f = false;
		//this is for the platforms
		for(int a = 0; a < 200; a++){
			if( platforms[a] != null ){	
				if(x >= platforms[a].x && x <= platforms[a].x + platforms[a].width &&
						y - 2 <= platforms[a].y && y >= platforms[a].y - ((platforms[a].height * data.scaled_size))){
							f = true;
							tracker.track(a, platforms[a].get_direction(), platforms[a].get_speed());
				}
			}
		}
		//this is for the blocks
		int yy = y + ((player_1.height - (player_1.height/2)));
		
		int null_count = 0;
		for(int a = 0; a < max_number_blocks; a++){
			if( blocks[a] != null ){
				if(x + 15 >= blocks[a].x && x - 15 <= blocks[a].x + blocks[a].width &&
						y - 2 < blocks[a].y && y > blocks[a].y - ((blocks[a].height * data.scaled_size))){
							f = true;
							if(blocks[a].deadly) player_1.kill();
				}
				if(x + 18 >= blocks[a].x && x - 18 <= blocks[a].x + blocks[a].width && yy + 10 - player_1.height/2< blocks[a].y && yy - 10 + player_1.height/2> blocks[a].y - ((blocks[a].height * data.scaled_size))){
						if(player_1.dir == "left")player_1.left = false;
						if(player_1.dir == "right")player_1.right = false;
						if(x + 12 >= blocks[a].x && x - 12 <= blocks[a].x + blocks[a].width)player_1.up = false;
						
						if(blocks[a].is_the_key){
							if(locked_door_excist)sound.play("key", false);
							locked_door_excist = false;
							
						}
						if(blocks[a].is_level_end_door){
							test_for_next_level(blocks[a].is_locked_door);
							

							
						}
						if(blocks[a].deadly) player_1.kill();
				}
			}
			 if(blocks[a] == null) null_count++;
			 if(null_count == 15) a = max_number_blocks;
		}
		null_count = 0;
		
		for(int a = 0; a < 200;a++){
			
			
			if(enemies[a] != null){
				if(x + 15 >= enemies[a].x && x - 15 <= enemies[a].x + enemies[a].width && yy + 10 - player_1.height/2< enemies[a].y && yy - 10 + player_1.height/2> enemies[a].y - ((enemies[a].height * data.scaled_size))){
					if(!(enemies[a].dying)) player_1.damage();
				}
			}
			
				 
			if(enemies[a] == null)null_count++;
			
			if(null_count >= 15) a = 200;
		}
		null_count = 0;
		for(short a = 0; a < 30; a++){
			if(EP[a] != null){
				if(x + 15 >= EP[a].x && x - 15 <= EP[a].x + EP[a].width && yy + 10 - player_1.height/2< EP[a].y && yy - 10 + player_1.height/2> EP[a].y - ((EP[a].height * data.scaled_size))){
					player_1.damage();
					EP[a].x = 0;
					EP[a].y = i(-400);
					EP[a].type = null;
				}
			}
			
		}
		//add more here
		return f;
	}
	
	public void update(){
		
		
		background.update();
		
		if(data.paused){
			pause_display.reset("paused",data.window_width/2 - 300,data.window_height/2);
		} else {
			pause_display.reset("blank",data.window_width/2 - 300,data.window_height/2);

		}
		if(!(data.paused)){


			

			player_1.update();
			byte null_count = 0;
			for(short a = 0; a <= 200; a++){
				if(platforms[a] != null) platforms[a].update();
				if(platforms[a] == null) null_count++;
				if(null_count == 3) a = 200;
			}
			null_count = 0;
			for(int a = 0; a <= max_number_blocks; a++){
				if(blocks[a] != null) blocks[a].update();
				if(blocks[a] == null) null_count++;
				if(null_count == 3) a = max_number_blocks;
			}
			null_count = 0;
			for(short a = 0; a <= 200; a++ ){
				if(enemies [a] != null){
					enemies[a].update();
					if(enemies[a].dying) {
						if(!(enemy_respawn))destroy_enemy(enemies[a].EID);
						data.graphics[enemies[a].id] = null;
					}
				}
				
				if(enemies [a] == null) null_count++;
				if(null_count == 15) a = 200;
			}
			
			null_count = 0;
			///!!!!!
			for(short a = 0; a < 30; a++){
				EP[a].update();
			}

			null_count = 0;
		}
	
	}
	
	
	public static void test_for_next_level(boolean locked){
		
		if(player_1.dir == "left")player_1.left = true;
		if(player_1.dir == "right")player_1.right = true;
		player_1.up = true;
		

		
		if(!(locked) ){
			if(!(is_last)){
				data.fileSystem.set(next_level);
				data.loadnew = true;
			}
			
			if(is_last){
				data.paused = true;
				dialog win = new dialog("win",0,0);
			}

	
		}
		
	}
	
	//this method is for inverting the y coordinate
	public static int i(int y){
		double w = data.window_height - y;
		double s =  w * data.coordinate_scale;
		y = (int)s;
		
		return y;
	}
	

}
