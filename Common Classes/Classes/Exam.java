package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Exam implements Serializable  {
	private String ID;
	private Course course;
	private Subject subject;
	private Person author;
	private String creationDate;
	private ArrayList<Question> questions;
	private HashMap<Question, Integer> scores;
	private HashSet<Note> notes;
	private int examTime;
	
	public Exam(String ID,Course course, Subject subject, Person author, String creationDate, int examTime) {
		super();
		this.ID = ID;
		this.course = course;
		this.subject = subject;
		this.author = author;
		this.creationDate = creationDate;
		this.examTime = examTime;
		this.questions = null;
		this.scores = null;
		this.notes = null;
	}
	
	public Exam(String ID, Course course, Subject subject, Person author, String creationDate,	
			ArrayList<Question> questions, HashMap<Question, Integer> scores, int examTime) {
		this(ID,course,subject,author,creationDate,examTime);
		this.questions = questions;
		this.scores = scores;
	}
	
	public Exam(String ID, Course course, Subject subject, Person author, String creationDate,	
			ArrayList<Question> questions, HashMap<Question, Integer> scores, HashSet<Note> notes, int examTime) {
		this(ID, course, subject, author, creationDate, questions, scores ,examTime);
		this.notes = notes;
	}


	public String getID() {
		return ID;
	}
	
	public Course getCourse() {
		return course;
	}

	public Subject getSubject() {
		return subject;
	}

	public Person getAuthor() {
		return author;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public HashMap<Question, Integer> getScores() {
		return scores;
	}

	public int getExamTime() {
		return examTime;
	}
	
	
	
	public void addQuestion(Question question, int score)
	{
		if(questions == null)
		{
			questions = new ArrayList<Question>();			
			scores=new HashMap<Question,Integer>();
		}
		questions.add(question);
		scores.put(question,score);
	}
	
	public String toString()
	{
		StringBuilder questionSB = new StringBuilder();
		for(Question question : questions)
			questionSB.append(question+", score("+scores.get(question)+")\n");
		return "ID("+ID+"), course("+course+"), subject("+subject+"), author("+author+"), creationDate("+creationDate+"), examTime("+examTime+") \nquestions:\n"+questionSB+" \n";
		
	}
}
