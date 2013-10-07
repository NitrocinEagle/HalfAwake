package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Map {
	Dimension size;
	MapObject[][] grid;
	ArrayList<MapObject> objects = new ArrayList<>();
	Image floor;

	public boolean addObject(MapObject object) {
		grid[object.coordinates.y][object.coordinates.x] = object;
		return objects.add(object);
	}
	
	public boolean removeObject(MapObject object) {
		return removeObject(object.coordinates.x, object.coordinates.y);
	}
	
	public boolean removeObject(int x, int y) {
		try {
			objects.remove(grid[y][x]);
			grid[y][x] = null;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean objectMove(int oldX, int oldY, int x, int y) {
		try {
			if (grid[y][x] != null)
				return false;
			grid[y][x] = grid[oldY][oldX];
			grid[oldY][oldX] = null;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public Map(int width, int height) throws IOException {
		size = new Dimension(width, height);
		floor = ImageIO.read(new File("floor.jpg"));
		grid = new MapObject[height/50][width/50];
	}

	public void draw(Graphics g) {
		for (int i = 0; i < size.width; i += 50)
			for (int j = 0; j < size.height; j += 50)
				g.drawImage(floor, i, j, null);

		for(MapObject object : objects) {
			g.drawImage(object.sprite, object.coordinates.x*50, object.coordinates.y*50, null);
		}
	}

	public boolean performDefaultAction(int x, int y) {
		try {
			if (grid[y][x] == null)
				return false;
			return grid[y][x].performDefaultAction(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
}
