/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import dao.LecturerDAO;
import java.util.List;
import model.Lecturer;

public class LecturerController {
    private LecturerDAO lecturerDAO = new LecturerDAO();

    public int create(Lecturer lecturer) {
        // Validasi — nama tidak boleh kosong
        if (lecturer.getName() == null || lecturer.getName().isEmpty()) {
            return 0;
        }
        // Validasi — NIDN tidak boleh kosong
        if (lecturer.getNidn() == null || lecturer.getNidn().isEmpty()) {
            return 0;
        }
        return lecturerDAO.create(lecturer);
    }

    public List<Lecturer> getAll() {
        return lecturerDAO.getAll();
    }

    public int update(Lecturer lecturer, String nidn) {
        // Validasi — NIDN tidak boleh kosong
        if (nidn == null || nidn.isEmpty()) {
            return 0;
        }
        // Validasi — nama tidak boleh kosong
        if (lecturer.getName() == null || lecturer.getName().isEmpty()) {
            return 0;
        }
        return lecturerDAO.update(lecturer, nidn);
    }

    public int delete(String nidn) {
        // Validasi — NIDN tidak boleh kosong
        if (nidn == null || nidn.isEmpty()) {
            return 0;
        }
        return lecturerDAO.delete(nidn);
    }
}