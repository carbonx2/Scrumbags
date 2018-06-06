package ClientGui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Course;
import Classes.Subject;
import Classes.Teacher;
import Client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class SubjectAndCourseSelectionController implements Initializable {
		Teacher teacher = (Teacher) Client.user; 	 
		
		@FXML
		Label Message;
	
	  @FXML
	    private ComboBox<Course> CourseComboBox;

	    @FXML
	    private ComboBox<Subject> SubjectComboBox;
	    
	    
	    @FXML
	    private Button ConfirmButton;

	    @FXML
	    private Button CancelButton;
	    
	
	    
	    public void subjectSelectionListener()
	    {
	    	updateCoursesBox(SubjectComboBox.getValue().getID());
	    }
	    
	    public void courseSelectionListener()
	    {
	    	ConfirmButton.setDisable(false);
	    }
	    
	    public void confirmButtonListener(ActionEvent event)
	    {
	    	Stage examCreationWindow = (Stage) ConfirmButton.getScene().getWindow();
	    	
	    	examCreationWindow.setTitle("Create exam");
	    	Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/ClientGui/CreateExamScene.fxml"));
				Scene scene = new Scene(root);				
		    	examCreationWindow.setScene(scene);
		    	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		    	examCreationWindow.setX((primScreenBounds.getWidth() - examCreationWindow.getWidth()) / 2);
		    	examCreationWindow.setY((primScreenBounds.getHeight() - examCreationWindow.getHeight()) / 2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    }
	    public void cancelButtonListener(ActionEvent event)
	    {
	    	((Node) event.getSource()).getScene().getWindow().hide();
	    }
	    
	  
		
	    public void updateCoursesBox(String subjectID)
	    {
	    	CourseComboBox.getItems().addAll(teacher.getCoursesOfSubject(subjectID));
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
	    }
	    
	    
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateSubjectBox();
		setConverters();
	}

}
