package Classes;
import java.io.Serializable;
import java.util.Arrays;

public class Question implements Serializable {
	
	String ID;
	Person author;	
	String question;
	String[] answers;	
	int correctAnswerIndex;
	
	
	public Question(String subjectID, Person author, String question, String answer1, String answer2, String answer3, String answer4, int correctAnswerIndex)
	{
		super();
		this.ID=subjectID;
		this.author=author;
		this.question=question;
		this.answers=new String[4];
		this.answers[0]=answer1;
		this.answers[1]=answer2;
		this.answers[2]=answer3;
		this.answers[3]=answer4;
		this.correctAnswerIndex=correctAnswerIndex;
	}
	
	public String getID() { 
		return ID;
	}
	
	public Person getAuthor() {
		return author;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer(int answerNumber) {
		return answers[answerNumber-1];
	}
	
	public String getCorrectAnswer() {
		return answers[correctAnswerIndex-1];
	}
	
	public int getCorrectAnswerIndex()
	{
		return correctAnswerIndex;
	}
	public String toString()
	{
		return "ID("+ID+"), author("+author+"), question("+question+"), answers("+Arrays.toString(answers)+"), correctAnswer("+getCorrectAnswer()+")";
	}
}
