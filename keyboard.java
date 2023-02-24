package app;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class keyboard implements KeyListener{
	public boolean up = false,down= false,left = false,right = false,space_bar = false,enter = false,esc = false;
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
		if(e.getKeyCode() == KeyEvent.VK_UP) up = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) space_bar = true;
		if(e.getKeyCode() == KeyEvent.VK_ENTER) enter = true;
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) esc = true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)	right = false;
		if(e.getKeyCode() == KeyEvent.VK_UP) up = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)	down = false;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) space_bar = false;
		if(e.getKeyCode() == KeyEvent.VK_ENTER) enter = false;
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) esc = false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

