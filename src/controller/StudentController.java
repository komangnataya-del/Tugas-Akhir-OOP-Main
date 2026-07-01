/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Student;
import dao.StudentDAO;
import dao.StudentDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOMANG NATAYA
 */
public class StudentController {
    private StudentDAO studentDAO;

public StudentController() {
    try {
        studentDAO = new StudentDAO();
    }   catch (java.sql.SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public int create(Student student) {
        //logic adalah cek apakah user sudah login atau belum
        return studentDAO.create(student);
    }

    public List<Student> getStudent() {
        return studentDAO.getStudent();
    }
    public int update(Student student, String nim) {
        return studentDAO.update(student, nim);
    }

    public int delete(String nim) {
        return studentDAO.delete(nim);
    }
    
    
}
