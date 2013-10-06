package game;

import java.util.Set;


class Map {
    Set <MapObject> objects;
    
    boolean addObject(MapObject object) {
	return objects.add(object);
    }

    Map(int widith, int height) {

    }

    void draw() {
	for(MapObject object : objects) {
	    // draw the object
	}
    }
}
