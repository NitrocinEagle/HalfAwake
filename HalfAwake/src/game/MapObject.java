package game;

import java.awt.Image;


public abstract class MapObject {
	public Image sprite;
	public Coordinates coordinates;
	
	public MapObject(Image image, int x, int y) {
		coordinates = new Coordinates(x, y);
		this.sprite = image;
	}

	abstract public boolean performDefaultAction(Map map);
}
