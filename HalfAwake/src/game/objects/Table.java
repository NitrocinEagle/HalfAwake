package game.objects;

import game.Map;
import game.MapObject;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Table extends MapObject {

	public Table(int x, int y) throws IOException {
		super(ImageIO.read(new File("table.jpg")), x, y);
	}

	public boolean performDefaultAction(Map map) {
		try {
			sprite = ImageIO.read(new File("boom.jpg"));
		} catch (IOException e) { return false; }
		
		class TableRemover extends Thread {
			Table table;
			Map map;
			public TableRemover(Map map, Table table) {
				this.table = table;
				this.map = map;
			}
			
			public void run() {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) { }
				map.removeObject(table);
			}
		}
		new TableRemover(map, this).start();
		
		return true;
	}

}
