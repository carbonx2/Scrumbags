package Server;
import java.util.ArrayList;

import Classes.Exam;
import Classes.Packet;
import Classes.Permission;
import Classes.Question;
import Classes.User;
import ocsf.server.ConnectionToClient;

public class PacketHandler {

	public static void handlePacket(Packet packet,ConnectionToClient client) throws Exception {
		Packet userPacket;		
		Object data=null;
		String answer="Sucess";

		switch(packet.getOperation()) {
			case "AddQuestion":
				answer=QuestionController.addQuestionToRepository((Question)packet.getData());
				break;
			case "GetQuestionsList":				
				data=QuestionController.getQuestionsList();
				if(data==null)
					answer="Failure";
				break;
			case "RemoveQuestion":
				answer=QuestionController.removeQuestion((String)packet.getData());
				break;
			case "UpdateAnswer":
				answer=QuestionController.updateCorrectAnswer((String)((ArrayList)packet.getData()).get(0),(int)((ArrayList)packet.getData()).get(1));
				break;
			case "GetQuestionListBySubject":
				data=QuestionController.getQuestionsOfSubject((String)packet.getData());
				if(data==null)
					answer="Failure";
				break;
			case "AddExam":
				answer=ExamController.addExamToRepository((Exam)packet.getData());
				break;
			case "GetExamsList":
				data=ExamController.getExamsList();
				if(data==null)
					answer="Failure";
				break;
			case "GetExamsListBySubject":
				data=ExamController.getExamsListBySubject((String)packet.getData());
				if(data==null)
					answer="Failure";
				break;
			case "RemoveExam":
				answer=ExamController.removeExamFromRepository((String)packet.getData());
				break;
			case "LogIn":				
				Packet userPacket1;
				User user;
				String id = (String)((ArrayList)packet.getData()).get(0);
				String password = (String)((ArrayList)packet.getData()).get(1);
				String ip = client.getInetAddress().getHostAddress();
				user = UserController.logIn(id, password, ip);				
				if(user!=null)
				{    
					if(user.getPermission()==0)
					{
						userPacket1 = new Packet("AlreadyLoggedIn",user);
	 					userPacket1.setID(packet.getID());
                        client.sendToClient(userPacket1);
					}
					else {
					userPacket1 = new Packet("Success",user);
					userPacket1.setID(packet.getID());
                    client.sendToClient(userPacket1);
					}
                }
				else
               {					
					userPacket1 = new Packet("Incorrect",null);
					userPacket1.setID(packet.getID());
					client.sendToClient(userPacket1);
               }
				
				break;
			case "LogOut":
				UserController.logOut((String) packet.getData());
				break;
				
		}
		userPacket = new Packet(answer,data);
		userPacket.setID(packet.getID());
		client.sendToClient(userPacket);

	}
}
 