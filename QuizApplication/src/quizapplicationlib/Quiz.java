/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationlib;

import java.sql.*;
import java.util.*;

/**
 *
 * @author romeo
 */
public class Quiz {

    private int resultID;
    private int user_id;
    private double quizResult;
    private String quizType;
    private String quizTaken;

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    private int quizID;
    private String question;
    private String corAnswer;
    private String wrongAns1;
    private String wrongAns2;
    private String wrongAns3;
    private boolean is_tf;
    private boolean tf_ans;
    private int quizT;

    
    public Quiz(int quizID, String question, String corAnswer, String wrongAns1,
            String wrongAns2, String wrongAns3, boolean is_tf,
            boolean tf_ans, int quizT) {
        this.quizID = quizID;
        this.question = question;
        this.corAnswer = corAnswer;
        this.wrongAns1 = wrongAns1;
        this.wrongAns2 = wrongAns2;
        this.wrongAns3 = wrongAns3;
        this.is_tf = is_tf;
        this.tf_ans = tf_ans;
        this.quizT = quizT;
    }

    public Quiz(int resultID, int user_id, double quizResult,
            String quizType, String quizTaken) {
        this.resultID = resultID;
        this.user_id = user_id;
        this.quizResult = quizResult;
        this.quizType = quizType;
        this.quizTaken = quizTaken;
    }
    
    public Quiz(int user_id, double quizResult,
            int quizT) {
        
        this.user_id = user_id;
        this.quizResult = quizResult;
        this.quizT = quizT;
        
    }
    
    public int getResultID(){
        return resultID;
    }
    
    public int getUser_id(){
        return user_id;
    }
    
    public double getQuizResult(){
        return quizResult;
    }
    
    public String getQuizType(){
        return quizType;
    }
    
    public String quizTaken(){
        return quizTaken;
    }
    
    public int getQuizId(){
        return quizID;
    }
    
    public String  getQuestion(){
        return question;
    }
    
    public String getCorAnswer(){
        return corAnswer;
    }
    
    public String  getwrongAns1(){
        return wrongAns1;
    }
    
    public String  getwrongAns2(){
        return wrongAns2;
    }
    
    public String  getwrongAns3(){
        return wrongAns3;
    }
    
    public boolean  is_tf(){
        return is_tf;
    }
    
    public boolean  get_tf_Ans(){
        return tf_ans;
    }
    
    public int getQuizT(){
        return quizT;
    }

    public Quiz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all question according to quizType
     *
     * @param quizType
     *
     * @return quizQuestion
     */
    public ArrayList<Quiz> getQuizQuestions(int quizT) {

        ArrayList<Quiz> quizQuestion = new ArrayList<Quiz>();

        try {

            con = DatabaseConnection.getConnection();

            String sql = "select * from quiz_question where quiztype = "
                    + quizT;

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
    

                quizQuestion.add(new Quiz(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getBoolean(7), rs.getBoolean(8),
                        rs.getInt(9)
                ));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return quizQuestion;

    }

    /**
     * Shuffle ArrayList to randomized the order of the question
     *
     * @param rawQuiz
     *
     * @return Shuffled ArrayList
     */
    public ArrayList shuffleQuestionsChoices(ArrayList rawQuestion) {

        Collections.shuffle(rawQuestion);

        return rawQuestion;

    }

    /**
     * Writes Quiz Result to the Database
     *
     * @param userID
     * @param result
     */
    public void writeResult(int userID, Double quizResult, int quizT) {

        try {

            con = DatabaseConnection.getConnection();

            String sql = "insert into quiz (user_id, quizresults, quiztype, "
                    + "quiz_taken)"
                    + "values (?,?,?, now())";

            PreparedStatement preparedStmt = con.prepareStatement(sql);

            preparedStmt.setInt(1, userID);
            preparedStmt.setDouble(2, quizResult);
            preparedStmt.setInt(3, quizT);

            preparedStmt.execute();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ArrayList<Quiz> getResult(int userID) {

        ArrayList<Quiz> quizResult = new ArrayList<Quiz>();
        try {

            con = DatabaseConnection.getConnection();
            //stmt = con.createStatement();
            //rs = stmt.executeQuery(sql);

            String sql = "select * from quiz inner join quiztype "
                    + " on quiz.quiztype = quiztype.id where user_id = '"
                    + userID + "'";

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                java.sql.Date aDate = rs.getDate(5);
                String valueToInsert = aDate.toString();

                Quiz preResult = new Quiz(rs.getInt(1),
                        rs.getInt(2), rs.getDouble(3), rs.getString(6),
                        valueToInsert
                );

                quizResult.add(preResult);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return quizResult;

    }

}
