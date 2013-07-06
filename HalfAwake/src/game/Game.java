package game;

import java.awt.Canvas;

class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private Thread animator;
	
	public void run() {
		init();
		
		while(running) {
			update();
			render();
		}
	}
	
	public void start() {
		running = true;
		animator = new Thread(this);
		animator.start();
	}
	
	public void stop() {
		running = false;
	}
	//Я не комент ахахаха. Я повар 
	private void init() {
		
	}
	
	private void render() {
		
	}

	private void update() {
		
	}
}
