/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger; 


/**
 *
 * @author Lenovo
 */
public class KRSDAO {
    private Connection connection;

    public KRSDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(KRSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int create(int studentID, int courseID, double score, String grade) {
        try {
            String sql = "INSERT INTO krs (studentID, courseID, score, grade) VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, studentID);
            stmt.setInt(2, courseID);
            stmt.setDouble(3, score);
            stmt.setString(4, grade);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}