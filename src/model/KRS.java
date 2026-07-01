package model;
import model.Lecturer;
import model.Course;

/**
*
* @author KOMANG-NATAYA
*/
public final class KRS {
    private Course course;
    private double score;
    private String grade;
    private Lecturer lecturer;
    private int semester;

    public KRS(Course course, double score) {
        
        this.course = course;
        this.score = score;
        this.grade = setGrade();
    }
    public KRS() {
        this.course = course;
        this.score = score;
        this.grade = setGrade();
    }
    public void setLecturer(Lecturer lecturer){ 
        this.lecturer=lecturer;
    }
    public void setSemester(int semester) {
        this.semester=semester;
    }
    public Lecturer getLecturer() {
        return lecturer;
    }
    public Course getCourse() { 
        return course;
    } 
    public double getScore() { 
        return score;
    }
    public String getGrade() { 
        return grade;
    } 

    public String setGrade() {
        
  
        if (score >= 85) 
            return "A";
        else if (score >= 75) 
            return "B";
        else if (score >= 60) 
            return "C";
        else return "D";
    }

    public int getSemester() {
        return semester;
    }


}
