package game;

import java.awt.Image;


public abstract class MapObject {
    public Image sprite;
    public Coordinates coordinates;
    public Direction direction = Direction.DOWN;

    public MapObject(Image image, int x, int y) {
	coordinates = new Coordinates(x, y);
	this.sprite = image;
    }

    public MapObject(Image image, int x, int y, Direction direction) {
	this(image, x, y);
	this.direction = direction;
    }

    abstract public boolean performDefaultAction(Map map);
}
