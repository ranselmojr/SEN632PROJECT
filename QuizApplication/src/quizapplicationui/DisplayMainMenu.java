/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import quizapplicationlib.User;

/**
 *
 * @author romeo
 */
public class DisplayMainMenu extends javax.swing.JFrame {

    private static String userName = null;
    private static Object[] userDATA = new Object[6];
    private static int userID;
    private static String firstName;
    private static String lastName;
    private final String userLevel;
    

    /**
     * Creates new form MainMenu
     */
    public DisplayMainMenu(Object[] userData) {
        initComponents();

        userID = (int) userData[0];
        firstName = (String) userData[1];
        lastName = (String) userData[2];
        userDATA = userData;
        userLevel = (String) userData[5];
        
        jLabel1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        jLabel2.setFont(new Font("Helvetica", Font.PLAIN, 20));
        jLabel1.setText("Hello,  " + firstName + " " + lastName);
        jLabel2.setText("Please pick the Quiz Level");
        if(userLevel.equals("1")){
            buttonQ2.setEnabled(false);
            buttonQ3.setEnabled(false);
            buttonQ4.setEnabled(false);
        }else if(userLevel.equals("2")){
            buttonQ3.setEnabled(false);
            buttonQ4.setEnabled(false);
        }else if(userLevel.equals("3")){
            buttonQ4.setEnabled(false);
        }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonResults = new javax.swing.JButton();
        buttonQ1 = new javax.swing.JButton();
        buttonQ2 = new javax.swing.JButton();
        buttonQ3 = new javax.swing.JButton();
        buttonQ4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        buttonResults.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        buttonResults.setText("Check Results");
        buttonResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResultsActionPerformed(evt);
            }
        });

        buttonQ1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        buttonQ1.setText("Quiz1");
        buttonQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQ1ActionPerformed(evt);
            }
        });

        buttonQ2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        buttonQ2.setText("Quiz 2");
        buttonQ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQ2ActionPerformed(evt);
            }
        });

        buttonQ3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        buttonQ3.setText("Quiz 3");
        buttonQ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQ3ActionPerformed(evt);
            }
        });

        buttonQ4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        buttonQ4.setText("Final Quiz");
        buttonQ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQ4ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonQ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonQ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonQ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonQ4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonResults, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(buttonQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonQ2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonQ3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonQ4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(buttonResults, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void buttonResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResultsActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayQuizHistory(userDATA);

        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonResultsActionPerformed

    private void buttonQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQ1ActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayQuizArea(userDATA, 1);

        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonQ1ActionPerformed

    private void buttonQ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQ2ActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayQuizArea(userDATA, 2);

        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonQ2ActionPerformed

    private void buttonQ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQ3ActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayQuizArea(userDATA, 3);

        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonQ3ActionPerformed

    private void buttonQ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQ4ActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayQuizArea(userDATA, 4);

        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonQ4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JFrame f = new DisplayLogin();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonQ1;
    private javax.swing.JButton buttonQ2;
    private javax.swing.JButton buttonQ3;
    private javax.swing.JButton buttonQ4;
    private javax.swing.JButton buttonResults;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
