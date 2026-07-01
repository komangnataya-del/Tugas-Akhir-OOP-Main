/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.KRSDAO;
import model.KRS;

public class KRSController {
    private KRSDAO krsDAO = new KRSDAO();

    public int create(int studentID, int courseID, double score, String grade) {
        // Validasi — studentID harus lebih dari 0
        if (studentID <= 0) {
            return 0;
        }
        // Validasi — courseID harus lebih dari 0
        if (courseID <= 0) {
            return 0;
        }
        // Validasi — score harus antara 0 dan 100
        if (score < 0 || score > 100) {
            return 0;
        }
        // Validasi — grade tidak boleh kosong
        if (grade == null || grade.isEmpty()) {
            return 0;
        }
        return krsDAO.create(studentID, courseID, score, grade);
    }

    public int create(KRS krs, String nim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}