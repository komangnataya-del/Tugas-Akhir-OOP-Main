/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Course; // PERBAIKAN: Menggunakan model Course, bukan Student
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import config.DBConnection;

/**
 *
 * @author ASUS
 */
public class CourseDAO {
    private Connection connection;

    public CourseDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create Course
    public int create(Course course){
        try{
            // PERBAIKAN: Menambahkan satu tanda tanya (?) menjadi 5 sesuai jumlah kolom
            String sql = "INSERT INTO course (courseID, code, name, sks, semester) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, course.getCode());
            stmt.setString(3, course.getCourseName());
            stmt.setInt(4, course.getSKS());
            stmt.executeUpdate();
            return 1;
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return 0;
        }
    }

    // Select/read Courses
    public List<Course> getCourse(){
        List<Course> courses = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM course";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                // PERBAIKAN: Menghapus kolom studentID yang tidak ada di tabel course
                String courseID = rs.getString("courseID");
                String code = rs.getString("code");
                String name = rs.getString("name");
                Integer sks = rs.getInt("sks");
                Integer semester = rs.getInt("semester");
                
                // PERBAIKAN: Membuat objek Course, bukan Student
                courses.add(new Course(code, name, sks, semester));
            }
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return courses;
    }

    // Update Course
    // PERBAIKAN: Mengubah query ke tabel course dan menyesuaikan nama method getter model Course
    public int update(Course course, String oldCourseID){
        try{
            String sql = "UPDATE course SET code=?, name=?, sks=?, semester=? WHERE courseID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, course.getCode());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3, course.getSKS());
            stmt.setString(4, oldCourseID); // Menggunakan ID lama sebagai parameter WHERE
            stmt.executeUpdate();
            return 1;            
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return 0;
        }
    }

    // Delete Course
    // PERBAIKAN: Mengubah query ke tabel course dan menggunakan parameter courseID
    public int delete(String courseID){
        try{
            String sql = "DELETE FROM course WHERE courseID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, courseID);
            stmt.executeUpdate();
            return 1;
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
