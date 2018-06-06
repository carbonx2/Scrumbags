/*
 * Added subjects and courses.
 * @Authors: Alon and Jonathan
 */

package Classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import Classes.Permission;

public class Teacher extends User implements Serializable {
	String firstName;
	String lastName;
	HashSet<Subject> subjects;                  //new           
	HashMap<String, HashSet<Course>> courses;   //new   
	
	public Teacher(String ID, String password, String firstName, String lastName,  HashSet<Subject> subjects, HashSet<Course> courses) {
		super(ID,password,Permission.TEACHER);
		this.firstName=firstName;
		this.lastName=lastName;
		this.subjects=subjects;
		/* 
		 * NEW
		 */
		HashSet<Course> coursesSet;
		this.courses=new HashMap<String, HashSet<Course>>();
		for(Course course : courses)		
		{
			coursesSet = this.courses.get(course.getSubjectID());
			if(coursesSet==null) {
				coursesSet=new HashSet<Course>();
				this.courses.put(course.getSubjectID(), coursesSet);
			}
			coursesSet.add(course);
		}
		/*
		 * End of NEW
		 */
	}
	
	public String toString()
	{
		return "Name:"+firstName+" Last Name:"+lastName+" ID:"+getID()+" Permission:"+getPermission();
	}
	
	public String getName()
	{
		return firstName+" "+lastName;
	}
	

	public HashSet<Course> getCoursesOfSubject(String subject) {//new
		return courses.get(subject);
	}

	public HashSet<Subject> getSubjects() {//new
		return subjects;
	}
}
