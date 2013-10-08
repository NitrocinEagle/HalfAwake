package game.personages;

import game.Direction;
import game.Map;
import game.MapObject;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Hero extends MapObject {

    public Hero(Map map, int x, int y) throws IOException {
	super(ImageIO.read(new File("head.jpg")), map, x, y);
    }

    public boolean performDefaultAction() {
	return false;
    }

    public boolean move(Direction direction) {
	this.direction = direction;
	switch(direction) {
	case LEFT:
	    if (map.objectMove(coordinates.x, coordinates.y, coordinates.x-1, coordinates.y)) {
		--coordinates.x;
		return true;
	    }
	    break;
	case RIGHT:
	    if (map.objectMove(coordinates.x, coordinates.y, coordinates.x+1, coordinates.y)) {
		++coordinates.x;
		return true;
	    }
	    break;
	case UP:
	    if (map.objectMove(coordinates.x, coordinates.y, coordinates.x, coordinates.y-1)) {
		--coordinates.y;
		return true;
	    }
	    break;
	case DOWN:
	    if (map.objectMove(coordinates.x, coordinates.y, coordinates.x, coordinates.y+1)) {
		++coordinates.y;
		return true;
	    }
	    break;
	}
	return false;
    }

}
