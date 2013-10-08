package game.objects.personages;

import game.Map;
import game.objects.Direction;
import game.objects.MapObject;

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
	return map.objectMove(coordinates.x, coordinates.y, direction);
    }
}
