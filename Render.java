import java.awt.Color;

public class Render implements Runnable{
	method m = new method();
	
	public void run() {
		while(m.o.running == true) {
			m.o.repaint();
			if(m.o.frame.isActive() == false) {
				m.o.running = false;
			}
		}
	}
}
