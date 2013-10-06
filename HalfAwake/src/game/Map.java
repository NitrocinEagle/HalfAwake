package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

class Map {
    MapObject[][] grid;
    ArrayList<MapObject> objects = new ArrayList<>();

    Dimension size;
    public boolean addObject(MapObject object) {
	grid[object.coordinates.x][object.coordinates.y] = object;
	return objects.add(object);
    }
    
    public void objectMove(int oldX, int oldY, int x, int y) {
	grid[x][y] = grid[oldX][oldY];
	grid[oldX][oldY] = null;
    }

    public Map(int width, int height) {
	size = new Dimension(width, height);
	grid = new MapObject[height/50][width/50];
    }

    public void draw(Graphics g) {
	for(MapObject object : objects) {
	    g.drawImage(object.sprite, object.coordinates.x*50, object.coordinates.y*50, null);
	}
    }
}
