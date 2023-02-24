package fox;

import java.awt.Image;

import javax.swing.ImageIcon;

import app.data;
import app.layer2_object;

public class healthmeter extends layer2_object {
	Image I = new ImageIcon(getClass().getResource("heart.png")).getImage();
	byte current_hp = 3, max_hp = 3;
	int hp_image[] = new int[current_hp];

	
	
	public healthmeter(int x, int y){
		for(byte w = 0; w < current_hp; w++){
			set_up(I,x, y);
			hp_image[w] = id;
			
		}
	}
	public void reduce(){
		
		if(current_hp != 0){
			data.graphics_l2[hp_image[current_hp - 1]] = null;
			current_hp--;
		}
	}
	public void gain(){
		current_hp++;
	}

	public void max(){
		current_hp = max_hp;
	}
	public boolean test_dead(){
		boolean stat = false;
		if(current_hp == 0) stat = true;
		
		return stat;
	}
	
	public void update(){
		
		
		double x = this.x;
		
			
		for(byte w = 0; w < current_hp; w++){
			render(hp_image[w], x, y , I);
			x = x + (I.getWidth(null) * data.scaled_size_l2);
		}
	}

}
