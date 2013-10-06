package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

class Map {
    ArrayList<MapObject> objects = new ArrayList<>();
    
    Dimension size;
    boolean addObject(MapObject object) {
	return objects.add(object);
    }

    Map(int widith, int height) {
	size = new Dimension(widith, height);
    }

    void draw(Graphics g) {
	for(MapObject object : objects) {
	    g.drawImage(object.sprite, object.coordinates.x, object.coordinates.y, null);
	}
    }
}
