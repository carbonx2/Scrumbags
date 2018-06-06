package ClientGui;


import java.io.IOException;



import Client.Client;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static Client client;
	final static int DEFAULT_PORT = 5555;

	@Override
	public void start(Stage primaryStage) {
		try {
			client = new Client("localhost", DEFAULT_PORT); 	
	
			Parent root;
			primaryStage.setOnCloseRequest(e -> {
				Platform.exit() ;
				System.exit(1); 
			});
			  
	    	try {
				root = FXMLLoader.load(getClass().getResource("/ClientGui/ManageExamsScene.fxml"));
				Scene scene = new Scene(root);
		    	primaryStage.setScene(scene);		
		    	primaryStage.show();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		catch (Exception e) { 
			e.printStackTrace(); 
		}		
						
						
	}
	

	public static void main(String[] args) {		
		launch(args);
		
	}
}
