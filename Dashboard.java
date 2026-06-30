package model;

/**
 *
 * @author ASUS
 */
public class Lecturer extends Person {

    private String nidn;
    private String expertise;

    public Lecturer(String idCard, String name, String nidn, String expertise) {
        super(idCard, name);
        this.nidn = nidn;
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return this.name; // Valid karena 'name' di kelas Person bersifat protected
    }

    // Getter untuk digunakan oleh LecturerDAO
    public String getIdCard() {
        return this.idCard; // Mengakses idCard milik Person
    }

    public String getName() {
        return this.name; // Mengakses name milik Person
    }

    public String getNidn() {
        return nidn;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
