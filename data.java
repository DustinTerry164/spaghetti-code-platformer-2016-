package app;
import java.awt.Image;

import fox.fox;
import level.*;



public class data {
	
	
	
	
	//game data sheet
	public static int window_width = 1200 , window_height = 700 ,ob_number = 0, max = 7000;
	//1
	public static double scaled_size = 1,coordinate_scale = 1;
	public static String current_frame = "title";
	
	//layerone
	public static int [] x_coords = new int[max];
	public static int [] y_coords = new int[max];
	public static Image [] graphics = new Image[max];
	
	//layertwo
	public static int ob_number_l2 = 0;
	public static double scaled_size_l2 =1;
	public static int [] x_coords_l2 = new int[max];
	public static int [] y_coords_l2 = new int[max];
	public static Image [] graphics_l2 = new Image[max];
	
	private static level current_level;
	
	private static int Enemy_number = 0;
	
	public static boolean loadnew = false;
	
	public static file_system fileSystem = new file_system();
	
	public static int get_enemy_number(){
		Enemy_number ++;
		return Enemy_number - 1;
	}
	
	//USE INVERTEDY BOOLEAN WHEN DONE WITH ALOT OF STUFF
	public static boolean invertedY = true, paused = false;
	
	
	//for pause toggling (to be ignored )
	static short c = 0;
	
	//scrolling
	public static double x_scroll = 0,y_scroll = 0;
	
	public static void clear_level(){
		for(int a = 0; a < max; a++){
			x_coords [a] = 0;
			y_coords [a] = 0;
			x_coords_l2 [a] = 0;
			y_coords_l2 [a] = 0;
			graphics_l2 [a] = null;
			graphics [a] = null;
		}
		Enemy_number = 0;
		x_scroll = 0;
		y_scroll = 0;
		ob_number = 0;
		ob_number_l2 = 0;
		
	}
	//use this method for getting the id of object
	
	
	public static int apply_graphics(Image a, int x, int y){
		graphics [ob_number] = a;
		x_coords [ob_number] = x;
		y_coords [ob_number] = y;
		ob_number ++;
		return ob_number - 1;
	}
	

	public static void update_graphics(int id, int x, int y, Image image){
		graphics [id] = image;
		x_coords [id] = x;
		y_coords [id] = y;	
	}
	
	
	//this is for layer 2
	public static int apply_graphics_l2(Image a, int x, int y){
		graphics_l2 [ob_number_l2] = a;
		x_coords_l2 [ob_number_l2] = x;
		y_coords_l2 [ob_number_l2] = y;
		ob_number_l2 ++;
		return ob_number_l2 - 1;
	}
	
	public static void update_graphics_l2(int id, int x, int y, Image image){
		graphics_l2 [id] = image;
		x_coords_l2 [id] = x;
		y_coords_l2 [id] = y;
		
	}
	
	
	public static void make_level(String levelname){
		clear_level();
		paused = false;
		current_frame = levelname;
		//add more here later
		current_level = null;
		
		
//		current_level = new test_level();
//		current_level = new level5();
		switch (levelname){
		case "lv1":
			current_level = new level1();
			break;
		case "lv2":
			current_level = new level2();
			break;
		case "lv3":
			current_level = new level5();
			break;
		case "lv4":
			 current_level = new level3();
			break;
		case "lv5":
			current_level = new level4();
			break;
		case "lv6":
			current_level = new level6();
			break;
		}
		
		level.player_1 = new fox(current_level.player_x,current_level.player_y);

		
	}
	//keyboard test function
	public static void check_keys(){
		if(current_level != null){
			if(app.keys.esc){
				paused = true;
				if(c > 20) paused = false;
			}
			if(!(app.keys.esc)){
				if(paused && c < 30){
					c++;
				}
				if(!(paused))c = 0;
			}
			
			if(app.keys.up) {
				
				level.player_1.fire_button = true;
			} else {
				level.player_1.fire_button = false;
			}
			if(app.keys.down && paused) loadnew = true;
		
			if(app.keys.left) level.player_1.move(-level.player_1.getSpeed());
			if(app.keys.right) level.player_1.move(level.player_1.getSpeed());
			if(app.keys.space_bar){
				level.player_1.jump();
				
			}else{
				if(!(level.player_1.on_ground))level.player_1.jump_enabled = false;
			}
		}
		
		if(app.keys.enter){
			if(current_frame == "title") loadnew = true;
		}
	}
	public static void update(){
		if(current_frame != "title"){
			current_level.update();
			
			//add something here later
			if(level.player_1.hp.test_dead() && level.player_1.can_die && !(level.player_1.alive))loadnew = true;
		}
		
		if(loadnew){

			make_level(fileSystem.level);
			loadnew = false;
		}
	}
}
