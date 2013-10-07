package game.personages;

import game.Map;
import game.MapObject;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero extends MapObject {
    
    public Hero(int x, int y) throws IOException {
	super(ImageIO.read(new File("head.jpg")), x, y);
    }
	
	public boolean performDefaultAction(Map map) {
		return false;
	}

}
 