/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerFrame extends javax.swing.JFrame {

      private boolean VISIBLE;
        public ServerFrame() {
         super("A E S - Server");
        initComponents();
         addressLabel.setVisible(false);
        addressTextField.setVisible(false);
        Username.setVisible(false);
       uesrNameTextField.setVisible(false);
       passwordLabel.setVisible(false);
       passwordField.setVisible(false);
       ShowPasswordBox.setVisible(false);
        setResizable(false);
        set_Location();
    }

    
    private void initComponents() {

        contentpane = new javax.swing.JPanel();
        starttButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        messagesTextList = new java.awt.List();
        serverLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        editConnectionButton = new javax.swing.JButton();
        addressTextField = new javax.swing.JTextField();
        uesrNameTextField = new javax.swing.JTextField();
        ShowPasswordBox = new javax.swing.JCheckBox();
        Username = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));

        contentpane.setBackground(new java.awt.Color(51, 51, 51));
        contentpane.setMaximumSize(new java.awt.Dimension(800, 500));
        contentpane.setMinimumSize(new java.awt.Dimension(800, 500));
        contentpane.setPreferredSize(new java.awt.Dimension(800, 500));
        contentpane.setRequestFocusEnabled(false);

        starttButton.setForeground(new java.awt.Color(0, 204, 0));
        starttButton.setText("Start");
        starttButton.setMaximumSize(new java.awt.Dimension(91, 23));
        starttButton.setMinimumSize(new java.awt.Dimension(91, 23));
        starttButton.setPreferredSize(new java.awt.Dimension(91, 23));
        starttButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starttButtonActionPerformed(evt);
            }
        });

        disconnectButton.setForeground(new java.awt.Color(204, 0, 0));
        disconnectButton.setText("Disconnect");
        disconnectButton.setMaximumSize(new java.awt.Dimension(91, 23));
        disconnectButton.setMinimumSize(new java.awt.Dimension(91, 23));
        disconnectButton.setPreferredSize(new java.awt.Dimension(91, 23));
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        serverLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serverLabel.setForeground(new java.awt.Color(204, 255, 204));
        serverLabel.setText(" Server Messages");
        serverLabel.setAlignmentX(0.5F);

        portTextField.setText("5555");
        portTextField.setMaximumSize(new java.awt.Dimension(100, 29));
        portTextField.setMinimumSize(new java.awt.Dimension(100, 29));
        portTextField.setPreferredSize(new java.awt.Dimension(100, 29));
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });

        portLabel.setForeground(new java.awt.Color(255, 255, 255));
        portLabel.setText("Port:");

        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password:");

        passwordField.setText("braude");
        passwordField.setMaximumSize(new java.awt.Dimension(100, 25));
        passwordField.setMinimumSize(new java.awt.Dimension(100, 25));
        passwordField.setPreferredSize(new java.awt.Dimension(100, 25));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        editConnectionButton.setText("Edit Database Connection");
        editConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editConnectionButtonActionPerformed(evt);
            }
        });

        addressTextField.setText("jdbc:mysql://localhost/aes?serverTimezone=UTC&useSSL=false");
        addressTextField.setMaximumSize(new java.awt.Dimension(370, 25));
        addressTextField.setMinimumSize(new java.awt.Dimension(370, 25));
        addressTextField.setPreferredSize(new java.awt.Dimension(370, 25));

        uesrNameTextField.setText("root");
        uesrNameTextField.setMaximumSize(new java.awt.Dimension(100, 25));
        uesrNameTextField.setMinimumSize(new java.awt.Dimension(100, 25));
        uesrNameTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        uesrNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uesrNameTextFieldActionPerformed(evt);
            }
        });

        ShowPasswordBox.setBackground(new java.awt.Color(51, 51, 51));
        ShowPasswordBox.setForeground(new java.awt.Color(255, 255, 255));
        ShowPasswordBox.setText("Show Password");
        ShowPasswordBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordBoxActionPerformed(evt);
            }
        });

        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setText("Username:");

        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Address:");

        javax.swing.GroupLayout contentpaneLayout = new javax.swing.GroupLayout(contentpane);
        contentpane.setLayout(contentpaneLayout);
        contentpaneLayout.setHorizontalGroup(
            contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentpaneLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(editConnectionButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentpaneLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentpaneLayout.createSequentialGroup()
                        .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentpaneLayout.createSequentialGroup()
                                .addComponent(messagesTextList, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(starttButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentpaneLayout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(serverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentpaneLayout.createSequentialGroup()
                        .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username)
                            .addComponent(uesrNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(194, 194, 194))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentpaneLayout.createSequentialGroup()
                        .addComponent(ShowPasswordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentpaneLayout.createSequentialGroup()
                        .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portLabel))
                        .addGap(88, 88, 88))))
        );
        contentpaneLayout.setVerticalGroup(
            contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentpaneLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(portLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(serverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messagesTextList, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentpaneLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(starttButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(editConnectionButton)
                .addGap(18, 18, 18)
                .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username)
                    .addComponent(addressLabel))
                .addGap(4, 4, 4)
                .addGroup(contentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uesrNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(ShowPasswordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentpane, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        pack();
    }

     
   public void set_Location()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {
          
    	  server.shutDown();
          messagesTextList.add("Disconnected Successfully");
          
    }

    private void portTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void ShowPasswordBoxActionPerformed(java.awt.event.ActionEvent evt) {
       if(VISIBLE)
        {
            passwordField.setEchoChar('*');
            VISIBLE=false;
            
        }
        else
        {
            passwordField.setEchoChar((char)0);
             VISIBLE=true;
        }
    }

    private void starttButtonActionPerformed(java.awt.event.ActionEvent evt) {
         Thread thread = new Thread(new Runnable(){
          
          public void run()
          {
              int port=Integer.parseInt( portTextField.getText());              
              String [] databaseConnection={addressTextField.getText(),uesrNameTextField.getText(),String.valueOf(passwordField.getPassword())};               
                server = new Server(port,databaseConnection,messagesTextList);
		try 
		{
			server.listen(); 
		} 
		catch (Exception ex) 
		{
			messagesTextList.add("ERROR - Could not listen for clients!");
		}
		
      }
      });          
         thread.start();
    }

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {        
    }

    private void uesrNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {        
    }

    private void editConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addressLabel.setVisible(true);
        addressTextField.setVisible(true);
        Username.setVisible(true);
       uesrNameTextField.setVisible(true);
       passwordLabel.setVisible(true);
       passwordField.setVisible(true);
        ShowPasswordBox.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }
                    
    
    Server server;
    private int port =5555;
    private String[] databaseConnection= {"jdbc:mysql://localhost/aes?serverTimezone=UTC&useSSL=false","root","braude"};  
    private javax.swing.JCheckBox ShowPasswordBox;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JPanel contentpane;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JButton editConnectionButton;
    private java.awt.List messagesTextList;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
    private javax.swing.JLabel serverLabel;
    private javax.swing.JButton starttButton;
    private javax.swing.JTextField uesrNameTextField;
 
}


