package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionInExam implements Serializable {
	private Question question;
	private Integer score;
	private ArrayList<Note> notes;
	
	public QuestionInExam(Question question, int score) {
		this.question=question;
		this.score=score;
	}

	public Question getQuestion() {
		return question;
	}

	public Integer getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score=score;
	}
	
	}
