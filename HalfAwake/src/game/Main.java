package game;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
    public static void main(String args[]) {
	Game game = new Game();
	game.setPreferredSize(new Dimension(500, 400));

	JFrame frame = new JFrame("Half Awake 2D");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(game, BorderLayout.CENTER);

	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);

	frame.setLocation(100, 100);
	game.start();
    }
}
