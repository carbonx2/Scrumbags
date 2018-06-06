package ClientGui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Classes.Course;
import Classes.Exam;
import Classes.Subject;
import Classes.Teacher;
import Client.Client;
import Client.ExamController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ManageExamsController implements Initializable {
	Teacher teacher = (Teacher) Client.user; 	 
	ArrayList<Exam> examsList;
	
	
    @FXML
    private Tab ExamsTab;

    @FXML
    private BorderPane ExamsPane;

    @FXML
    private AnchorPane ButtonsPane;

    @FXML
    private Button CreateExamButton;

    @FXML
    private Button RemoveExamButton;

    @FXML
    private Button ViewExamButton;

    @FXML
    private Button ExecuteExamButton;

    @FXML
    private AnchorPane ExamPane;

    @FXML
    private ListView<Exam> ExamsList;

    @FXML
    private ComboBox<Course> CourseComboBox;

    @FXML
    private ComboBox<Subject> SubjectComboBox;

    @FXML
    private Button ReloadExamsButton;

    @FXML
    private AnchorPane ExamPreviewPane;

    @FXML
    private Label CourseNameLabel;

    @FXML
    private Label AuthorLabel;

    @FXML
    private Label DateLabel;

    @FXML
    private Label FreeTextLabel;

    @FXML
    private Label ExamTimeLabel;

    @FXML
    private Tab ExecutedExamsTab;

    @FXML
    private Tab FinishedExamsTab;
    
    public void reloadClickedListener()
    {    	  	  	
    	   
            if(SubjectComboBox.getValue() != null) {
            	updateExamListBySubject(SubjectComboBox.getValue().getID());
            	  if(CourseComboBox.getValue() != null) 
                  	updateExamListByCourse(CourseComboBox.getValue().getID());   
            }
             else
            	ExamsList.getItems().clear();
                   

    }
    
    public void showExamPreview(Exam exam)
    {
    	ExamPreviewPane.setVisible(true);
    	CourseNameLabel.setText(exam.getCourse().getName());
    	DateLabel.setText(exam.getCreationDate());
    	AuthorLabel.setText(""+exam.getAuthor().getName());
    	ExamTimeLabel.setText("Exam time: "+exam.getExamTime());
    }
    
    public void subjectSelectionListner()
    {
    	updateCoursesBox(SubjectComboBox.getValue().getID());
    	updateExamListBySubject(SubjectComboBox.getValue().getID());
    }

    public void courseSelectionListner()
    {
    	updateExamListByCourse(CourseComboBox.getValue().getID());
    }
	
    public void updateCoursesBox(String subjectID)
    {
    	CourseComboBox.getItems().addAll(teacher.getCoursesOfSubject(subjectID));
    }
    
    public void updateExamListByCourse(String courseID)
    {
    	ExamsList.getItems().clear();
    	for(Exam exam : examsList) {
    		if(exam.getCourse().getID().equals(courseID))
    			ExamsList.getItems().add(exam);

    } 
    }
    
    public void updateExamListBySubject(String subjectID) {    		              
    	ExamsList.getItems().clear();
    	examsList = ExamController.getExamsListBySubject(subjectID);
    	ExamsList.getItems().addAll(examsList);	   	
    }
    
    public void createExamListener()
    {
    	Stage examCreationWindow = new Stage();
    	examCreationWindow.setTitle("Choose subject and course");
    	examCreationWindow.initModality(Modality.APPLICATION_MODAL);
    	Parent root;
		try {				
			root = FXMLLoader.load(getClass().getResource("/ClientGui/SubjectAndCourseSelectionScene.fxml"));
			Scene scene = new Scene(root);
	    	examCreationWindow.setScene(scene);
	    	examCreationWindow.showAndWait();
		} catch (IOException e) {			
			e.printStackTrace();
		}
    
    }
    
    public void updateSubjectBox()
    {    	
    	SubjectComboBox.getItems().addAll(teacher.getSubjects());	
    }
    
    public void setConverters() {
    	SubjectComboBox.setConverter(new StringConverter<Subject>() {
    		public String toString(Subject subject) {
    			return subject.getName();
    		}

			@Override
			public Subject fromString(String arg0) {			
				return null;
			}

    	}); 
    	
    	CourseComboBox.setConverter(new StringConverter<Course>() {
    		
    		public String toString(Course course) {
    			return course.getName();
    		}

			@Override
			public Course fromString(String arg0) {			
				return null;
			}

    	}); 
    	
    	ExamsList.setCellFactory(lv -> {
            TextFieldListCell<Exam> cell = new TextFieldListCell<Exam>(); 
            cell.setConverter(new StringConverter<Exam>() {
                @Override
                public String toString(Exam exam) {
                    return exam.getCreationDate()+"      Course: "+exam.getCourse().getName()+"      Author: "+exam.getAuthor().getName();
                }
                @Override
                public Exam fromString(String string) {
                	return null;
                }
            });
            return cell;
        });
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateSubjectBox();
		setConverters();
		
		ExamsList.getSelectionModel().selectedItemProperty().addListener(e -> {
			Exam exam = ExamsList.getSelectionModel().getSelectedItem();
			if(exam != null)
				showExamPreview(exam);
		});
		
		
	
		

	}
}
