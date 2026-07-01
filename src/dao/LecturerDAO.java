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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecturer;

/**
 *
 * @author Lenovo
 */
public class LecturerDAO {
    private Connection connection;

    public LecturerDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int create(Lecturer lecturer) {
        try {
            String sql = "INSERT INTO lectures (name, nidn) VALUES (?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getName());
            stmt.setString(2, lecturer.getNidn());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public List<Lecturer> getAll() {
        List<Lecturer> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lectures";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String nidn = rs.getString("nidn");
                list.add(new Lecturer("", name, nidn, ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int update(Lecturer lecturer, String nidn) {
        try {
            String sql = "UPDATE lectures SET name=? WHERE nidn=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getName());
            stmt.setString(2, nidn);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int delete(String nidn) {
        try {
            String sql = "DELETE FROM lectures WHERE nidn=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nidn);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }
}
