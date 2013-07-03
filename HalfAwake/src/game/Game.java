package game;

import java.awt.Canvas;

class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private volatile boolean running = false;
	private volatile boolean gameOver = false;

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
