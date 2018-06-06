package Classes;

import java.io.Serializable;

/*
 * New
 * @Authors: Alon and Jonathan
 */

public class Subject implements Serializable {

	String name;
	String ID;
		
	
	public Subject(String ID,String name)
	{
		this.name=name;
		this.ID=ID;
	}
		
	
	public String getName() {
		return name;
	}	


	public String getID() {
		return ID;
	}
	
	public String toString() {
		return "ID("+ID+"), name("+name+")";
	}

	
	
}
