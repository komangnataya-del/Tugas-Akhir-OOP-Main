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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;

/**
 *
 * @author LENOVO
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

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();

try{
    String sql = "SELECT * FROM courses";
    PreparedStatement stmt = connection.prepareStatement(sql);
    
    ResultSet rs = stmt.executeQuery();
    while(rs.next()){
        int id = rs.getInt("courseID");
        String code = rs.getString("code");
        String name = rs.getString("name");
        int sks = Integer.parseInt(rs.getString("sks"));
        int semester = Integer.parseInt(rs.getString("semester"));
        
        Course course = new Course(code, name, sks, semester);
        course.setCourseID(id);
        courses.add(course);
    }
    
}catch(SQLException e){
    e.printStackTrace();
  }
    return courses;
  }
    public int create(Course course) {
    try {
        String sql = "INSERT INTO courses (code, name, sks, semester) VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, course.getCode());
        stmt.setString(2, course.getCourseName());
        stmt.setInt(3, course.getSKS());
        stmt.setInt(4, course.getSemester());
        stmt.executeUpdate();
        return 1;
    } catch (SQLException e) {
        return 0;
    }
}

public int update(Course course, String code) {
    try {
        String sql = "UPDATE courses SET name=?, sks=?, semester=? WHERE code=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, course.getCourseName());
        stmt.setInt(2, course.getSKS());
        stmt.setInt(3, course.getSemester());
        stmt.setString(4, code);
        stmt.executeUpdate();
        return 1;
    } catch (SQLException e) {
        return 0;
    }
}

public int delete(String code) {
    try {
        String sql = "DELETE FROM courses WHERE code=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, code);
        stmt.executeUpdate();
        return 1;
    } catch (SQLException e) {
        return 0;
    }
}

    public List<Course> getCourse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int delate(String courseCode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}