package app;

import java.awt.Image;

public class object {
	
	public int id = 0,width, height;
	public double speed = 2 , x = 0 , y = 0;
	
	public void set_up(Image I, int x, int y){
		
		this.x = x;
		this.y = y;
		if(data.invertedY) this.y = getY(y);
		id = data.apply_graphics(I, (int)this.x, getY((int)this.y));
		double w = I.getWidth(null) * data.scaled_size;
		double h = I.getHeight(null) * data.scaled_size;
		width = (int)w;
		height = (int)h;
		
	}
	
	public int getY(int y){
		
		return data.window_height - y;
	}
	public void render(int id, double x, double y,Image I){
		
		data.update_graphics(id , (int)x, getY((int)y), I);
	}
	public void invisible(){
		data.update_graphics(id , (int)x, getY((int)y), null);
	}

}
