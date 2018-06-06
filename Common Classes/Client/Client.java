package Client;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Classes.Course;
import Classes.Packet;
import Classes.Subject;
import Classes.Teacher;
import Classes.User;
import Server.PacketHandler;
import ocsf.client.AbstractClient;

public class Client extends AbstractClient {
	
	private static int requestID = 0;
	private HashMap<Integer,Packet> response;
	private ExecutorService pool;	
	public static User user;
	
	public Client(String host, int port) throws IOException {
		super(host, port);		
		openConnection();		
		response= new HashMap<Integer,Packet>();
		pool=Executors.newCachedThreadPool();
		HashSet<Subject> subjects = new HashSet<Subject>();
		subjects.add(new Subject("20", "Math"));
		HashSet<Course> courses = new HashSet<Course>();
		courses.add(new Course("00","Algebra1","20"));
		user = new Teacher("313740664","braude","Jonathan","Gabbay",subjects,courses);

		
	}

	public synchronized Packet getResponse(int responseID) {
		while(true)
		{
			if (response.get(responseID)!=null)
				return response.remove(responseID); 
			else
			{
				try {
					wait();
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				
			}
		}	
	}
	
	@Override
	protected void handleMessageFromServer(Object msg) {
		
		pool.execute(new Runnable() {
			public void run()			{					
				handleResponse(msg);								
			}
		});
	}
	
	synchronized public void handleResponse(Object msg)
	{	
		Packet packet=(Packet)msg;		
		response.put(packet.getID(),packet);
		notifyAll();
	}
	
	public final int sendToServerAJ(Packet packet)
	{
		int ID=generateID();
		packet.setID(ID);
		try {
			sendToServer(packet);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return ID;
	}
	
	
	private final int generateID()
	{
		requestID=(requestID+1)% (Integer.MAX_VALUE-1);
		return requestID;
	}

	
	
}
	  


	  
