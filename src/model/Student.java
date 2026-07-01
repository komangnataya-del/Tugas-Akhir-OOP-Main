package model;

import model.KRS;
import java.util.ArrayList;

public class Student extends Person {
    private String nim;
    private String studyProgram;
    private ArrayList<KRS> krsList = new ArrayList<>();

    public Student(String idCard, String name, String nim, String studyProgram) {
        super(idCard, name);
        this.nim = nim;
        this.studyProgram = studyProgram;
        krsList = new ArrayList<>();
    }

   
    public Student() {
        super("", "");
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }
    
    public String getStudyProgram() {
        return studyProgram;
    }

    public void addKRS(KRS krs) {
        krsList.add(krs);
    }

    public String getCardID() {
        return idCard;
    }

    public void setNim(String string) {
        this.nim = string;
    }

    public void setName(String string) {
      this.name = string;  
    }

    public void setCardID(String string) {
         this.idCard = string;
    }

    public void setStudiProgram(String string) {
         this.studyProgram = string;
    }
}