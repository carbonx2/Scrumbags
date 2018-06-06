package ClientGui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Classes.Packet;
import Client.QuestionsPanel;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;


public class HomePagePanel extends javax.swing.JPanel {

    
    public HomePagePanel() {
    	
    	setBackground(SystemColor.info);
        initComponents(); 
    }

   
   
    private void initComponents() {

        HomeButtonsPanel = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 0));
        filler2.setBackground(new Color(51, 255, 0));
        ManageQuestionsButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        ManageExamsButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        StatisticalAnalysisButton = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        MessagesButton = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        MyProfileButton = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 250), new java.awt.Dimension(0, 250), new java.awt.Dimension(32767, 200));
        LogoutButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(100, 32767));
        HomeMainPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(200, 800));
        setLayout(new java.awt.BorderLayout());

        HomeButtonsPanel.setBackground(SystemColor.info);
        HomeButtonsPanel.setMinimumSize(new java.awt.Dimension(200, 800));
        HomeButtonsPanel.setPreferredSize(new java.awt.Dimension(200, 800));
        HomeButtonsPanel.setLayout(new javax.swing.BoxLayout(HomeButtonsPanel, javax.swing.BoxLayout.Y_AXIS));
        HomeButtonsPanel.add(filler2);

        ManageQuestionsButton.setText("Manage Questions");
        ManageQuestionsButton.setMaximumSize(new java.awt.Dimension(150, 40));
        ManageQuestionsButton.setMinimumSize(new java.awt.Dimension(150, 40));
        ManageQuestionsButton.setPreferredSize(new java.awt.Dimension(150, 40));        
        ManageQuestionsButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt)
        	{
        		manageQuestionAction(evt);
        	}
        });
        HomeButtonsPanel.add(ManageQuestionsButton);
        HomeButtonsPanel.add(filler3);

        ManageExamsButton.setText("Manage Exams");
        ManageExamsButton.setEnabled(false);
        ManageExamsButton.setMaximumSize(new java.awt.Dimension(150, 40));
        ManageExamsButton.setMinimumSize(new java.awt.Dimension(150, 40));
        ManageExamsButton.setPreferredSize(new java.awt.Dimension(150, 40));
        HomeButtonsPanel.add(ManageExamsButton);
        HomeButtonsPanel.add(filler4);

        StatisticalAnalysisButton.setText("Statistical Analysis");
        StatisticalAnalysisButton.setEnabled(false);
        StatisticalAnalysisButton.setMaximumSize(new java.awt.Dimension(150, 40));
        StatisticalAnalysisButton.setMinimumSize(new java.awt.Dimension(150, 40));
        StatisticalAnalysisButton.setPreferredSize(new java.awt.Dimension(150, 40));
        HomeButtonsPanel.add(StatisticalAnalysisButton);
        HomeButtonsPanel.add(filler5);

        MessagesButton.setText("Messages ");
        MessagesButton.setEnabled(false);
        MessagesButton.setMaximumSize(new java.awt.Dimension(150, 40));
        MessagesButton.setMinimumSize(new java.awt.Dimension(150, 40));
        MessagesButton.setPreferredSize(new java.awt.Dimension(150, 40));
        HomeButtonsPanel.add(MessagesButton);
        HomeButtonsPanel.add(filler6);

        MyProfileButton.setText("My Profile");
        MyProfileButton.setEnabled(false);
        MyProfileButton.setMaximumSize(new java.awt.Dimension(150, 40));
        MyProfileButton.setMinimumSize(new java.awt.Dimension(150, 40));
        MyProfileButton.setPreferredSize(new java.awt.Dimension(150, 40));
        HomeButtonsPanel.add(MyProfileButton);
        HomeButtonsPanel.add(filler7);

        LogoutButton.setText("Logout");
        LogoutButton.setMaximumSize(new java.awt.Dimension(150, 40));
        LogoutButton.setMinimumSize(new java.awt.Dimension(150, 40));
        LogoutButton.setPreferredSize(new java.awt.Dimension(150, 40));
        LogoutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt)
        	{
        		logOutEventAction(evt);
        	}
        });
        HomeButtonsPanel.add(LogoutButton);
        HomeButtonsPanel.add(filler1);

        add(HomeButtonsPanel, java.awt.BorderLayout.LINE_START);

        HomeMainPanel.setBackground(SystemColor.activeCaption);
        HomeMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HomeMainPanel.setPreferredSize(new java.awt.Dimension(1080, 800));

        javax.swing.GroupLayout HomeMainPanelLayout = new javax.swing.GroupLayout(HomeMainPanel);
        HomeMainPanel.setLayout(HomeMainPanelLayout);
        HomeMainPanelLayout.setHorizontalGroup(
            HomeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        HomeMainPanelLayout.setVerticalGroup(
            HomeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );

        add(HomeMainPanel, java.awt.BorderLayout.CENTER);
    }

    
    public void manageQuestionAction(ActionEvent evt)
    {
    	Thread thread = new Thread(new Runnable(){
            
            public void run()
            {                        
              changePanel(new QuestionsPanel());	
                                     
         }                
        });          
           thread.start();
    }
    public void logOutEventAction(ActionEvent evt)
    {
    	Thread thread = new Thread(new Runnable(){
            
            public void run()
            {                        
              try {
				MainFrame.client.sendToServer(new Packet("LogOut",LoginPanel.user.getID()));
				MainFrame.contentPane.removeAll();   
		    	MainFrame.contentPane.setPreferredSize(new Dimension(773, 448));
		    	MainFrame.contentPane.add(new LoginPanel());
		        MainFrame.contentPane.revalidate();
		    	MainFrame.contentPane.repaint();
		  	  	JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(MainFrame.contentPane);  	  
		  	  	frame.pack();
		  	  	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();  	  	
		  	  	frame.repaint();
		  	  	frame.revalidate();
		  	    frame.setLocation(dim.width/2-MainFrame.contentPane.getSize().width/2, dim.height/2-MainFrame.contentPane.getSize().height/2);
			} catch (IOException e) {				
				e.printStackTrace();
			}	
                                     
         }                
        });          
           thread.start();
    }
    
public void changePanel(JPanel panel)
{
     BorderLayout layout = (BorderLayout) getLayout();
     remove(layout.getLayoutComponent(BorderLayout.CENTER));
     this.add(BorderLayout.CENTER,panel);
     repaint();
     revalidate();
}

    
   
    private javax.swing.JPanel HomeButtonsPanel;
    private javax.swing.JPanel HomeMainPanel;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton ManageExamsButton;
    private javax.swing.JButton ManageQuestionsButton;
    private javax.swing.JButton MessagesButton;
    private javax.swing.JButton MyProfileButton;
    private javax.swing.JButton StatisticalAnalysisButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    
}
