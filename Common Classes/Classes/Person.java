/*
 * Changed name to Person
 * @Authors: Alon and Jonathan
 */

package Classes;

import java.io.Serializable;

public class Person implements Serializable {
	String ID;
	String name;
	
	
	public Person(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getID() { 
		return ID;
	}
	
	public String toString()
	{
		return ID+" "+name;
	}
}
