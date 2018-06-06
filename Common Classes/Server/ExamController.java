package Server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import Classes.Course;
import Classes.Exam;
import Classes.Person;
import Classes.Question;
import Classes.Subject;

public class ExamController {
	
	
	public static String addExamToRepository(Exam exam)
	{
		int[] indexArray= new int[100];
		int count=0, newIndexOfExam=0;
		String examID=exam.getID();
		ArrayList<Question> questionsList = exam.getQuestions();
		HashMap<Question, Integer> scores = exam.getScores();
		Statement stmt;
		try {
			stmt = Server.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID FROM EXAMS WHERE ID LIKE '"+examID+"%';");
			PreparedStatement ps=Server.conn.prepareStatement("INSERT INTO EXAMS VALUES (?,?,?,?,?,?);");	
			while(rs.next()) { 			
				indexArray[Integer.parseInt(rs.getString(1))%100]=1;
				count++;
			}
			
			for(newIndexOfExam = 0 ; newIndexOfExam < count+1 ; newIndexOfExam++)
				if(indexArray[newIndexOfExam]==0)
					break;
			examID+=String.format("%02d", newIndexOfExam);
			ps.setString(1, examID);
			ps.setString(2, exam.getCourse().getID());
			ps.setString(3, exam.getSubject().getID());						
			ps.setString(4, exam.getAuthor().getID());			
			ps.setString(5, exam.getCreationDate());
			ps.setInt(6, exam.getExamTime());
			ps.execute();
			rs.close();
			stmt = Server.conn.createStatement();
			
			for(Question question : questionsList) {
				stmt.executeUpdate("INSERT INTO EXAMSQUESTIONS VALUES ('"+examID+"','"+question.getID()+"','"+scores.get(question)+"');");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "Failure";
		}
		return "Success";	
	}
	
	public static ArrayList<Exam> getExamsList(){
		return getExamsListBySubject(null);
	}
	
	 public static ArrayList<Exam> getExamsListBySubject(String subject)
	 {
		 Statement stmt,stmt1;
		 ArrayList<Exam> examsList = new ArrayList<Exam>();
		 Course examCourse;
		 Subject examSubject;
		 Person examAuthor;
		 Exam exam;
		 HashMap<Question,Integer> questionsScores;			
		 ArrayList<Question> questionsList;	
		
		try {
			stmt = Server.conn.createStatement();	
			stmt1 = Server.conn.createStatement();
			ResultSet rs;
			if(subject!=null)
				rs = stmt.executeQuery("SELECT E.ID, C.ID, C.NAME, S.ID, S.NAME, T.ID, T.FIRSTNAME, T.LASTNAME, E.CREATIONDATE, E.EXAMTIME FROM EXAMS E, COURSES C, SUBJECTS S, TEACHERS T WHERE E.SUBJECT = '"+subject+"' AND E.COURSE = C.ID AND E.SUBJECT = S.ID AND E.AUTHOR = T.ID ;");
			else
				rs = stmt.executeQuery("SELECT E.ID, C.ID, C.NAME, S.ID, S.NAME, T.ID, T.FIRSTNAME, T.LASTNAME, E.CREATIONDATE, E.EXAMTIME FROM EXAMS E, COURSES C, SUBJECTS S, TEACHERS T WHERE E.COURSE = C.ID AND E.SUBJECT = S.ID AND E.AUTHOR = T.ID ;");
			ResultSet rs1;
			while(rs.next())
			{
				examCourse = new Course(rs.getString(2),rs.getString(3),rs.getString(4));
				examSubject = new Subject(rs.getString(4),rs.getString(5));
				examAuthor = new Person(rs.getString(6),rs.getString(7)+" "+rs.getString(8));
				questionsList = new ArrayList<Question>();
				questionsScores = new HashMap<Question,Integer>();
				rs1 = stmt1.executeQuery("SELECT T.ID, T.FIRSTNAME, T.LASTNAME, Q.ID, Q.QUESTION, Q.ANSWER1, Q.ANSWER2, Q.ANSWER3, Q.ANSWER4, Q.CORRECTANSWER, EQ.SCORE FROM TEACHERS T, QUESTIONS Q, EXAMSQUESTIONS EQ WHERE EQ.EXAM='"+rs.getString(1)+"' AND EQ.QUESTION = Q.ID AND T.ID = Q.AUTHOR ;");
				
				while (rs1.next())
				{
					Person author = new Person(rs1.getString(1),rs1.getString(2)+" "+rs1.getString(3));
					Question question = new Question(rs1.getString(4), author, rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getInt(10));
					questionsList.add(question);
					questionsScores.put(question, rs1.getInt(11));					
					
				}
				exam = new Exam (rs.getString(1), examCourse, examSubject, examAuthor, rs.getString(9), questionsList, questionsScores, rs.getInt(10));
				examsList.add(exam);						
				
			}
			return examsList;
	
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
	}
	 

		public static String removeExamFromRepository(String ID)
		{
			Statement stmt;
			try {
				stmt = Server.conn.createStatement();
				stmt.executeUpdate("DELETE FROM EXAMS WHERE ID = '"+ID+"'");
				return "Success";
			} catch (SQLException e) {
				e.printStackTrace();
				return "Failure";
			}
				
		}


}



