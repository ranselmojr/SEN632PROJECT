/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationlib;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author romeo
 */
public class QuizData {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /**
     * Writes Quiz Result to the Database
     *
     * @param userID
     * @param result
     */
    public void writeResult(int userID, Double quizResult, int quizType) {

        try {

            con = DatabaseConnection.getConnection();

            String sql = "insert into quiz (user_id, quizresults, quiztype)"
                    + "values (?,?,?)";

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

                QuizResult preResult = new QuizResult(rs.getInt(1), 
                        rs.getInt(2), rs.getDouble(3), rs.getString(6));
                
                quizResult.add(preResult);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return quizResult;

    }


}