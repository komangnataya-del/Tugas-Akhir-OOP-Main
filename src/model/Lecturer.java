package model;

/**
 *
 * @author KOMANG-NATAYA
 */
public class Lecturer extends Person {
    private String nidn;
    private String expertise;

    public Lecturer(String idCard, 
                    String name, 
                    String nidn, 
                    String expertise) {
        
        super(idCard, name);
        
        this.nidn = nidn;
        this.expertise = expertise;
    }
    public String toString(){
        return this.name;
    }

    public String getNidn() {
        return nidn;
    }

    public String getExpertise() {
        return expertise;
    }
}