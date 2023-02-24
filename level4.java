package level;

public class level4 extends level {
	
	@Override
	public void create_midlayer(){
		music.play("song3",true);
		background = new background("background_brick");
		level_name = "lv5";
		next_level = "lv6";
		
		player_x = 40;
		player_y = 300;
		level_length = 5960;
		
		locked_door_excist = true;
		
		int x = 0,y = 600;
		
		
		
		make_rows(x, y,30,1,"brick");
		
		x = 160;
		y = 1280;
		make_rows(x, y,36,1,"brick");
		y = 1200;
		make_rows(x, y,2,2,"brick");
		x = 1120;
		make_rows(x, y,10,2,"brick");
		y = 0;
		x = 1520;
		make_rows(x, y,2,32,"brick");
		x = 0;
		y = 1920;
		make_rows(x, y,5,2,"brick");
		x = 1720;
		make_rows(x, y,11,2,"brick");
		x = 0;
		y = 2000;
		make_rows(x, y,94,1,"brick");
		x = 4520;
		make_rows(x, y,37,1,"brick");
		x = 2160;
		y = 1040;
		make_rows(x, y,2,24,"brick");
		x = 5120;
		y = 1160;
		make_rows(x, y,22,1,"brick");
		x = 1360;
		y = 2040;
		make_rows(x, y,2,30,"brick");
		x = 0;
		y = 3560;
		make_rows(x, y,150,1,"brick");
		x = 4480;
		y = 3520;
		make_rows(x, y,38,1,"brick");
		x = 2840;
		y = 3480;
		make_rows(x, y,5,2,"brick");
		x = 1400;
		make_rows(x, y,5,2,"brick");
		x = 3880;
		y = 3360;
		make_rows(x, y,4,5,"brick");
		
		
		//1
		add_platform(980, 1197);
		//2
		add_platform(813, 1105);
		//3
		add_platform(568, 1096);
		//4
		add_platform(340, 1177);
		//5
		add_platform(200,1920);
		//6 mini
		add_platform_mini(412,1886);
		//7 mini
		add_platform_mini(533,1815);
		//8 mini
		add_platform_mini(590,1762);
		//9 mini
		add_platform_mini(743,1938);
		//10 mini
		add_platform_mini(876,1877);
		//11
		add_platform(1010,1879);
		//12
		add_platform(1183,1879);
		//13
		add_platform(1486,1882);
		//14
		add_platform(1972, 1873,833, "up&down");
		//15
		add_platform(2235,1064);
		//16
		add_platform(2396,1188);
		//17
		add_platform(2589,1064);
		//18
		add_platform(2905 - 40,1024);
		//19mini
		add_platform_mini(3171,1064);
		//20mini
		add_platform_mini(3395,1209);
		//21mini
		add_platform_mini(3590,1145);
		//22mini
		add_platform_mini(3772,1075);
		//23mini
		add_platform_mini(3957,1073);
		//24mini
		add_platform_mini(4158,1155);
		//25
		add_platform(4329,1155);
		//26
		add_platform(4631,1154);
		//27
		add_platform(4898,1154);
		//28
		add_platform(2590,1287);
		//29
		add_platform(2794,1392);
		//30
		add_platform(2589,1515);
		//31
		add_platform(2361,1618);
		//32
		add_platform(2545,1712);
		//33
		add_platform(2783,1810);
		//34
		add_platform(2981,1911);
		//35
		add_platform(3940,1910);
		
		//I skipped numbers for some reason.....
		
		//39
		add_platform(4227,1914);
		//40
		add_platform(3832,2095);
		//41
		add_platform(4023,2236);
		//42
		add_platform(4212,2317);
		//43
		add_platform(4358,2447);
		//44
		add_platform(4510,2572);
		//45
		add_platform(4735,2658,739,"left&right");
		//46
		add_platform(5473,2669);
		//47
		add_platform(5729,2740);
		//48
		add_platform(5608,2873);
		//49
		add_platform(5472,2961);
		//50
		add_platform(5308,3030);
		//51
		add_platform(5164,3128);
		//52
		add_platform(5024,3210);
		//53
		add_platform(4827,3315);
		//54
		add_platform(4642,3408);
		//55
		add_platform(4288,3463);
		//56mini
		add_platform_mini(4118,3414);
		//57mini
		add_platform_mini(3753,3414);
		//58
		add_platform(3491,3415);
		//59mini
		add_platform_mini(3340,3369);
		//60mini
		add_platform_mini(3227,3421);
		//61mini
		add_platform_mini(3089,3476);
		//62mini
		add_platform_mini(2728,3471);
		//63
		add_platform(2509,3417);
		//64
		add_platform(2227,3420);
		//65mini
		add_platform_mini(2032,3463);
		//66mini
		add_platform_mini(1863,3466);
		//67mini
		add_platform_mini(1686,3470);
		//68
		add_platform(1269,3478);
		//69
		add_platform(1080,3411);
		//70
		add_platform(903,3345);
		//71
		add_platform(681,3413);
		//72
		add_platform(450,3325);
		//73
		add_platform(258,3253);
		//74
		add_platform(70,3167);
		//75
		add_platform(274,3055);
		//76
		add_platform(468,2965);
		//77
		add_platform(684,2885);
		//78
		add_platform(899,2978);
		//79
		add_platform(1134,2918);
		//80
		add_platform(1072,2817);
		//81
		add_platform(952,2716);
		//82
		add_platform(844,2642);
		//83
		add_platform(738,2555);
		//84
		add_platform(586,2477);
		//85
		add_platform(430,2572);
		//86
		add_platform(175,2572);
		
		x = 240;
		y = 1240;
		make_rows(x, y,22,1,"spike");
		x = 200;
		y = 1960;
		make_rows(x, y,38,1,"spike");
		x = 0;
		y = 3520;
		make_rows(x, y,35,1,"spike");
		x = 1600;
		make_rows(x, y,35 - 4,1,"spike");
		x = 3040;
		make_rows(x, y,21,1,"spike");
		x = 4040;
		make_rows(x, y,11,1,"spike");
		
		make_block(211 , 2529,"key");
		
		make_block(5545, (1061 + 99) - 120,"door");
		
//		spawn_enemy(759, 1443, "shooter");
		spawn_enemy(1357,1440, "shooter");
		spawn_enemy(3837,624, "shooter");
		spawn_enemy(4630,697, "shooter");
		spawn_enemy(5804,1589, "shooter");
		spawn_enemy(5025,1586, "shooter");
		spawn_enemy(3910,2954, "shooter");
		spawn_enemy(2875,3071, "shooter");
//		spawn_enemy(1858,2981, "shooter");
		spawn_enemy(1236,2454, "shooter");
		spawn_enemy(696,3023, "shooter");
		
		spawn_enemy(2119, 1736, "robot");
		spawn_enemy(5184,1901, "robot");
		spawn_enemy(5623, 1910, "robot");
		spawn_enemy(5915, 1915, "robot");


	}

}
