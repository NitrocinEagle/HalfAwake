package Game;

import java.awt.Image;

class Coordinates {
	public int x;
	public int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MapObject {
	public Image sprite;
	public Coordinates coordinates;
	
	public MapObject(Image image, int x, int y) {
		coordinates = new Coordinates(x, y);
		this.sprite = image;
	}
}
