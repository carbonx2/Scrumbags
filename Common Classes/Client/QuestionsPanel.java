package Client;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import Classes.Packet;
import Classes.Question;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class QuestionsPanel extends javax.swing.JPanel {
	ArrayList<Question> questionList;
	JPopupMenu popupMenu;
    public QuestionsPanel() {
        initComponents();
        updateQuestionsList();
    }

   
    
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setForeground(SystemColor.text);
        jPanel1.setBorder(null);
        jPanel1.setBackground(SystemColor.activeCaption);
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 160), new java.awt.Dimension(0, 160), new java.awt.Dimension(0, 160));
        AddQuestionButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(400, 0), new java.awt.Dimension(400, 0), new java.awt.Dimension(400, 0));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        RemoveQuestionButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler3.setBackground(new Color(102, 0, 51));
        ViewQuestionButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setForeground(SystemColor.text);
        jPanel2.setBorder(null);
        jPanel2.setBackground(SystemColor.activeCaption);
        QuestionsList = new java.awt.List();
        QuestionsList.setForeground(SystemColor.desktop);

        setMaximumSize(new java.awt.Dimension(1080, 800));
        setMinimumSize(new java.awt.Dimension(1080, 800));
        setPreferredSize(new java.awt.Dimension(1080, 800));
        setLayout(new java.awt.BorderLayout());
        
        popupMenu = new JPopupMenu();
        popupMenu.setPreferredSize(new Dimension(300, 180));
        popupMenu.setMinimumSize(new Dimension(300, 180));
        popupMenu.setMaximumSize(new Dimension(300, 180));
        addPopup(jPanel1, popupMenu);
        
        IDLabel = new JLabel("New label");
        popupMenu.add(IDLabel);
        
        AuthorLabel = new JLabel("New label");
        popupMenu.add(AuthorLabel);
        
        QuestionLabel = new JLabel("New label");
        popupMenu.add(QuestionLabel);
        
        Answer1Label = new JLabel("New label");
        popupMenu.add(Answer1Label);
        
        Answer2Label = new JLabel("New label");
        popupMenu.add(Answer2Label);
        
        Answer3Label = new JLabel("New label");
        popupMenu.add(Answer3Label);
        
        Answer4Label = new JLabel("New label");
        popupMenu.add(Answer4Label);
        
        SaveButton = new JButton("Save");
        SaveButton.setEnabled(false);
        SaveButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String questionID = questionList.get(QuestionsList.getSelectedIndex()).getID();
        		int correctAnswerIndex = (int) CorrectAnswerSpinner.getValue();        		
        		popupMenu.setVisible(false);
        		QuestionController.updateCorrectAnswer(questionID, correctAnswerIndex);
        		updateQuestionsList();
        	}
        });
        
        CorrectAnswerLabel = new JLabel("Correct Answer:");
        popupMenu.add(CorrectAnswerLabel);
        
        CorrectAnswerSpinner = new JSpinner();
        CorrectAnswerSpinner.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		SaveButton.setEnabled(true);
        	}
        });
        CorrectAnswerSpinner.setModel(new SpinnerNumberModel(1, 1, 4, 1));
        CorrectAnswerSpinner.setAlignmentY(Component.TOP_ALIGNMENT);
        CorrectAnswerSpinner.setAlignmentX(Component.LEFT_ALIGNMENT);
        CorrectAnswerSpinner.setMaximumSize(new Dimension(65, 20));
        CorrectAnswerSpinner.setPreferredSize(new Dimension(65, 20));
        CorrectAnswerSpinner.setMinimumSize(new Dimension(65, 20));
        popupMenu.add(CorrectAnswerSpinner);
        popupMenu.add(SaveButton);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jPanel1.add(filler2);

        AddQuestionButton.setText("Add Question");
        AddQuestionButton.setAlignmentX(0.5F);
        AddQuestionButton.setEnabled(false);
        AddQuestionButton.setMaximumSize(new java.awt.Dimension(150, 50));
        AddQuestionButton.setMinimumSize(new java.awt.Dimension(150, 50));
        AddQuestionButton.setPreferredSize(new java.awt.Dimension(150, 50));
        AddQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddQuestionButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddQuestionButton);
        jPanel1.add(filler4);
        jPanel1.add(filler1);

        RemoveQuestionButton.setText("Remove Question");
        RemoveQuestionButton.setAlignmentX(0.5F);
        RemoveQuestionButton.setEnabled(false);
        RemoveQuestionButton.setMaximumSize(new java.awt.Dimension(150, 50));
        RemoveQuestionButton.setMinimumSize(new java.awt.Dimension(150, 50));
        RemoveQuestionButton.setPreferredSize(new java.awt.Dimension(150, 50));
        RemoveQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveQuestionButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RemoveQuestionButton);
        jPanel1.add(filler3);

        ViewQuestionButton.setText("View Question");
        ViewQuestionButton.setAlignmentX(0.5F);
        ViewQuestionButton.setEnabled(false);
        ViewQuestionButton.setMaximumSize(new java.awt.Dimension(150, 50));
        ViewQuestionButton.setMinimumSize(new java.awt.Dimension(150, 50));
        ViewQuestionButton.setPreferredSize(new java.awt.Dimension(150, 50));
        ViewQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewQuestionButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ViewQuestionButton);

        add(jPanel1, java.awt.BorderLayout.LINE_END);

        QuestionsList.setFont(new Font("Arial", Font.PLAIN, 24)); // NOI18N
        QuestionsList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                QuestionsListItemStateChanged(evt);
            }
        });
        QuestionsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addComponent(QuestionsList, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(QuestionsList, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }

    private void AddQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {
     
    }

    private void RemoveQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void ViewQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	Question question = questionList.get(QuestionsList.getSelectedIndex());
    	IDLabel.setText("Question ID: "+question.getID());
    	AuthorLabel.setText("Question Author: "+question.getAuthor().getID()+" "+question.getAuthor().getName());
    	QuestionLabel.setText("Question: "+question.getQuestion());
    	Answer1Label.setText("1): "+question.getAnswer(1));
    	Answer2Label.setText("2): "+question.getAnswer(2));
    	Answer3Label.setText("3): "+question.getAnswer(3));
    	Answer4Label.setText("4): "+question.getAnswer(4));
    	CorrectAnswerSpinner.setValue(question.getCorrectAnswerIndex());
    	((DefaultEditor) CorrectAnswerSpinner.getEditor()).getTextField().setEditable(false);
		SaveButton.setEnabled(false);

    	popupMenu.show(this, 35, 110);
    }

    private void QuestionsListActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void QuestionsListItemStateChanged(java.awt.event.ItemEvent evt) {
        ViewQuestionButton.setEnabled(true);  
        
    }

    private void updateQuestionsList()
    {
    	    	
    	questionList=QuestionController.getQuestionList();
    	QuestionsList.removeAll();
    	for(Question question:questionList)    	
    		QuestionsList.add(question.getQuestion());
    	
    }
    
    private javax.swing.JButton AddQuestionButton;
    private java.awt.List QuestionsList;
    private javax.swing.JButton RemoveQuestionButton;
    private javax.swing.JButton ViewQuestionButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JLabel IDLabel;
    private JLabel AuthorLabel;
    private JLabel QuestionLabel;
    private JLabel Answer1Label;
    private JLabel Answer2Label;
    private JLabel Answer3Label;
    private JLabel Answer4Label;
    private JButton SaveButton;
    private JLabel CorrectAnswerLabel;
    private JSpinner CorrectAnswerSpinner;
  
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
