package Client;

import java.util.ArrayList;

import Classes.Packet;
import Classes.Question;
import ClientGui.Main;
import ClientGui.MainFrame;

public class QuestionController {

public static ArrayList<Question> getQuestionList()
{
	int ID=Main.client.sendToServerAJ(new Packet("GetQuestionsList",null));
	return (ArrayList<Question>) Main.client.getResponse(ID).getData();
}



public static void updateCorrectAnswer(String ID,int indexNumber)
{
	ArrayList arrayList = new ArrayList();
	arrayList.add(ID);
	arrayList.add(indexNumber);
	Main.client.sendToServerAJ(new Packet("UpdateAnswer",arrayList));
}
	
}
