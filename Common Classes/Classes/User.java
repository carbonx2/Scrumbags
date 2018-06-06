package Classes;

import java.io.Serializable;

import Classes.Permission;

public class User implements Serializable {
	String ID;
	String password;
	int permission;
	
	
	public User(String ID, String password, Permission permission) {
		super();
		this.ID=ID;
		this.password=password;
		this.permission=permission.ordinal();
	}
	
	public String getID()
	{
		return ID; 
	}
	
	public int getPermission()
	{
		
		return permission;
	}
	
	
}
