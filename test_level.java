package level;

import block.*;
import block.brick;
import block.door;
import block.key;
import enemy.*;
import platform.platform;

public class test_level extends level{
	
	@Override
	public void create_midlayer(){
		
		locked_door_excist = true;
		level_name = "lv2";
		next_level = "lv1";
		is_last = true;
		player_x = 40;
		player_y = 400;
		
		//most of this code is temporary

		int x = 0;
		
		blocks [0] = new brick( 0,1000);
//		blocks [1] = new brick( 40,800);
//		blocks [2] = new brick( 80,800);
		
		for(int w = 1; w < 50;w++){
			
			blocks [w] = new red_block(x,800);
			
			x = x + 40;
		}
		
		blocks [51] = new block(240,640);
		blocks [52] = new brick(800,760);
		blocks [53] = new key(400,760);
		
		//this is the end level door
//		locked_door_excist = true;
		blocks [54] = new door(1800,701, locked_door_excist);
		
		enemies [0] = new slug_snake(650, 640);
		enemies [1] = new turrent(450, 600);
		enemies [2] = new robot(1700, 640);


//		blocks [9] = new brick
//		blocks [10] = new brick
//		blocks [11] = new brick
//		blocks [12] = new brick
//		blocks [13] = new brick
//		blocks [14] = new brick
//		blocks [15] = new brick
//		blocks [16] = new brick
//		blocks [17] = new brick
//		blocks [18] = new brick
//		blocks [19] = new brick
//		blocks [20] = new brick
//		blocks [21] = new brick
//		blocks [22] = new brick
//		blocks [23] = new brick
//		blocks [24] = new brick
//		blocks [25] = new brick
//		blocks [26] = new brick
//		blocks [27] = new brick
//		blocks [28] = new brick
//		blocks [29] = new brick
		
		
		
		platforms [1] = new platform("up&down",400,740,400);
//		platforms [1] = new platform("left&right",400,740,400);
		

	}

}
