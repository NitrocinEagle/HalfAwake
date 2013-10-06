package game.objects;

import game.MapObject;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Table extends MapObject {

	public Table(int x, int y) throws IOException {
		super(ImageIO.read(new File("table.jpg")), x, y);
	}

	public boolean performDefaultAction() {
	    try {
		sprite = ImageIO.read(new File("boom.jpg"));
	    } catch (IOException e) {
		return false;
	    }
	    return true;
	}

}
