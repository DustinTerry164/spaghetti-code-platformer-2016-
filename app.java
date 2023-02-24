package app;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class app extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean running = false;
	JFrame window = new JFrame();
	Thread thread = new Thread();
	public static keyboard keys = new keyboard();
	public app(){
		window.setSize(data.window_width, data.window_height);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Ninja Fox - By Dustin Terry");
		addKeyListener(keys);
	}
	

	public synchronized void start(){
		running = true;
		thread = new Thread(this, "display");
		thread.start();
	}
	public synchronized void stop(){
		running = false;
		try{
		thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public void draw(){
		BufferStrategy bs = getBufferStrategy() ;
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		for(int x = 0; x < data.ob_number; x++){
			//layer 1
		if(data.graphics[x] != null){
			//ingame width and height
			double ig_width, ig_height;
			
			ig_width = data.graphics[x].getWidth(null) * data.scaled_size;
			ig_height = data.graphics[x].getHeight(null) * data.scaled_size;
			
				if(data.x_coords[x] - (int)data.x_scroll > - 70 && data.x_coords [x] - (int)data.x_scroll < data.window_width + 30)g.drawImage(data.graphics[x], data.x_coords[x] - (int)data.x_scroll,
					data.y_coords[x] - (int)data.y_scroll,(int)ig_width,
						(int)ig_height, null);
		}
		}
		
		//layer 2
		for(int x = 0; x < 20; x++){
		if(data.graphics_l2[x] != null){
			double ig_width, ig_height;
			
			ig_width = data.graphics_l2[x].getWidth(null) * data.scaled_size_l2;
			ig_height = data.graphics_l2[x].getHeight(null) * data.scaled_size_l2;
			
			g.drawImage(data.graphics_l2[x], data.x_coords_l2[x], data.y_coords_l2[x],(int)ig_width,(int)ig_height, null);
		}
		}
		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		byte w  = 0;
		long last = System.nanoTime();
		double ns = 1000000000.0/ 60.0;
		double delta = 0;
		

		setup_start_screen();
		while(running){
			long now = System.nanoTime();
			delta += (now - last)/ns;
			last = now;
			while (delta >= 1){
				data.update();
				data.check_keys();
				delta --;
			}
			
			draw();
	
		}
	// TODO Auto-generated method stub
	
	}
	public void setup_start_screen(){
		Image start_text =  new ImageIcon(getClass().getResource("start.png")).getImage();
		data.graphics_l2[data.ob_number_l2] = start_text;
		data.x_coords_l2[data.ob_number_l2] = 0;
		data.y_coords_l2[data.ob_number_l2] = 0;
		data.ob_number_l2 ++;
	}

	public static void main(String [] args){
		app app = new app();
		app.window.add(app);
		app.start();
	}

}