/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.KRS;
import model.Course;
import model.Lecturer;

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
public class KRSDAO {
    private Connection connection;

    public KRSDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(KRSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // create KRS
    public int create(KRS krs) {
        try {
            // Mengasumsikan ada kolom id_course, score, grade, id_lecturer, dan semester di database
            String sql = "INSERT INTO krs (id_course, score, grade, id_lecturer, semester) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // Mengambil id dari objek Course dan Lecturer
            stmt.setString(1, krs.getCourse().getId()); 
            stmt.setDouble(2, krs.getScore());
            stmt.setString(3, krs.getGrade());
            stmt.setString(4, krs.getLecture().getId()); 
            stmt.setInt(5, krs.getSemester());
            
            stmt.executeUpdate();
            return 1;
            
        } catch (SQLException e) {
            System.err.println("Error Create: " + e.getMessage());
            return 0;
        }
    }

    // Select/read KRS
    public List<KRS> getKRS() {
        List<KRS> krsList = new ArrayList<>();
        
        try {
            // Query menggunakan JOIN untuk mengambil data Course dan Lecturer sekaligus
            String sql = "SELECT k.*, c.name_course, c.sks, l.name_lecturer " +
                         "FROM krs k " +
                         "JOIN course c ON k.id_course = c.id_course " +
                         "JOIN lecturer l ON k.id_lecturer = l.id_lecturer";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = new Course(rs.getString("id_course"), rs.getString("name_course"), rs.getInt("sks"));
                
                // BERHASIL DIPERBAIKI: Menambahkan dua parameter kosong "" di akhir sesuai kebutuhan constructor Lecturer Anda
                Lecturer lecturer = new Lecturer(rs.getString("id_lecturer"), rs.getString("name_lecturer"), "", "");
                
                double score = rs.getDouble("score");
                int semester = rs.getInt("semester");
                
                // Buat objek KRS menggunakan constructor utama Anda
                KRS krs = new KRS(course, score);
                krs.setLecture(lecturer);
                krs.setSemester(semester);
                
                krsList.add(krs);
            }
            
        } catch (SQLException e) {
            System.err.println("Error Read: " + e.getMessage());
        }
        return krsList;
    }

    // update KRS
    public int update(KRS krs, int idKrs) {
        try {
            String sql = "UPDATE krs SET id_course=?, score=?, grade=?, id_lecturer=?, semester=? WHERE id_krs=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, krs.getCourse().getId());
            stmt.setDouble(2, krs.getScore());
            stmt.setString(3, krs.getGrade());
            stmt.setString(4, krs.getLecture().getId());
            stmt.setInt(5, krs.getSemester());
            stmt.setInt(6, idKrs);
            
            stmt.executeUpdate();
            return 1;            
        } catch (SQLException e) {
            System.err.println("Error Update: " + e.getMessage());
            return 0;
        }
    }

    // Delete KRS
    public int delete(int idKrs) {
        try {
            String sql = "DELETE FROM krs WHERE id_krs=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idKrs);
            
            stmt.executeUpdate();
            return 1;
            
        } catch (SQLException e) {
            System.err.println("Error Delete: " + e.getMessage());
            return 0;
        }
    }
}
