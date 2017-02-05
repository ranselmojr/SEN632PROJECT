/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import quizapplicationlib.*;

/**
 *
 * @author romeo
 */
public class DisplayQuizArea extends javax.swing.JFrame {

    private static Object[] userDATA = new Object[6];
    private static int userID;
    private static int quizTYPE;
    private static String firstName;
    private static String lastName;
    private static ArrayList<String> correctAnswerStorage = new ArrayList<String>();

    /**
     * Creates new form QuizArea
     *
     * @param userData
     * @param quizType
     */
    public DisplayQuizArea(Object[] userData, int quizType) {
        initComponents();
        textLayoutInit();

        userID = (int) userData[0];
        firstName = (String) userData[1];
        lastName = (String) userData[2];
        userDATA = userData;
        quizTYPE = quizType;

        jLabel1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        jLabel1.setText("Good Luck!!!,  " + firstName + " " + lastName);
        jLabel2.setFont(new Font("Helvetica", Font.PLAIN, 20));
        if (quizType != 4) {
            jLabel2.setText("Quiz Level " + Integer.toString(quizType));
        } else {
            jLabel2.setText("Final Quiz Level");
        }

        Quiz quiz = new Quiz(0, null, null, null, null, null,
                false, false, 0);

        ArrayList<Quiz> quizQuestion = quiz.getQuizQuestions(quizTYPE);  //Store Quiz

        quizQuestion = quiz.shuffleQuestionsChoices(quizQuestion); //Store Shuffled Quiz

        Iterator itr2 = quizQuestion.iterator(); //Iterate through to capture quizData

        ArrayList<String> quizQuestion2 = new ArrayList<>();
        ArrayList<Boolean> isTrueFalse = new ArrayList<>();
        ArrayList<String> testShuffle = new ArrayList<>();
        ArrayList<String> preShuffle = new ArrayList<>();

        while (itr2.hasNext()) {

            Quiz qr2 = (Quiz) itr2.next();

            quizQuestion2.add(qr2.getQuestion());

            if (!qr2.is_tf()) {
                correctAnswerStorage.add(qr2.getCorAnswer());
            } else {
                if (qr2.get_tf_Ans()) {
                    correctAnswerStorage.add("True");
                } else {
                    correctAnswerStorage.add("False");
                }

            }

            isTrueFalse.add(qr2.is_tf());
            isTrueFalse.add(qr2.get_tf_Ans());

            preShuffle.add(qr2.getCorAnswer());
            preShuffle.add(qr2.getwrongAns1());
            preShuffle.add(qr2.getwrongAns2());
            preShuffle.add(qr2.getwrongAns3());

        }
        final String html1 = "<html><body style='width: ";
        final String html2 = "px'>";
        jLabelQ1.setText(html1 + "800" + html2 + "Q1: " + quizQuestion2.get(0));
        jLabelQ2.setText(html1 + "800" + html2 + "Q2: " + quizQuestion2.get(1));
        jLabelQ3.setText(html1 + "800" + html2 + "Q3: " + quizQuestion2.get(2));
        jLabelQ4.setText(html1 + "800" + html2 + "Q4: " + quizQuestion2.get(3));
        jLabelQ5.setText(html1 + "800" + html2 + "Q5: " + quizQuestion2.get(4));

        if (isTrueFalse.get(0)) {
            jRadioButton1.setText("True");
            jRadioButton2.setText("False");
            jRadioButton1.setActionCommand("True");
            jRadioButton2.setActionCommand("False");
            jRadioButton3.setVisible(false);
            jRadioButton4.setVisible(false);
        } else {
            testShuffle.add(preShuffle.get(0));
            testShuffle.add(preShuffle.get(1));
            testShuffle.add(preShuffle.get(2));
            testShuffle.add(preShuffle.get(3));

            testShuffle = quiz.shuffleQuestionsChoices(testShuffle);

            jRadioButton1.setText(testShuffle.get(0));
            jRadioButton2.setText(testShuffle.get(1));
            jRadioButton3.setText(testShuffle.get(2));
            jRadioButton4.setText(testShuffle.get(3));

            jRadioButton1.setActionCommand(testShuffle.get(0));
            jRadioButton2.setActionCommand(testShuffle.get(1));
            jRadioButton3.setActionCommand(testShuffle.get(2));
            jRadioButton4.setActionCommand(testShuffle.get(3));

            testShuffle.removeAll(preShuffle);

        }

        if (isTrueFalse.get(2)) {
            jRadioButton5.setText("True");
            jRadioButton6.setText("False");
            jRadioButton5.setActionCommand("True");
            jRadioButton6.setActionCommand("False");
            jRadioButton7.setVisible(false);
            jRadioButton8.setVisible(false);
        } else {
            testShuffle.add(preShuffle.get(4));
            testShuffle.add(preShuffle.get(5));
            testShuffle.add(preShuffle.get(6));
            testShuffle.add(preShuffle.get(7));

            testShuffle = quiz.shuffleQuestionsChoices(testShuffle);

            jRadioButton5.setText(testShuffle.get(0));
            jRadioButton6.setText(testShuffle.get(1));
            jRadioButton7.setText(testShuffle.get(2));
            jRadioButton8.setText(testShuffle.get(3));

            jRadioButton5.setActionCommand(testShuffle.get(0));
            jRadioButton6.setActionCommand(testShuffle.get(1));
            jRadioButton7.setActionCommand(testShuffle.get(2));
            jRadioButton8.setActionCommand(testShuffle.get(3));

            testShuffle.removeAll(preShuffle);
        }

        if (isTrueFalse.get(4)) {
            jRadioButton9.setText("True");
            jRadioButton10.setText("False");
            jRadioButton9.setActionCommand("True");
            jRadioButton10.setActionCommand("False");
            jRadioButton11.setVisible(false);
            jRadioButton12.setVisible(false);
        } else {
            testShuffle.add(preShuffle.get(8));
            testShuffle.add(preShuffle.get(9));
            testShuffle.add(preShuffle.get(10));
            testShuffle.add(preShuffle.get(11));

            testShuffle = quiz.shuffleQuestionsChoices(testShuffle);

            jRadioButton9.setText(testShuffle.get(0));
            jRadioButton10.setText(testShuffle.get(1));
            jRadioButton11.setText(testShuffle.get(2));
            jRadioButton12.setText(testShuffle.get(3));

            jRadioButton9.setActionCommand(testShuffle.get(0));
            jRadioButton10.setActionCommand(testShuffle.get(1));
            jRadioButton11.setActionCommand(testShuffle.get(2));
            jRadioButton12.setActionCommand(testShuffle.get(3));

            testShuffle.removeAll(preShuffle);
        }

        if (isTrueFalse.get(6)) {
            jRadioButton13.setText("True");
            jRadioButton14.setText("False");
            jRadioButton13.setActionCommand("True");
            jRadioButton14.setActionCommand("False");
            jRadioButton15.setVisible(false);
            jRadioButton16.setVisible(false);
        } else {
            testShuffle.add(preShuffle.get(12));
            testShuffle.add(preShuffle.get(13));
            testShuffle.add(preShuffle.get(14));
            testShuffle.add(preShuffle.get(15));

            testShuffle = quiz.shuffleQuestionsChoices(testShuffle);

            jRadioButton13.setText(testShuffle.get(0));
            jRadioButton14.setText(testShuffle.get(1));
            jRadioButton15.setText(testShuffle.get(2));
            jRadioButton16.setText(testShuffle.get(3));

            jRadioButton13.setActionCommand(testShuffle.get(0));
            jRadioButton14.setActionCommand(testShuffle.get(1));
            jRadioButton15.setActionCommand(testShuffle.get(2));
            jRadioButton16.setActionCommand(testShuffle.get(3));

            testShuffle.removeAll(preShuffle);
        }

        if (isTrueFalse.get(8)) {
            jRadioButton17.setText("True");
            jRadioButton18.setText("False");

            jRadioButton17.setActionCommand("True");
            jRadioButton18.setActionCommand("False");

            jRadioButton19.setVisible(false);
            jRadioButton20.setVisible(false);
        } else {
            testShuffle.add(preShuffle.get(16));
            testShuffle.add(preShuffle.get(17));
            testShuffle.add(preShuffle.get(18));
            testShuffle.add(preShuffle.get(19));

            testShuffle = quiz.shuffleQuestionsChoices(testShuffle);

            jRadioButton17.setText(testShuffle.get(0));
            jRadioButton18.setText(testShuffle.get(1));
            jRadioButton19.setText(testShuffle.get(2));
            jRadioButton20.setText(testShuffle.get(3));

            jRadioButton17.setActionCommand(testShuffle.get(0));
            jRadioButton18.setActionCommand(testShuffle.get(1));
            jRadioButton19.setActionCommand(testShuffle.get(2));
            jRadioButton20.setActionCommand(testShuffle.get(3));

            testShuffle.removeAll(preShuffle);
        }

    }

    private DisplayQuizArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelQ1 = new javax.swing.JLabel();
        jLabelQ2 = new javax.swing.JLabel();
        jLabelQ3 = new javax.swing.JLabel();
        jLabelQ4 = new javax.swing.JLabel();
        jLabelQ5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setFocusableWindowState(false);
        setPreferredSize(new java.awt.Dimension(1100, 1100));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabelQ1.setText("jLabelQ1");

        jLabelQ2.setText("jLabelQ2");

        jLabelQ3.setText("jLabelQ3");

        jLabelQ4.setText("jLabelQ4");

        jLabelQ5.setText("jLabelQ5");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.setFocusable(false);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("jRadioButton5");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("jRadioButton6");

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("jRadioButton7");

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("jRadioButton8");

        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setText("jRadioButton9");

        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setText("jRadioButton10");

        buttonGroup3.add(jRadioButton11);
        jRadioButton11.setText("jRadioButton11");

        buttonGroup3.add(jRadioButton12);
        jRadioButton12.setText("jRadioButton12");

        buttonGroup4.add(jRadioButton13);
        jRadioButton13.setText("jRadioButton13");

        buttonGroup4.add(jRadioButton14);
        jRadioButton14.setText("jRadioButton14");

        buttonGroup4.add(jRadioButton15);
        jRadioButton15.setText("jRadioButton15");

        buttonGroup4.add(jRadioButton16);
        jRadioButton16.setText("jRadioButton16");

        buttonGroup5.add(jRadioButton18);
        jRadioButton18.setText("jRadioButton18");

        buttonGroup5.add(jRadioButton17);
        jRadioButton17.setText("jRadioButton17");

        buttonGroup5.add(jRadioButton19);
        jRadioButton19.setText("jRadioButton19");

        buttonGroup5.add(jRadioButton20);
        jRadioButton20.setText("jRadioButton20");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Continue");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jMenu3.setText("File");

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);
        jMenu3.add(jSeparator1);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelQ4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQ5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(275, 275, 275))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton13, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton15, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton16, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton17, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton18, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton19, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton20, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 722, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jLabelQ1)
                .addGap(12, 12, 12)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addGap(12, 12, 12)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jLabelQ2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton8)
                .addGap(18, 18, 18)
                .addComponent(jLabelQ3)
                .addGap(30, 30, 30)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton12)
                .addGap(18, 18, 18)
                .addComponent(jLabelQ4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton16)
                .addGap(18, 18, 18)
                .addComponent(jLabelQ5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void textLayoutInit() {

        jLabelQ1.setFont(new Font("Helvetica", Font.PLAIN, 15));
        jLabelQ2.setFont(new Font("Helvetica", Font.PLAIN, 15));
        jLabelQ3.setFont(new Font("Helvetica", Font.PLAIN, 15));
        jLabelQ4.setFont(new Font("Helvetica", Font.PLAIN, 15));
        jLabelQ5.setFont(new Font("Helvetica", Font.PLAIN, 15));

        jRadioButton1.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton2.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton3.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton4.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton5.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton6.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton7.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton8.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton9.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton10.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton11.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton12.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton13.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton14.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton15.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton16.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton17.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton18.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton19.setFont(new Font("Helvetica", Font.PLAIN, 12));
        jRadioButton20.setFont(new Font("Helvetica", Font.PLAIN, 12));

        jButton3.setVisible(false);
    }

    private void setCorrectAnswer() {
        if (jRadioButton1.getText().equals(correctAnswerStorage.get(0))) {
            jRadioButton1.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton2.getText().equals(correctAnswerStorage.get(0))) {
            jRadioButton2.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton3.getText().equals(correctAnswerStorage.get(0))) {
            jRadioButton3.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton4.getText().equals(correctAnswerStorage.get(0))) {
            jRadioButton4.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }

        if (jRadioButton5.getText().equals(correctAnswerStorage.get(1))) {
            jRadioButton5.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton6.getText().equals(correctAnswerStorage.get(1))) {
            jRadioButton6.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton7.getText().equals(correctAnswerStorage.get(1))) {
            jRadioButton7.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton8.getText().equals(correctAnswerStorage.get(1))) {
            jRadioButton8.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }

        if (jRadioButton9.getText().equals(correctAnswerStorage.get(2))) {
            jRadioButton9.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton10.getText().equals(correctAnswerStorage.get(2))) {
            jRadioButton10.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton11.getText().equals(correctAnswerStorage.get(2))) {
            jRadioButton11.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton12.getText().equals(correctAnswerStorage.get(2))) {
            jRadioButton12.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }

        if (jRadioButton13.getText().equals(correctAnswerStorage.get(3))) {
            jRadioButton13.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton14.getText().equals(correctAnswerStorage.get(3))) {
            jRadioButton14.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton15.getText().equals(correctAnswerStorage.get(3))) {
            jRadioButton15.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton16.getText().equals(correctAnswerStorage.get(3))) {
            jRadioButton16.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }

        if (jRadioButton17.getText().equals(correctAnswerStorage.get(4))) {
            jRadioButton17.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton18.getText().equals(correctAnswerStorage.get(4))) {
            jRadioButton18.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton19.getText().equals(correctAnswerStorage.get(4))) {
            jRadioButton19.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }
        if (jRadioButton20.getText().equals(correctAnswerStorage.get(4))) {
            jRadioButton20.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 15));

        }

    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Submit and Show Result?",
                "Quiz Submission", JOptionPane.WARNING_MESSAGE);

        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(true);

        //Calculate Result
        Double testScore = 0.00;
        int correct = 0;

        try {
            if (buttonGroup1.getSelection().getActionCommand().equals(
                    correctAnswerStorage.get(0))) {
                testScore += 20.00;
                correct += 1;
            }
            if (buttonGroup2.getSelection().getActionCommand().equals(
                    correctAnswerStorage.get(1))) {
                testScore += 20.00;
                correct += 1;
            }
            if (buttonGroup3.getSelection().getActionCommand().equals(
                    correctAnswerStorage.get(2))) {
                testScore += 20.00;
                correct += 1;
            }
            if (buttonGroup4.getSelection().getActionCommand().equals(
                    correctAnswerStorage.get(3))) {
                testScore += 20.00;
                correct += 1;
            }
            if (buttonGroup5.getSelection().getActionCommand().equals(
                    correctAnswerStorage.get(4))) {
                testScore += 20.00;
                correct += 1;
            }
        } catch (NullPointerException e) {

        }

        String html1 = "<html>Text color: <font color='red'>red</font></html>";

        jLabel1.setText("<html><font color='red'>Your got " + correct
                + "/5 correct answer!!!</font></html>");
        jLabel2.setText("That is " + testScore + "%");

        setCorrectAnswer();

        if (testScore > 69.00) {
            Quiz quizResult = new Quiz(userID, testScore, quizTYPE);
            quizResult.writeResult(userID, testScore, quizTYPE);
            User user = new User();
            user.upgradeUser(userID);

            switch ((String) userDATA[5]) {
                case "1":
                    userDATA[5]  = "2";
                    break;
                case "2":
                    userDATA[5]  = "3";
                    break;
                case "3":
                    userDATA[5]  = "4";
                    break;
                default:
                    break;

            }
        }
        correctAnswerStorage.removeAll(correctAnswerStorage);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Progress will not be Saved!!!",
                "Cancelling...", JOptionPane.WARNING_MESSAGE);

        JFrame f = new DisplayMainMenu(userDATA);
        jRadioButton16.setText(correctAnswerStorage.get(3));
        f.setVisible(true);
        //new DisplayMainMenu(userData).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayMainMenu(userDATA);

        f.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayLogin();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelQ1;
    private javax.swing.JLabel jLabelQ2;
    private javax.swing.JLabel jLabelQ3;
    private javax.swing.JLabel jLabelQ4;
    private javax.swing.JLabel jLabelQ5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
