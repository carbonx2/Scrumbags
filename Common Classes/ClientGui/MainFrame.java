package ClientGui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Client.Client;


public class MainFrame extends JFrame {
	public static Client client;
	final static int DEFAULT_PORT = 5555;
	public static JPanel contentPane;
	public static boolean connected =false;

	public MainFrame() {
	    super("AES");
	    connect("localhost",DEFAULT_PORT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
		LoginPanel panel= new LoginPanel();		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(773, 448));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel, BorderLayout.CENTER);		 
		this.pack();		
		Set_Location();
        setResizable(false);   
	}
	 
	public static boolean connect(String address,int port)
	{
		try {
			client= new Client(address, port);	
		    connected=true;
		    return true;
			}
			
	    
	    catch(Exception e)
	    {	   	
	       	System.out.println(e.getMessage());
	    	connected=false;
	    	return false;
	    }
	}
	
	
	public void Set_Location()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);					
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		   

		
	}

}
