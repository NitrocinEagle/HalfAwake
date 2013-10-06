package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private static final int TIME_TO_SLEEP = 20; // milliseconds, sleep before render 

    private volatile boolean running = false;
    private volatile boolean gameOver = false;
    private Thread animator;

    BufferStrategy bs;

    public void run() {
	init();

	while(running) {
	    update();

	    try {
		Thread.sleep(TIME_TO_SLEEP);
		repaint();
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
    
    public void paint(Graphics g) {
	if (bs == null) {
	    createBufferStrategy(2);
	    bs = getBufferStrategy();
	}
	
	g.setColor(Color.black);
        g.fillRect(0, 0,  getWidth(), getHeight());
    }
}
