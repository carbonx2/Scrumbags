package Client;

import java.util.ArrayList;

import Classes.Exam;
import Classes.Packet;
import ClientGui.Main;

public class ExamController {

	public static String addExamToRepository(Exam exam)
	{
		Packet packet = new Packet("AddExam",exam);
		int requestID = Main.client.sendToServerAJ(packet);
		return Main.client.getResponse(requestID).getOperation();
	}

	
	public static ArrayList<Exam> getExamsList() 
	{
		Packet packet = new Packet("GetExamsList",null);
		int requestID = Main.client.sendToServerAJ(packet);
		return (ArrayList<Exam>)Main.client.getResponse(requestID).getData();
	}
	
	public static ArrayList<Exam> getExamsListBySubject(String subject) 
	{
		Packet packet = new Packet("GetExamsListBySubject",subject);
		int requestID = Main.client.sendToServerAJ(packet);
		return (ArrayList<Exam>)Main.client.getResponse(requestID).getData();
	}
	
	
	public static String removeExam(String examID)
	{
		Packet packet = new Packet("RemoveExam",examID);
		int requestID = Main.client.sendToServerAJ(packet);
		return Main.client.getResponse(requestID).getOperation();
				
	}
}
