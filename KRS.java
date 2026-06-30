package dao;

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
public class LecturerDAO {
    private Connection connection;

    public LecturerDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create Lecturer
    public int create(Lecturer lecturer){
        try{
            // Sesuai kolom: lecturerID, name, cardID, nidn, expertise
            String sql = "INSERT INTO lectures (lecturerID, name, cardID, nidn, expertise) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, lecturer.getIdCard()); // lecturerID disamakan dengan cardID
            stmt.setString(2, lecturer.getName());
            stmt.setString(3, lecturer.getIdCard()); // cardID dari Person
            stmt.setString(4, lecturer.getNidn());
            stmt.setString(5, lecturer.getExpertise());
            
            stmt.executeUpdate();
            return 1;
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return 0;
        }
    }

    // Select/read All Lecturers
    public List<Lecturer> getLecturer(){
        List<Lecturer> lecturers = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM lectures";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String cardID = rs.getString("cardID");
                String name = rs.getString("name");
                String nidn = rs.getString("nidn");
                String expertise = rs.getString("expertise");
                
                // Dimasukkan ke konstruktor: Lecturer(idCard, name, nidn, expertise)
                lecturers.add(new Lecturer(cardID, name, nidn, expertise));
            }
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return lecturers;
    }

    // Update Lecturer
    public int update(Lecturer lecturer, String oldLecturerID){
        try{
            String sql = "UPDATE lectures SET name=?, cardID=?, nidn=?, expertise=?, lecturerID=? WHERE lecturerID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, lecturer.getName());
            stmt.setString(2, lecturer.getIdCard());
            stmt.setString(3, lecturer.getNidn());
            stmt.setString(4, lecturer.getExpertise());
            stmt.setString(5, lecturer.getIdCard());    // Update lecturerID baru (dari cardID)
            stmt.setString(6, oldLecturerID);          // Primary key lama untuk klausa WHERE
            
            stmt.executeUpdate();
            return 1;            
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return 0;
        }
    }

    // Delete Lecturer
    public int delete(String lecturerID){
        try{
            String sql = "DELETE FROM lectures WHERE lecturerID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturerID);
            
            stmt.executeUpdate();
            return 1;
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
