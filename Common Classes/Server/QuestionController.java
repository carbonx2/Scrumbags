package Server;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classes.Person;
import Classes.Packet;
import Classes.Question;

public class QuestionController {
	
	public static String addQuestionToRepository(Question question) {
		try {
			int[] indexArray= new int[1000];
			int count=0, newIndexOfQuestion=0;
			Statement stmt = Server.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID FROM QUESTIONS WHERE ID LIKE '"+question.getID()+"%';");
			PreparedStatement ps=Server.conn.prepareStatement("INSERT INTO QUESTIONS VALUES (?,?,?,?,?,?,?,?);");	
			while(rs.next()) { 			
				indexArray[Integer.parseInt(rs.getString(1))%1000]=1;
				count++;
			}
			
			for(newIndexOfQuestion = 0 ; newIndexOfQuestion < count+1 ; newIndexOfQuestion++)
				if(indexArray[newIndexOfQuestion]==0)
					break;
			ps.setString(1, question.getID()+String.format("%03d", newIndexOfQuestion));
			ps.setString(2, question.getAuthor().getID());
			ps.setString(3, question.getQuestion());
			ps.setString(4, question.getAnswer(1));
			ps.setString(5, question.getAnswer(2));
			ps.setString(6, question.getAnswer(3));
			ps.setString(7, question.getAnswer(4));
			ps.setInt(8, question.getCorrectAnswerIndex());
			ps.executeUpdate();
			return "Success";
		}   catch (SQLException e) {			
			e.printStackTrace();
			return "Failure";
		}
	}
	
	public static ArrayList<Question> getQuestionsList(){
		try {
			Statement stmt = Server.conn.createStatement();
			Statement stmt2 = Server.conn.createStatement();

			ResultSet rs1 = stmt.executeQuery("SELECT * FROM QUESTIONS;");
			ResultSet rs2;
			ArrayList<Question> arrayListOfQuestions = new ArrayList<Question>();
			while(rs1.next())
			{
				rs1.getString(2);
				rs2 = stmt2.executeQuery("SELECT FirstName, LastName FROM TEACHERS WHERE ID = '"+rs1.getString(2)+"';" );
				rs2.next();
				Person author = new Person(rs1.getString(2),rs2.getString(1)+" "+rs2.getString(2));
				Question question = new Question(rs1.getString(1),author, rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getInt(8));
				arrayListOfQuestions.add(question);
			}
			
			return arrayListOfQuestions;
			
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
				
			
	}
	
	public static String removeQuestion(String ID)
	{
		try {
			Statement st =Server.conn.createStatement();
			st.executeUpdate("DELETE FROM QUESTIONS WHERE ID='"+ID+"';");
			return "Success";
		} catch (SQLException e) {			
			e.printStackTrace();
			return "Failure";
		}
	}

	public static String updateCorrectAnswer(String ID,int indexNumber)
	{
		
		try {
			if(indexNumber<0||indexNumber>4)
				throw new Exception("Index out of bounds");
			Statement st= Server.conn.createStatement();
			st.executeUpdate("UPDATE QUESTIONS SET CorrectAnswer='"+indexNumber+"' WHERE ID='"+ID+"';");
			return "Success";
		} catch (Exception e) {			
			e.printStackTrace();
			return "Failure";
		}
	}
			 
		public static ArrayList<Question> getQuestionsOfSubject(String subject)
		{
			Statement st,st2;
			try {
				st = Server.conn.createStatement();
				st2=Server.conn.createStatement();
				ArrayList<Question> questions= new ArrayList<Question>();					
				ResultSet rs=st.executeQuery("SELECT * FROM QUESTIONS WHERE ID LIKE '"+subject+"%';" );					
				while (rs.next())
				{		
										
					ResultSet rs2 = st2.executeQuery("SELECT FirstName, LastName FROM TEACHERS WHERE ID ='"+rs.getString(2)+"';");
					rs2.next();
					Person author = new Person(rs.getString(2),rs2.getString(1)+" "+rs2.getString(2));
					questions.add(new Question(rs.getString(1),author,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
				}
				return questions;		
					
					
			} catch (SQLException e) {				
				e.printStackTrace();
				return null;
			}				
					
		}		
		
	}
	
	
