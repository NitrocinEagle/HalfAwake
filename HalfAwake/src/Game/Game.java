package Game;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private volatile boolean running = false;

	public void run() {
		while (running) {
			
		}
	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void init() {
		
	}
	
	public void render() {
		
	}

	public void update() {
		
	}
}
