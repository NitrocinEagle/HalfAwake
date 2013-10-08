package game.objects;

import game.Coordinates;
import game.Direction;
import game.Map;

import java.awt.Image;


public abstract class MapObject {
    public Image sprite;
    public Coordinates coordinates;
    public Direction direction = Direction.DOWN;
    protected Map map;

    public MapObject(Image image, Map map, int x, int y) {
	coordinates = new Coordinates(x, y);
	this.sprite = image;
	this.map = map;
	map.addObject(this);
    }

    public MapObject(Image image, int x, int y, Map map, Direction direction) {
	this(image, map, x, y);
	this.direction = direction;
    }

    abstract public boolean performDefaultAction();
}
