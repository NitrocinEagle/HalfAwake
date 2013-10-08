package game;

import game.objects.Table;
import game.objects.personages.Hero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JPanel;

class Game extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int FPS = 25;
    private static final int TIME_TO_SLEEP = 1000/FPS; // milliseconds, sleep before render 

    private volatile boolean running = false;
    private Thread animator;

    private Map map;
    private Hero hero;

    public void run() {
	init();

	while(running) {
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
	try {
	    map = new Map(getWidth(), getHeight());
	    hero = new Hero(map, 0, 0);
	    new Table(map, 3, 3);
	} catch (IOException e) {
	    System.exit(1);
	}
	
	setFocusable(true);
	requestFocusInWindow();

	addKeyListener(new KeyAdapter() {
	    public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		    hero.move(Direction.LEFT);
		    break;
		case KeyEvent.VK_RIGHT:
		    hero.move(Direction.RIGHT);
		    break;
		case KeyEvent.VK_UP:
		    hero.move(Direction.UP);
		    break;
		case KeyEvent.VK_DOWN:
		    hero.move(Direction.DOWN);
		    break;
		case KeyEvent.VK_E:
		    int x = hero.coordinates.x;
		    int y = hero.coordinates.y;

		    switch (hero.direction) {
		    case LEFT: --x; break;
		    case RIGHT: ++x; break;
		    case UP: --y; break;
		    case DOWN: ++y; break;
		    }
		    map.performDefaultAction(x, y);
		default: break;
		}
	    }
	});
    }

    public void paint(Graphics g) {
	g.setColor(Color.black);
	g.fillRect(0, 0,  getWidth(), getHeight());
	map.draw(g);
    }
}
