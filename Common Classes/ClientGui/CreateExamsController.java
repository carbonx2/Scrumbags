package ClientGui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Classes.Question;
import Classes.QuestionInExam;
import Client.QuestionController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

public class CreateExamsController implements Initializable{
	ObservableList<QuestionInExam> questionsInExamList = FXCollections.observableArrayList();
	ObservableList<Question> questionsList = FXCollections.observableArrayList();
	@FXML
    private TableView<QuestionInExam> QuestionsInExamList;

    @FXML
    private TableColumn<QuestionInExam, String> QuestionsColumn;

    @FXML
    private TableColumn<QuestionInExam, String> ScoresColumn;

    @FXML
    private ListView<Question> QuestionsList;

    @FXML
    private TextArea QuestionPreviewText;

    @FXML
    private Button AddQuestionToExamButton;

    @FXML
    private Button RemoveQuestionFromExamButton;

    
    public void updateQuestionsList() {
    	ArrayList<Question> questionlist = QuestionController.getQuestionList();
    	questionsList.setAll(questionlist);
    }
    
    public void showQuestionPreview(Question question) {
		QuestionPreviewText.setText("Question: "+question.getQuestion()+"\n\n1)"+question.getAnswer(1)+"\n2)"+question.getAnswer(2)+"\n3)"+question.getAnswer(3)+"\n4)"+question.getAnswer(4)+"\n\nAuthor: "+question.getAuthor().getName());
	}
    
    public void addQuestionToExam(Question question) {
    	questionsInExamList.add(new QuestionInExam(question,0));
    	questionsList.remove(question);
    }
    
    public void removeQuestionFromExam(QuestionInExam question) {
    	questionsList.add(question.getQuestion());
    	questionsInExamList.remove(question);
    	
    }
    
    
    public void leftArrowButtonClicked()
    {
    	Question question = QuestionsList.getSelectionModel().getSelectedItem();
    	if(question!=null)
    		addQuestionToExam(question);
    }
    
    public void rightArrowButtonClicked() 
    {
    	QuestionInExam question = QuestionsInExamList.getSelectionModel().getSelectedItem();
    	if(question!=null)
    		removeQuestionFromExam(question);
    }
    
    public void pressEnter()
   {
	   java.awt.Robot robot;
	try {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	} catch (AWTException e) {		
		e.printStackTrace();
	}
		
   }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		updateQuestionsList();				
		QuestionsList.setItems(questionsList);
		QuestionsInExamList.setItems(questionsInExamList);
		QuestionsColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getQuestion().getQuestion()));
		ScoresColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getScore().toString()));
		QuestionsInExamList.setEditable(true);
		ScoresColumn.setEditable(true);
		ScoresColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		ScoresColumn.setOnEditCommit((CellEditEvent<QuestionInExam, String> t) -> {
			QuestionInExam qis = QuestionsInExamList.getSelectionModel().getSelectedItem();
				if(t.getNewValue().matches("[0-9]*"))
					qis.setScore(Integer.parseInt(t.getNewValue()));
			    else
			    	QuestionsInExamList.refresh(); 	
		});
		
    	QuestionsList.setCellFactory(lv -> {
            TextFieldListCell<Question> cell = new TextFieldListCell<Question>(); 
            cell.setConverter(new StringConverter<Question>() {
                @Override
                public String toString(Question question) {
                    return question.getQuestion();
                }
                @Override
                public Question fromString(String string) {
                	return null;
                }
            });
            return cell;
        });
    	

    	QuestionsList.getSelectionModel().selectedItemProperty().addListener(e -> {
    		Question question = QuestionsList.getSelectionModel().getSelectedItem();
    		if(question != null)
    			showQuestionPreview(question);
    	});
		
    	QuestionsInExamList.getSelectionModel().selectedItemProperty().addListener(e -> {
    		QuestionInExam questionInExam = QuestionsInExamList.getSelectionModel().getSelectedItem();
    		if(questionInExam != null) 
    			showQuestionPreview(questionInExam.getQuestion());
    			
    	});
	}

	


}
