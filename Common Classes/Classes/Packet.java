package Classes;

import java.io.Serializable;

public class Packet implements Serializable  {
	String operation;
	Object data;
	int ID;
	
	public Packet(String operation, Object data)
	{
		this.operation=operation;
		this.data=data;
	}
	 
	public String getOperation() {
		return operation;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setID(int ID)
	{
		this.ID=ID;
	}
	
	public int getID()
	{
		return ID;
	}
	public String toString() {
		return operation + " " + data;
	}

	
	
	
	
}
