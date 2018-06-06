package Server;
import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JList;
import javax.swing.JTextArea;

import Classes.Course;
import Classes.Exam;
import Classes.Packet;
import Classes.Person;
import Classes.Question;
import Classes.Subject;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Server extends AbstractServer {
	final public static int DEFAULT_PORT = 5555;
	public static Connection conn=null;
	ExecutorService pool;
	String[] databaseConnection;
	List messages;
	
	public Server(int port,String[] databaseConnection,List messages) 
	{
		super(port);
		this.messages=messages;
		pool=Executors.newCachedThreadPool();
		connectToDatabase(databaseConnection);
		
	}

	public void connectToDatabase(String[] databaseConnection ) {
		
		this.databaseConnection=databaseConnection;
		try 
		{
		  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			try {
				close();
				messages.add(ex.getMessage());
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		try 	
		{
			
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/aes?serverTimezone=UTC&useSSL=false","root","braude");			
			conn = DriverManager.getConnection(databaseConnection[0],databaseConnection[1],databaseConnection[2]);
			System.out.println("SQL connection succeed");
			messages.add("SQL connection succeed");
		} 
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			messages.add(ex.getMessage());
			try {
				close();
				conn.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}	
}
	
	@Override
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		System.out.println("Packet received from: "+client);
		messages.add("Packet received from: "+client);
		pool.execute(new Runnable() {
			public void run()
			{	
				try {					
					PacketHandler.handlePacket((Packet)msg,client);
				} catch (Exception e) {
					e.printStackTrace();
					messages.add(e.getMessage());
				}
			}
		});
	}
	
	protected void serverStarted()
	{
	    System.out.println("Server listening for connections on port " + getPort());
	    messages.add("Server listening for connections on port " + getPort());
		toDo();
	}
	
	protected void serverStopped()
	{
		System.out.println("Server has stopped listening for connections.");
		 messages.add("Server has stopped listening for connections.");
	}

	
	public  void toDo()
	{
/*		Subject subject = new Subject("20","Math");
		Course course = new Course("00","Algebra1",subject.getID());
		ArrayList<Question> questionList = new ArrayList<Question>();
		Question question1 = new Question("20000",new Person("313740664","Jonathan Gabbay"),"1+1?","1","2","3","4",2);
		Question question2 = new Question("20001",new Person("201232055","Alon Deutsch"),"2*5?","1","10","20","8",2);
		questionList.add(question1);
		questionList.add(question2);	
		HashMap<Question,Integer> scores = new HashMap<Question,Integer>();
		scores.put(question1, 75);
		scores.put(question2, 25);
		Exam exam = new Exam("2000",course,subject,new Person("313740664","Jonathan Gabbay"),"06\\03\\2018",questionList,scores,180);
		ExamController.addExamToRepository(exam);*/
		/*for(Exam exam1 : ExamController.getExamsList())
			System.out.println(exam1);*/
		//ExamController.removeExamFromRepository("200001");
	}

	protected void clientConnected(ConnectionToClient client) {
		System.out.println("This client has been connected: "+client);
		 messages.add("This client has been connected: "+client);
	}
	
	
	synchronized protected void clientDisconnected(ConnectionToClient client)
	{
			System.out.println("This client has been disconnected: "+client);
			messages.add("This client has been disconnected: "+client);
	}

	
	 public void shutDown()
	 {
		 
		 try { 
			 close();
			conn.close();			
		} catch (Exception e) {		
			e.printStackTrace();
			messages.add(e.getMessage());
		}
		 
	 }
	
	
	/*public static void main(String[] args) 
	{		int port = 0; //Port to listen on
			String[] databaseConnection= {"jdbc:mysql://localhost/aes?serverTimezone=UTC&useSSL=false","root","braude"};
		try
		{
			port = Integer.parseInt(args[0]); //Get port from command line
		}
		catch(Throwable t)
		{
			port = DEFAULT_PORT; //Set port to 5555
		}
		Server sv = new Server(port,databaseConnection);
		try 
		{
			sv.listen(); //Start listening for connections
		} 
		catch (Exception ex) 
		{
			System.out.println("ERROR - Could not listen for clients!");
		}
		
	}*/
	

}  
		