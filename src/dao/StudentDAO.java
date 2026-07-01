/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import config.DBConnection;

/**
 *
 * @author KOMANG-NATAYA
 */
public class StudentDAO {

    public ArrayList<Student> getAllStudent() {
         List<Student> students = new ArrayList<>();
    try {
        String sql = "SELECT * FROM students";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setNim(rs.getString("NIM"));
            student.setName(rs.getString("name"));
            student.setCardID(rs.getString("cardID"));
            student.setStudiProgram(rs.getString("studiProgram"));
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return (ArrayList<Student>) students;
    }
    
    private Connection connection;
    public StudentDAO() throws SQLException {
    connection = DBConnection.getConnection();
}
    // create User
    public int create(Student student){
        try{
            String sql = "INSERT INTO students (cardID, NIM, name, studiProgram) VALUES(?,?,?,?)";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getStudyProgram());
            stmt.executeUpdate();
            return 1;
            
        }catch(SQLException e){
              return 0;
        }
        
    }
     // Select/read Users
    public List<Student> getStudent() {
    List<Student> students = new ArrayList<>();

    try {
        String sql = "SELECT * FROM students";
        PreparedStatement stmt = connection.prepareStatement(sql); // ← tambah ini
        ResultSet rs = stmt.executeQuery(); // ← tambah ini

        while (rs.next()) {
            Student student = new Student();
            student.setNim(rs.getString("NIM"));
            student.setName(rs.getString("name"));
            student.setCardID(rs.getString("cardID"));
            student.setStudiProgram(rs.getString("studiProgram"));
            students.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
}
     // Delete User
    public int delete(String nim){
        
        return 0;
    }

    public int update(Student student, String nim) {
    try {
        String sql = "UPDATE students SET cardID=?, name=?, studiProgram=? WHERE NIM=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, student.getCardID());
        stmt.setString(2, student.getName());
        stmt.setString(3, student.getStudyProgram());
        stmt.setString(4, nim);
        stmt.executeUpdate();
        return 1;
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
}
    }