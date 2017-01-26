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
public class QuizData {
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    
    /**
     * Get all question according to quizType
     *
     * @param quizType
     *
     * @return quizQuestion
     */
    public ArrayList<QuizQuestionBank> getQuizQuestions(int quizType) {

        ArrayList<QuizQuestionBank> quizQuestion = new ArrayList<QuizQuestionBank>();

        try {

            con = DatabaseConnection.getConnection();

            String sql = "select * from quiz_question where quiztype = "
                    + quizType;

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                QuizQuestionBank preResult = new QuizQuestionBank(rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getBoolean(7), rs.getBoolean(8),
                        rs.getInt(9)
                );

                quizQuestion.add(preResult);

            }

            con.close();

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
    public void writeResult(int userID, Double quizResult, int quizType) {

        try {

            con = DatabaseConnection.getConnection();

            String sql = "insert into quiz (user_id, quizresults, quiztype, "
                    + "quiz_taken)"
                    + "values (?,?,?, now())";

            PreparedStatement preparedStmt = con.prepareStatement(sql);

            preparedStmt.setInt(1, userID);
            preparedStmt.setDouble(2, quizResult);
            preparedStmt.setInt(3, quizType);

            preparedStmt.execute();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This is to return a multi data type array for the quiz Result
     *
     * @param userID
     * @return
     *
     */
    public ArrayList<QuizResult> getResult(int userID) {

        ArrayList<QuizResult> quizResult = new ArrayList<QuizResult>();
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

                QuizResult preResult = new QuizResult(rs.getInt(1),
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
