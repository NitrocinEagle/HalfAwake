package game;

import java.awt.Canvas;

class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private static final int TIME_TO_SLEEP = 20; // milliseconds, sleep before render 
	
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private Thread animator;
	
	public void run() {
		init();
		
		while(running) {
			update();
			render();
			paintScreen();
			
			try {
				Thread.sleep(TIME_TO_SLEEP);
			}
			catch (InterruptedException e) {}
		}
	}
	
	public void start() {
		running = true;
		if (animator == null)
			animator = new Thread(this);
		animator.start();
	}
	
	public void stop() {
		running = false;
	}
	
	private void init() {
		
	}

	private void update() {
		if (!gameOver) {
			// update game state
		}
	}
	
	private void render() {
		
	}
	
	private void paintScreen() {
		
	}
}
