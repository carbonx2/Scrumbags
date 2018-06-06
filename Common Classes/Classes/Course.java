/*
 * New
 * @Authors: Alon and Jonathan
 */

package Classes;

import java.io.Serializable;

public class Course implements Serializable {

	String name;
	String ID;
	String subjectID;
		
	
	public Course(String ID,String name, String subjectID)
	{
		this.ID=ID;
		this.name=name;
		this.subjectID=subjectID;
	}
	
	
	public String getSubjectID() {
		return subjectID;
	}


	public String getName() {
		return name;
	}	


	public String getID() {
		return ID;
	}

	public String toString()
	{
		return "ID("+ID+"), name("+name+"), subjectID("+subjectID+")";
	}
	
}

