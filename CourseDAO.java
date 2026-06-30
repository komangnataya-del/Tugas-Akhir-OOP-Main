/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.KRS;
import dao.KRSDAO;

/**
 *
 * @author ASUS
 */
public class KRSController {
    private KRSDAO krsDAO = new KRSDAO();

    public int create(KRS krs) {
        // logic tambahan bisa dimasukkan di sini jika diperlukan
        return krsDAO.create(krs);
    }

    public List<KRS> getKRS() {
        return krsDAO.getKRS();
    }

    public int update(KRS krs, int idKrs) {
        return krsDAO.update(krs, idKrs);
    }

    public int delete(int idKrs) {
        return krsDAO.delete(idKrs);
    }
}
