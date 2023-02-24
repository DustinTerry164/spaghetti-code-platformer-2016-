package level;

import java.awt.Image;

import javax.swing.ImageIcon;

import app.layer2_object;

public class dialog extends layer2_object{
	Image I = new ImageIcon(getClass().getResource("win.png")).getImage();
	public dialog(String f,int x, int y){
		I = new ImageIcon(getClass().getResource(f + ".png")).getImage();
		set_up(I,x, y);
	}
	public void reset(String f, int x, int y){
		this.x = x;
		this.y = y;
		I = new ImageIcon(getClass().getResource(f + ".png")).getImage();
		render(id, x, y, I);
//		set_up(I,(int)x, (int)y);
	}
	public void update(){
		render(id, x, y, I);
	}
}
