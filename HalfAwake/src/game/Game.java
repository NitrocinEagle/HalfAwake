package game;

import game.personages.Hero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	setFocusable(true);
	requestFocusInWindow();
	
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
	    hero = new Hero(ImageIO.read(new File("head.jpg")), 0, 0);
	} catch (IOException e) {
	    System.exit(1);
	}
	map.addObject(hero);

	addKeyListener(new KeyAdapter() {
	    public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		    if (map.objectMove(hero.coordinates.x, hero.coordinates.y, hero.coordinates.x-1, hero.coordinates.y))
			--hero.coordinates.x;
		    break;
		case KeyEvent.VK_RIGHT:
		    if (map.objectMove(hero.coordinates.x, hero.coordinates.y, hero.coordinates.x+1, hero.coordinates.y))
			++hero.coordinates.x;
		    break;
		case KeyEvent.VK_UP:
		    if (map.objectMove(hero.coordinates.x, hero.coordinates.y, hero.coordinates.x, hero.coordinates.y-1))
			--hero.coordinates.y;
		    break;
		case KeyEvent.VK_DOWN:
		    if (map.objectMove(hero.coordinates.x, hero.coordinates.y, hero.coordinates.x, hero.coordinates.y+1))
			++hero.coordinates.y;
		    break;
		default:
		    break;
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
