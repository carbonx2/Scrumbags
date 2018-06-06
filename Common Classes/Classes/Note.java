package Classes;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Serializable;








public class Note implements Serializable {
	private String text;
	private int x;
	private int y;
	private Permission permission;
	public Note(String text, int x, int y, Permission permission) {
		super();
		this.text = text;
		this.x = x;
		this.y = y;
		this.permission = permission;
	}
	
	
}

