package ClientGui;

import Classes.Packet;

import Classes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class LoginPanel extends javax.swing.JPanel {   
   

    
    private boolean VISIBLE; 
    public static User user;
    
    public LoginPanel() {
        initComponents();         
        VISIBLE=false;        
       	 		
          	if(!MainFrame.connected) 
          	{
          		connectButton.setEnabled(true);
          		Login_Button.setEnabled(false);
          		connectionLabel.setText("Disconnected");
          		connectionLabel.setForeground(Color.RED);
          		connectButton.setEnabled(true);
                portTextField.setVisible(true);
                addressTextField.setVisible(true);
                addressLabel.setVisible(true);
                portLabel.setVisible(true);
          	}
          	else
          	{
          		connectButton.setEnabled(false);
          		connectionLabel.setText("Connected");
          		connectionLabel.setForeground(Color.GREEN);
          		Login_Button.setEnabled(true);
          		connectButton.setEnabled(false);
                portTextField.setVisible(false);
                addressTextField.setVisible(false);
                addressLabel.setVisible(false);
                portLabel.setVisible(false);
          	}
          		
                     	
        	                	
    
    }

    private void initComponents() {

        Login_Button = new javax.swing.JButton();
        Password_Field = new javax.swing.JPasswordField();
        User_Name_Field = new javax.swing.JTextField();
        Show_Pass_Box = new javax.swing.JCheckBox();
        incorrectLabel = new javax.swing.JLabel();
        Pasword_Label = new javax.swing.JLabel();
        User_Name_Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loggedInLabel = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        connectionLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setAlignmentX(0.0F);

        Login_Button.setText("Login");
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonActionPerformed(evt);
            }
        });

        Password_Field.setPreferredSize(new java.awt.Dimension(111, 25));
        Password_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Password_FieldActionPerformed(evt);
            }
        });

        User_Name_Field.setPreferredSize(new java.awt.Dimension(111, 25));
        User_Name_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Name_FieldActionPerformed(evt);
            }
        });

        Show_Pass_Box.setBackground(new java.awt.Color(51, 51, 51));
        Show_Pass_Box.setForeground(new java.awt.Color(255, 255, 255));
        Show_Pass_Box.setText("Show Password");
        Show_Pass_Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Show_Pass_BoxActionPerformed(evt);
            }
        });

        incorrectLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        incorrectLabel.setForeground(new java.awt.Color(255, 51, 51));
        incorrectLabel.setAlignmentX(0.5F);

        Pasword_Label.setForeground(new java.awt.Color(255, 255, 255));
        Pasword_Label.setText("Password");

        User_Name_Label.setForeground(new java.awt.Color(255, 255, 255));
        User_Name_Label.setText("UserName");

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("A E S");

        loggedInLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loggedInLabel.setForeground(new java.awt.Color(255, 51, 51));

        connectButton.setForeground(new java.awt.Color(0, 102, 102));
        connectButton.setText("Connect");
        connectButton.setMaximumSize(new java.awt.Dimension(87, 23));
        connectButton.setMinimumSize(new java.awt.Dimension(87, 23));
        connectButton.setPreferredSize(new java.awt.Dimension(87, 23));
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        connectionLabel.setMaximumSize(new java.awt.Dimension(110, 20));
        connectionLabel.setMinimumSize(new java.awt.Dimension(110, 20));
        connectionLabel.setPreferredSize(new java.awt.Dimension(110, 20));

        portTextField.setText("5555");
        portTextField.setMaximumSize(new java.awt.Dimension(70, 20));
        portTextField.setMinimumSize(new java.awt.Dimension(70, 20));
        portTextField.setPreferredSize(new java.awt.Dimension(70, 20));
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });

        addressTextField.setText("localhost");
        addressTextField.setMaximumSize(new java.awt.Dimension(120, 20));
        addressTextField.setMinimumSize(new java.awt.Dimension(120, 20));
        addressTextField.setName(""); // NOI18N
        addressTextField.setPreferredSize(new java.awt.Dimension(120, 20));
        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });

        portLabel.setForeground(new java.awt.Color(255, 255, 255));
        portLabel.setText("Port:");
        portLabel.setMaximumSize(new java.awt.Dimension(43, 14));
        portLabel.setMinimumSize(new java.awt.Dimension(43, 14));
        portLabel.setPreferredSize(new java.awt.Dimension(43, 14));

        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Address:");
        addressLabel.setMaximumSize(new java.awt.Dimension(60, 14));
        addressLabel.setMinimumSize(new java.awt.Dimension(60, 14));
        addressLabel.setPreferredSize(new java.awt.Dimension(60, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 296, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Pasword_Label)
                .addGap(59, 59, 59)
                .addComponent(Login_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Show_Pass_Box, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(User_Name_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(User_Name_Label))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(incorrectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(loggedInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(incorrectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(User_Name_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(User_Name_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pasword_Label)
                    .addComponent(Login_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Show_Pass_Box, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
    }
    
    
    protected void addressTextFieldActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	protected void portTextFieldActionPerformed(ActionEvent evt) {
		
		
	}

	private void Password_FieldActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void User_Name_FieldActionPerformed(java.awt.event.ActionEvent evt) {
    
    }

    private void Show_Pass_BoxActionPerformed(java.awt.event.ActionEvent evt) {
      if(VISIBLE)
        {
            Password_Field.setEchoChar('*');
            VISIBLE=false;
        }
        else
        {
             Password_Field.setEchoChar((char)0);
             VISIBLE=true;
        }
            
    }
    
    
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    	Thread thread = new Thread(new Runnable(){
            
            public void run()
            {
              String address=addressTextField.getText();
              int port =Integer.parseInt(portTextField.getText());
              MainFrame.connect(address,port);
              
          	if(MainFrame.connected)
          	{          		
          		
          		connectButton.setEnabled(false);
          		connectionLabel.setText("Connected");
          		connectionLabel.setForeground(Color.GREEN);
          		Login_Button.setEnabled(true);
          		connectButton.setEnabled(false);
                portTextField.setVisible(false);
                addressTextField.setVisible(false);
                addressLabel.setVisible(false);
                portLabel.setVisible(false);
          	}
          	else
          	{          		
          		connectButton.setEnabled(true);
          		Login_Button.setEnabled(false);
          		connectionLabel.setText("Disconnected");
          		connectionLabel.setForeground(Color.RED);
          		connectButton.setEnabled(true);
                portTextField.setVisible(true);
                addressTextField.setVisible(true);
                addressLabel.setVisible(true);
                portLabel.setVisible(true);
          	}
          	
        }
        });          
           thread.start();
    	
    	
    }           

    private void Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Thread thread = new Thread(new Runnable(){
          
          public void run()
          {
            
        	  loggedInLabel.setText("");
        	  incorrectLabel.setText("");
        	  ArrayList<String> login= new ArrayList<String>();
        	  login.add(User_Name_Field.getText());
        	  login.add(String.valueOf(Password_Field.getPassword()));
        	  Packet packet=new Packet("LogIn", login);
        try {
        	 
            int request=MainFrame.client.sendToServerAJ(packet);             
            
            Packet response=MainFrame.client.getResponse(request);           
            if(response.getOperation().equals("Incorrect"))
            {
                incorrectLabel.setText("Incorrect Username or Password");
                Thread.sleep(2000);
                incorrectLabel.setText("");                
            }
            	 
            else if(response.getOperation().equals("AlreadyLoggedIn")) 
            {
               loggedInLabel.setText("You already logged in"); 
               Thread.sleep(2000);               
               loggedInLabel.setText("");
            }
            
            else  
            {
            	user=(User)response.getData();
            	homePage();
            }	
            
                     
       }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
      }
      });          
         thread.start();
    }         
              
public void homePage()
    {
    	MainFrame.contentPane.removeAll();   
    	MainFrame.contentPane.setPreferredSize(new Dimension(1260, 800));
    	MainFrame.contentPane.add(new HomePagePanel());
        MainFrame.contentPane.revalidate();
    	MainFrame.contentPane.repaint();
  	  	JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(MainFrame.contentPane);  	  
  	  	frame.pack();
  	  	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();  	  	
  	  	frame.repaint();
  	  	frame.revalidate();
  	    frame.setLocation(dim.width/2-MainFrame.contentPane.getSize().width/2, dim.height/2-MainFrame.contentPane.getSize().height/2);
  	  
    }
          
  
       
    
  
    private javax.swing.JButton Login_Button;
    private javax.swing.JPasswordField Password_Field;
    private javax.swing.JLabel Pasword_Label;
    private javax.swing.JCheckBox Show_Pass_Box;
    private javax.swing.JTextField User_Name_Field;
    private javax.swing.JLabel User_Name_Label;
    private javax.swing.JLabel incorrectLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loggedInLabel;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
}
