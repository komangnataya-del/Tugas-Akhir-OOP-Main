/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.UserDAO;
import model.User;

public class UserController {
    private UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password) {
        // Validasi — username tidak boleh kosong
        if (username == null || username.isEmpty()) {
            return false;
        }
        // Validasi — password tidak boleh kosong
        if (password == null || password.isEmpty()) {
            return false;
        }
        // Validasi — panjang username minimal 3 karakter
        if (username.length() < 3) {
            return false;
        }
        // Validasi — panjang password minimal 6 karakter
        if (password.length() < 6) {
            return false;
        }
        return userDAO.login(username, password);
    }
}
