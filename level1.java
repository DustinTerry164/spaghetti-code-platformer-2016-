package level;

import app.data;
import block.*;
import enemy.robot;
import platform.platform;



public class level1 extends level  {
	
	

	
	@Override
	public void create_midlayer(){
		
		
		music.play("song1",true);
		int x,y;
		
		
		
		x = 3480;
		y = 1480;
		
		
		add_background_object(x,y, "dirt_background");
		
		level_name = "lv1";
		next_level = "lv2";
		
		player_x = 40;
		player_y = 1600;
		
		pit = 2050;
		data.y_scroll = 1281.0;
		
		x = 0; y = 1800;
		
		
		make_rows(x, y,19,1,"grass");
		y = 1840;
		make_rows(x, y,19,5,"dirt");
		x = 760; 
		y = 1560;
		make_rows(x, y,16,1,"grass");
		y = 1600;
		make_rows(x, y,16,10,"dirt");
		x = 1400;
		y = 1800;

		make_rows(x, y,15,1,"grass");
		y = y + 40;
		enemies [number_of_enemies] = new robot(x + 80, y - 120);
		number_of_enemies++;
		make_rows(x, y,15,4,"dirt");
		x = 2000;
		y =	1440;
		make_rows(x, y,17,1,"grass");
		y = y + 40;
		make_rows(x, y,17,13,"dirt");
		x = 2680;
		y = 1480;
		make_rows(x, y,20,1,"grass");
		y += 40;
		make_rows(x, y,20,12,"dirt");
//		
//		
//		
//		
//		
//		
//		
//		
//		 - 50
//		
		
		String s = "robot";
		
//		spawn_enemy(888,1507 - 50,s);
//		spawn_enemy(1228,1502 - 50,s);
		spawn_enemy(2152,1384 - 50,s);
		spawn_enemy(2776,1426 - 50,s);
		spawn_enemy(3112,1426 - 50,s);
		spawn_enemy(3840,1221 - 50,s);
		spawn_enemy(3728,1747 - 50,s);
		spawn_enemy(4212,1747 - 50,s);
		spawn_enemy(7512,1765 - 50,s);
		spawn_enemy(7760,1765 - 50,s);
		

		
		x = 3480;
		y = 1360;
		//1
		make_rows(x, y,4,1,"grass");
		y += 40;
		make_rows(x, y,4,3,"dirt");
		//2
		x = 3640;
		y = 1320;
		make_rows(x, y,4,1,"grass");
		y +=40;
		make_rows(x, y,4,3,"dirt");
		//3
		x = 3800;
		y = 1280;
		make_rows(x, y,4,1,"grass");
		y += 40;
		make_rows(x, y,4,3,"dirt");
		x = 3960;
		y = 1200;
		make_rows(x, y,4,1,"grass");
		y += 40;
		make_rows(x, y,4,3,"dirt");
		
		x = 3800;
		y = 1600;
		make_rows(x, y,4,1,"grass");
		
		x = 3960;
		y = 1560;
		make_rows(x, y,4,1,"grass");
		y += 40;
		make_rows(x, y,4,1,"dirt");
		x = 4120;
		y = 1520;
		make_rows(x, y,4,1,"grass");
		y += 40;
		make_rows(x, y,4,2,"dirt");
		
		x = 3480;
		y = 1800;
		make_rows(x, y,29,1,"grass");
		y = 1840;
		make_rows(x, y,29,3,"dirt");
		x = 4280;
		y = 0;
		make_rows(x, y,4,40,"dirt");
		
		x = 4640;
		y = 1200;
		
		make_rows(x,y,8,1,"grass");
		y = 1240;
		make_rows(x, y,8,40,"dirt");
		
		
		
		
		platforms [0] = new platform(660 - 30,1720);
		platforms [1] = new platform(1400,1720);
		platforms [2] = new platform(1911 - 35,1720);
		platforms [3] = new platform(1911 - 35,1552);
		platforms [4] = new platform("up&down",4440,1700,700);
		
		
		
//		
//		blocks [number_of_blocks] = new door(4760,1101, locked_door_excist);
//		
		
		
		//part 2
		
		int e = 4960;
		int w = 940;
		
		x = e;
		y = 0;
//		for(int a = 0; a < 19; a++){
//			blocks[a] = new block(x,880);
//			x = x + 40;
//		}
		y = 880 + w;
		make_rows(x, y,19,1,"grass");
		x = 0 + e;
		y = 920 + w;
		
		make_rows(x , y,19,3,"dirt");

		platforms [5] = new platform("up&down",820 + e,960 + w,600);
		platforms [6] = new platform(1400 + e,750 + w);
		platforms [7] = new platform(1600 + e,650 + w);
		platforms [8] = new platform(1900 + e,800 + w);
		

		x = 1050 + e;
		y = 400 + w;
		make_rows(x,y,5,1,"grass");
		y = 440 + w;
		
		//12
		make_rows(x, y, 5 ,15,"dirt");

		x = 2120 + e;
		y = 880 + w;
		
		make_rows(x,y, 22 , 1, "grass");
		y = 920 + w;
		make_rows(x,y, 22 , 3, "dirt");
		
		x = 3160 + e;
		y = 880 + w;
		make_rows(x,y, 21 , 1, "grass");
		y = 920 + w;
		make_rows(x,y, 21, 3, "dirt");
		
		blocks [number_of_blocks] = new door(3500 + e,((781 + w) + 99) - 120, locked_door_excist);
		
//		blocks [number_of_blocks] = new door(500,781, locked_door_excist);
		
		

	}

}
